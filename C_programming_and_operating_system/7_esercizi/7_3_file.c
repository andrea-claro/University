/*
Si assuma di avere nella cwd un file di nome File1
Scrivere un codice C che:
scriva su standard output la parola “ordina”
mandi in esecuzione il comando sort File1
scriva su standard output la parola “fine”
*/
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/wait.h>

void main(void){
    

    printf("ordina\n");

    char* fn= (char*)malloc(32*sizeof(char));
    printf("insert file name:\t");
    scanf("%s", fn);

    int fd;
    if(open(fn, O_RDONLY)  <  0){
        printf("opening error\n");
        exit(-1);
    }

    pid_t p;
    if((p= fork())  <  0){
        printf("fork error\n");
        exit(-1);
    }

    else if( !p ){
        if(execlp("sort","sort", "-n", fn, NULL)  <  0)
            printf("sort error\n");
    }

    else{
        wait(&p);
        printf("\nend\n");
        exit(0);
    }
}