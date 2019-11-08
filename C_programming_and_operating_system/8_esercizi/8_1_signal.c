/*
scrivere un programma che intercetta il ctrl-C da
tastiera (SIGINT) e gli fa stampare un messaggio.
*/


/*
void (*signal(int signo, void (*func)(int)))(int);
Restituisce: SIG_ERR in caso di errore e il puntatore
al precedente gestore del segnale se OK
*/

#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h>
#include <signal.h>

void myCommand(int);

void main(void){

    while(1){
        signal(SIGINT, myCommand);
    }
}

void myCommand(int signo){
    if(signo == SIGINT){
        printf("\nI want to print and not to kill\n");
    exit(0);
    }
}