/******************************************************************************************************
** Creating a file that in this case is going to work with a structure that creates a list of elements
*******************************************************************************************************/

/*------------------------------LIBRERIE--------------------------------*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#include "item.h"
#include "list.h"
#include "libretto.h"

/*-----------------------STRUTTURA LIBRETTO----------------------------*/
struct libre{ //struttura libretto
  head top; //struttura di inizio lista
  char nome_studente[15];
  int matricola;
};

/*----------------------CREAZIONE DI UN LIBRETTO-----------------------*/
book newLibre( void ){ //creazione ed inizializzazione della struttura libretto

  struct libre *temp;

  temp = malloc ( sizeof( struct libre) );
  if( !temp )
    exit(1);

  temp ->top = newHeadList();
  strcpy( temp ->nome_studente, "null" );
  temp ->matricola = 0;

  return temp;
}

/*------------------INSERIMENTO DI ESAMI NEL LIBRETTO-----------------*/
book insertLibre( char *data[], struct libre *libro){ //inserimento di altri dati all'interno del libretto

  int n;

  n = atoi( data[1] );

  libro ->matricola = n;
  libro ->top = addingItem( libro ->top );
  strcpy( libro ->nome_studente, data[2] );

  return libro;
}

/*---------------------STAMPA DEL LIBRETTO---------------------------*/
void printLibre( struct libre *libro ){ //stampa della lista

  printf("\nIl libretto di %s, con matricola %d", libro ->nome_studente, libro ->matricola);

  struct libre *temp;

  temp = libro;

  printList(temp ->top);
}
