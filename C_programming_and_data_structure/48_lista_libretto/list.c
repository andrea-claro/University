/*****************************************************************************
** Creating the list file that in this case is going to work with a structure
******************************************************************************/

/*------------------------------LIBRERIE--------------------------------*/
#include<stdio.h>
#include<stdlib.h>

#include "item.h"
#include "list.h"

/*----------------------------STRUTTURE LISTA--------------------------*/
struct node{ //struttura punto della lista (un punto dei tanti)
  item object; //struttura dereferenziata all'oggetto item presente nel file importato item
  list next; //puntatore ad un punto della lista
};

struct counter_nodes{ //struttura punto testa della lista (punto di partenza dei tanti)
  list first; //puntatore ad un punto della lista
  int size; //dimensione della lista
};

/*-------------------------CREAZIONE DI UN CONTATORE DI LISTA----------*/
struct counter_nodes* newHeadList( void ){ //creazione ed inizializzazione di un punto testa di lista

  head temp;

  temp = malloc( sizeof( head ) );
  if( !temp )
    exit(1);

  temp ->first = NULL;
  temp ->size = 0;

  return temp;
}

/*-----------------------CREAZIONE DI UN NODO DELLA LISTA-------------*/
struct node* newTopList( void ){ //creazione ed inizializzazione di un punto della lista di oggetti

  list temp;

  temp = malloc( sizeof( list ) );
  if( !temp )
    exit(1);

  temp ->object = NULL;;
  temp ->next = NULL;

  return temp;
}

/*-------------------AGGIUNTA DI UN ESAME ALLA LISTA-----------------*/
struct counter_nodes* addingItem( head top ){ //inserimento di un punto nella lista

  list temp;

  temp = newTopList();
  temp ->object = newItem();

  temp ->next = top ->first; /******************************************************************/
  top ->first = temp;        /* passaggi utilizzati per il collegamento di un punto alla lista */
  top ->size++;              /******************************************************************/

  return top;
}

/*------------------STAMPA DELLA LISTA DI ESAMI---------------------*/
void printList( head top ){ //stampa della lista

  printf(" e %d esami dati\n", top ->size);

  list temp;

  temp = top ->first;               /* passaggi necessari per lo scorrimento della lista */

  printf("\nFLAG\n");

  printItem( temp ->object );

  while( temp ->next !=NULL ){                    /* utilizzazto per la stampa di essa stessa          */
    printf("\nFLAG\n");
    temp = temp ->next;
    printItem( temp ->object );     /*****************************************************/
  }
}

/*------------------RICERCA DI UN ELEMENTO-------------------------*/
int searchList( head top, char *word){ //ricerca di un esame tra gli esami presenti in lista

  int flag; //elemento di ritorno per il valore di verità sulla presenza della ricerca
  struct node *temp;

  temp = newTopList();

  temp = top ->first;                         /* passaggi necessari per lo scorrimento della lista        */
  while( temp ){             /* utilizzato per la clonazione e la ricerca al suo interno */
    flag = searchItem( temp ->object, word ); /************************************************************/
    temp = temp ->next;                       /************************************************************/
  }
  free(temp);
  return flag;
}
