/*
Sia P un processo padre e F1 un processo figlio. Il processo figlio provvederà a
testare l’esistenza di eventuali duplicati contenuti nel file NOMI.txt ed a
comunicare tale esito al padre utilizzando il proprio exit status. Nel caso di
esistenza di duplicati, il padre creerà un nuovo processo F2 che provvederà a
cancellare tutti i duplicati.
*/

#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <fcntl.h>
#include <string.h>

void main(void){

    FILE* file;

    char* word_1= (char*)malloc(sizeof(char)*32);
    char* word_2= (char*)malloc(sizeof(char)*32);

    fpos_t pos_1;

    pid_t sc;
    pid_t rc;

    int exit_status;

    if((file= fopen("testo.txt", "r+"))  ==  NULL)
            printf("there is no such a file name in the current directory\n");

    if((sc= fork())  <  0)
        printf("fork error you cannot create anymore process\n");

    if( !sc ){
        while((fscanf(file, "%s", word_1))  !=  EOF){
            fgetpos(file, &pos_1);

            while(fscanf(file, "%s", word_2)  !=  EOF)
                if(strcmp(word_1, word_2)  ==  0)
                    exit(1);

            fsetpos(file, &pos_1);
        }
        exit(0);
    }

    wait(&exit_status);
    
    if(exit_status  !=  0){
        printf("there is a duplicate in the file\n");

        if((rc= fork())  <  0)
            printf("fork error you cannot create anymore process\n");

        if( !rc ){
            fpos_t pos_2;
            fpos_t pos_3;
            fpos_t pos_4;

            char c;

            rewind(file);

            while((fscanf(file, "%s", word_1))  !=  EOF){
                fgetpos(file, &pos_1);
                
                while(fscanf(file, "%s", word_2)  !=  EOF){
                    if(strcmp(word_1, word_2)  ==  0){
                        fgetpos(file, &pos_3);
                        
                        while(fscanf(file, "%c", &c)  !=  EOF){
                            fgetpos(file, &pos_3);
                            fsetpos(file, &pos_4);
                            fprintf(file, "%c", c);
                            fgetpos(file, &pos_4);
                            fsetpos(file, &pos_3);
                        }
                        printf("****\n");
                        truncate("testo.txt", sizeof(word_2));
                        fsetpos(file, &pos_2);
                    }
                    fgetpos(file, & pos_4);
                    pos_2= pos_4;
                }
                
                fsetpos(file, &pos_1);
            }
            exit(0);
        }
    }
    else 
        printf("there is no duplicate in the file\n");

    wait(&exit_status);

    if(exit_status == 0)
        printf("no more duplicate\n");

    exit(0);
}