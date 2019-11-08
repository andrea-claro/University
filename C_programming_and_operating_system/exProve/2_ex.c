/*Scrivere un programma in linguaggio C che in sequenza:
 crei 2 pipe e un figlio (le 2 pipe saranno utilizzate per una comunicazione bidirezionale tra padre
e figlio);
 il padre, dopo la creazione del figlio, prenda in input dall’utente un nome di file;
 invii al figlio il nome del file utilizzando la prima pipe;
 faccia cercare al figlio il numero di vocali presenti nel file e faccia comunicare tale numero al
padre utilizzando la seconda pipe;
 faccia stampare al padre il numero ricevuto dal figlio..
*/
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void){

    int fdf[2],
        fdc[2];

    pid_t child;

    char* fileName= (char*)malloc(32*sizeof(char));

    int counter= 0;

    pipe(fdf);
    pipe(fdc);

    child= fork();

    

    if(child > 0){  //big boss process
        close(fdf[0]);
        close(fdc[1]);

        printf("insert file name:\t");
        scanf("%s", fileName);

        write(fdf[1], fileName, sizeof(fileName));

        read(fdc[0], &counter, sizeof(counter));

        printf("il numero di vocali nel file risulta:\t%d\n", counter);
        return 0;
    }



    else if(child == 0){    //child process
        close(fdf[1]);
        close(fdc[0]);

        read(fdf[0], fileName, sizeof(fileName));

        FILE* file;
        file= fopen(fileName, "r");
        
        char c;
        while(fscanf(file, "%c", &c) != EOF){
            if(c == 'a'  ||  c == 'e'  ||  c == 'i'  ||  c == 'o'  ||  c == 'u')
                counter++;
        }
               
        write(fdc[1], &counter, sizeof(counter));

        exit(0);
    }
}