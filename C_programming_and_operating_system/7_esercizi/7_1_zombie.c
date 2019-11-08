/*
Scrivere un programma che crei un processo
zombie.
Fare in modo che un processo figlio diventi figlio del
processo init.
*/

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(){ 

    pid_t pid;

    printf("pid processo= %d\n\n", getpid());
    system("ps -T");

    if ((pid=fork()) < 0)
        printf("fork error\n");

    else if (!pid){ /* figlio */
        while(pid);

        printf("\npid figlio= %d\tpid padre= %d\n", getpid(), getppid());
        system("ps -T");
        printf("\n");
        printf("\npid figlio= %d\tpid padre= %d\n", getpid(), getppid());
        system("ps -T");
        printf("\n");

        exit(0);
    }

    else if(pid){
        printf("\npid backpid= %d\n", getppid());
        execlp("kill", getpid(), NULL);
        exit(0);
    }
}