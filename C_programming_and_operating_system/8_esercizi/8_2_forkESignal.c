/* 
Scrivere un programma che prende in input dall'utente il nome
di un fle ed esegue (tramite fork+exec) un programma che
restituisce all'utente l'elenco dei seguenti attributi del fle:
 Tipo di fle
 Permessi
 ID number del proprietario del fle
 Dimensione del fle (se regolare)
Alla fne dell'esecuzione il processo fglio comunicherà al padre
l'esistenza o meno del fle di cui testare le caratteristiche.
*/

#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>


void myCommand(int);


void main(void){

    char* fileName= (char*)malloc(sizeof(char)*32);

    printf("insert file name:\t");
    scanf("%s", fileName);

    int fd;
    int p= fork();

    if( !p ){
        if((fd= open(fileName, O_RDONLY))  <  0){
            kill(getppid(), SIGALRM);
            exit(1);
        }
        exit(0);
    }

    signal(SIGALRM, myCommand);
    wait(&p);
    
    if(p  !=  0){
        printf("there is no file\n");
        exit(1);
    }

    if(execlp("ls", "ls", "-l", fileName, NULL)  <  0)
        exit(1);

    exit(0);
}

void myCommand(int signo){
    if(signo  ==  SIGALRM){
        printf("alarm there is no file\n");
    }
}