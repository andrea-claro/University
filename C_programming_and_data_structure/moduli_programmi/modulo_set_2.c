/********************************************************************************
* Il seguente file di testo risulta essere un ADT insieme ordinato contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di un insieme ordinato 
* di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object.h"
#include "modulo_lista_5.h"
#include "modulo_set_2.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct counter_sets{ //struttura capo raffigurante il principio dell'insieme ordinato
    head top; //puntatore ad una struttura capo di una lista
};



/*-------------------------------OPERATORI------------------------------------*/
set insertSet( int n ){

  if(n <= 0)
      return NULL;

  set temp= createSet();

  for( int k= 0; k < n; k++ ){
      if( !addNumber(temp, insertObject()) )
          return NULL;
  }

  return temp;
}


int emptySet( set first ){

  return(emptyList(first ->top) == 1)?1:0;
}



int addNumber( set first, object data ){

  int k;
  for( k= 0; (k<sizeList(first ->top)) && (getItem(first ->top, k) <= data); k++);

  return(addingNode(k, first ->top, data) == 1)?1:0;
}



void printSet( set first ){

  printList( first ->top );
}



set createSet( void ){

  set temp;

  temp= malloc(sizeof(struct counter_sets));
  if( !temp )
      return NULL;

  temp ->top= createHead();

  return temp;
}
