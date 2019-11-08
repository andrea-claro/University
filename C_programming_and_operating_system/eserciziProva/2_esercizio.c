/*
Scrivere un programma per il calcolo di statistiche sui caratteri presenti in un file di testo il cui
nome è specificato come primo parametro sulla riga di comando. Il programma considera tutti i
caratteri ad eccezione degli spazi e fornisce in uscita le seguenti statistiche:
 il numero di righe (paragrafi) presenti nel file (ogni riga è al più di 100 caratteri),
 il numero totale di caratteri (esclusi quelli di spaziatura),
 il numero massimo e minimo di caratteri di riga,
 la riga più lunga presente nel file.
*/

#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

void main(int argc, char* argv[]){
    
    if(argc  !=  2)
        exit(1);

    char c;
    int countLine= 0,
        countCharLine= 0,
        countChar= 0,
        maxLine= 0,
        minLine= 0,
        fd= open(argv[1], O_RDONLY);

    while( read(fd, &c, 1)  >  0){
        if(c  ==  ' ')  continue;
        if(c  ==  '\n'   ||   countCharLine  ==  100){  
            if(countCharLine  >  maxLine)   
                maxLine= countCharLine;
            else if(countCharLine  <  minLine)
                minLine= countCharLine;
            countLine++;
            countCharLine= 0;
        }
        countCharLine++;
        countChar++;
    }
    printf("# caratteri: %d\n# paragrafi: %d\n# max caratteri per riga: %d\n# min caratteri per riga: %d\n", countChar, countLine, maxLine, minLine);
    exit(0);
}