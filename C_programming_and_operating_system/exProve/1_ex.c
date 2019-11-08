/*
Scrivere un programma in linguaggio C dove:
 vengano create 2 pipe e un figlio (le 2 pipe saranno utilizzate per una comunicazione
bidirezionale tra padre e figlio);
 il padre, dopo la creazione del figlio, prenda in input dall’utente un nome di file;
 il padre invii al figlio il nome del file utilizzando la prima pipe;
 il figlio cerchi il numero di stringhe presenti nel file che abbiano la stessa lunghezza del nome
del file e faccia comunicare tale numero al padre utilizzando la seconda pipe (se il nome del file
è pippo dovrà essere trovato il numero di stringhe lunghe 5);
 faccia stampare al padre il numero ricevuto dal figlio..
*/
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void)
{

    char *fileName = (char *)malloc(32 * sizeof(char));
    if (!fileName)
    {
        printf("no more space\n");
        return -1;
    }

    int nWord = 0;
    int fdf[2],
        fdc[2];

    pid_t child;

    if ((pipe(fdf) < 0) || (pipe(fdc) < 0)){    //creazione pipe
        printf("pipe error\n");
        return -1;
    }
    
    if ((child = fork()) < 0){  //creazione figlio
        printf("fork error\n");
        return -1;
    }

    else if (child == 0){   //figlio
        close(fdf[1]);
        close(fdc[0]);
        
        read(fdf[0], fileName, sizeof(fileName));    //leggere nome file da pipe
        
        char *word_2 = (char *)malloc(32 * sizeof(char));   //parola di confronto per lunghezza
        if (!word_2){
            printf("no more space\n");
            return -1;
        }

        FILE* file; //apertura file
        if ((file=fopen(fileName, "r")) == NULL){
            printf("opening error\n");
            return -1;
        }
        while (fscanf(file, "%s", word_2) != EOF){  //lettura delle parole in file                                
            if (strlen(fileName) == strlen(word_2)) //confronto lunghezze parole    
                nWord++;
        }
        write(fdc[1], &nWord, sizeof(nWord));   //scrittura in pipe numero parole con uguale lungheza
        
        exit(0);
    }

    else{   //padre
        close(fdf[0]);
        close(fdc[1]);

        printf("insert file name:\t");
        scanf("%s", fileName);  //inserimento nome file da tastiera
        
        write(fdf[1], fileName, sizeof(fileName));  //scrittura nome file sulla pipe

        read(fdc[0], &nWord, sizeof(nWord));    //ricezione numero parole con la stessa lunghezza da pipe
        
        printf("there are %d word in the file with same length\n", nWord);    //stampa del numero di parole con la stessa lunghezza
        
        return 0;
    }
}