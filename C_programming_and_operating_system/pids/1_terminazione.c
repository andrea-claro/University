#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
void main(void){
    int dpid;
    int cpid;
    int tdpid;

    dpid= fork();

    if(dpid == 0){
        printf("Sono in figlio %d\n", getpid());
        exit(0);
    }
    else{
        wait(&tdpid);
        printf("figlio terminato con %d\n", tdpid);
        printf("Sono il padre %d\n", getpid());
    }

    exit(0);
}