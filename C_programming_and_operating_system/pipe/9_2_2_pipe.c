#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <string.h>

int main(void){

    pid_t first;
    pid_t second;

    int filedes;
    int firstPid;

    if((first= fork()) < 0){
        printf("fork error\n");
        _exit(-1);
    }
    else if(first == 0){    //P2
        filedes= open("TEMP", O_WRONLY | O_TRUNC);

        int random;
        firstPid= getpid();

        while(1){
            random= rand();
            write(filedes, strcat(random+firstPid), sizeof(strcat(random+firstPid)));
            sleep(1);
        }
    }
    else{   //P1
        int fd[2];

        if(pipe(fd) < 0){
            printf("pipe error\n");
            _exit(-1);
        }

        close(fd[0]);

        if((second= fork()) < 0){
            printf("fork error\n");
            _exit(-1);
        }
        else if(second == 0){   //F1
            close(fd[1]);
        }
        sleep(20);
        write(fd[1], strcat())
    }
}