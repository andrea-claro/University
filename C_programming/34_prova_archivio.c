/***********************************************************************************************
*Scrivere un programma inerente all'archivio merci di un magazzino utilizzando ogni tipo di
*struttura dati conosciuta.
************************************************************************************************/

/*----------------LIBRERIE------------------------------------------------------*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
/*------------------STRUTTURA---------------------------------------------------*/
typedef struct archivio{
	char codice[8], nome[32];
	int quantita, anno_produzione;
}archivio;
/*--------------------PROTOTIPI-------------------------------------------------*/
void *inserimento(archivio *, int);
void stampa(int, archivio *);
/*---------------------MAIN-----------------------------------------------------*/
int main(void){

archivio *deposito;
int num_merce;

printf("\n--------------------------------------------------------------------");
printf("\ninserisci numero merci:\t");
scanf("%d", &num_merce);

deposito=inserimento(deposito, num_merce); //inserimento struttura in array
stampa(num_merce, deposito); //stampa della merce
}
/*---------------------STAMPA-----------------------------------------------------*/
void stampa(int numero, archivio *magazzino){
for(int k=0;k<numero;k++){
	printf("\nIl prodotto n%d posto in %X:\t%s   %s   %d   %d", (k+1), magazzino, 			(magazzino+k)->nome, (magazzino+k)->codice, (magazzino+k)->quantita, 			(magazzino+k)->anno_produzione);
	}
}
/*----------------INSERIMENTO-----------------------------------------------------*/
void *inserimento(archivio *magazzino, int numero){
magazzino=(archivio *)calloc(numero, sizeof(archivio)); //allocazione memoria array di struttura

for(int k=0;k<numero;k++){	
	printf("\ninserire nome prodotto n%d:\t", (k+1));
	scanf("%s", (magazzino+k)->nome);

	printf("inserire codice prodotto n%d:\t", (k+1));
	scanf("%s", (magazzino+k)->codice);

	printf("inserire quantita prodotto n%d:\t", (k+1));
	scanf("%d", &(magazzino+k)->quantita);

	printf("inserire anno produzione prodotto n%d:\t", (k+1));
	scanf("%d", &(magazzino+k)->anno_produzione);
	}
return magazzino;
}
