#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include<sys/wait.h>


char* getFile(void);
void linking(int []);
void concatFile(char*);
void viewFile(void);

pid_t first;
pid_t second;

int main(void){
    char* fileName= getFile();
    int fd[2];

    linking(fd);

    if(first == 0){
        concatFile(fileName);
    }
    
    if(second == 0){
        viewFile();
    }
}

void viewFile(void){
    execlp("more","more",(char *)0);
}

void concatFile(char* fileName){

     execlp("cat", "cat", fileName, (char *)0);
}

char* getFile(void){
    char* word= (char*) malloc(32*sizeof(char));

    printf("Insert file name:\t");
    scanf("%s", word);

    return word;
}

void linking(int fd[]){
    if(pipe(fd) < 0){
        printf("pipe error\n");
        _exit(-1);
    }
        
    else{
        if((first= fork()) < 0){
            printf("fork error\n");
            _exit(-1);
        }
        
        else if(first == 0){    //primo figlio
            close(fd[0]);
            close(1);
            dup(fd[1]);
            close(fd[1]);
        }

        else{ //padre
            if((second= fork() < 0)){
                printf("fork error\n");
                _exit(-1);
            }

            else if(second == 0){   //secondo figlio
                close(fd[1]);
                close(0);
                dup(fd[0]);
                close(fd[0]);
            }

            close(fd[0]);
            close(fd[1]);
            wait(NULL);
            wait(NULL);
        }
    }
}