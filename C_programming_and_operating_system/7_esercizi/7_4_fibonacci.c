/*
La successione di Fibonacci (0,1,1,2,3,5,8,…) è definita ricorsivamente da
 f0= 0
 f1= 1
 fn= fn-1 + fn-2
 Scrivere un programma C, che usi la chiamata di sistema fork(), per
generare la successione di Fibonacci all’interno del processo figlio.
 Il processo figlio produrrà anche le relative stampe.
 Il padre dovrà rimanere in attesa tramite wait() fino alla terminazione del
figlio.
 Il numero di termini da generare sarà specificato a riga di comando.
Implementare i necessari controlli per garantire che il valore in ingresso sia
un numero intero non negativo. 
*/
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>


#define FO 0;
#define FI 1;

void main(void){

    pid_t p;
    int n, fib= 0;

    do{
        printf("insert n fibonacci:\t");
        scanf("%d", &n);
    }while(n < 0);

    p= fork();
    if(!p){
        int b= FO;
        int a= FI;

        for(int k= 1; k < n; k++){
             fib= a+b;
             printf("%d= %d+%d\n", k, a, b);
             b=a;
             a=fib;
        }

        printf("fib= %d\n", fib);
        exit(0);
    }
    wait(&p);

    printf("fine\n");
    exit(0);
}