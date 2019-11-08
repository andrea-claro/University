/*******************************************************************************
** Creating the item file that in this case is going to be an entire structure
*******************************************************************************/

/*------------------------------LIBRERIE--------------------------------*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include "item.h"

/*-----------------------------STRUTTURA--------------------------------*/
struct exam{ //struttura esame
  char name[15], //nome della materia di esame
       date[15]; //data in cui è stato preso l'esame
  int mark; //voto preso all'esame
};

/*-----------------------------CREAZIONE STRUTTURA ESAME---------------*/
struct exam* newItem( void ){ //funzione per la creazione di una struttura

  item temp; //variabile temporanea che torna i valori all'interno della struttura

  temp = malloc( sizeof( struct exam ) );
  if( !temp )
    exit(1); //controllo della creazione di memoria

  temp = insertItem(temp);

  return temp;
}

/*--------------------STAMPA DELLA STRUTTURA ESAME-------------------*/
void printItem( item temp ){ //funzione per la stampa di una struttura
  printf("\nL'esame di %s e dato il %s, ha una votazione di %d\n", temp ->name, temp ->date, temp ->mark);
}

/*----------------------INSERIMENTO DATI NELLA STRUTTURA-------------*/
item insertItem(item temp){ //funzione per l'inserimento dei dati nella struttura

  printf("\nInserisci nome materia:\t[max 15 caratteri]\n");
  scanf("%s", temp ->name);
  printf("Inserisci voto %s:\t", temp ->name);
  scanf("%d", & ( temp ->mark ) );
  printf("Inserisci la data di quando e' stato preso l'esame di %s\t[gg-mm-yyyy]\n", temp ->name);
  scanf("%s", temp ->date);

  return temp;
}

/*-----------------------RICERCA DI UN ESAME------------------------*/
int searchItem( item temp, char *word){ //funzione per la ricerca di una struttura

  if( !strcmp( temp ->name, word ) )
    return 1; //valore di ritorno se la struttura è esistente
  else
    return 0; //valore di ritorno se la struttura è inesistente
}
