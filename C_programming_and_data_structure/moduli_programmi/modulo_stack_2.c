/********************************************************************************
* Il seguente file di testo risulta essere un ADT pila contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di uno stack
* di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object.h"
#include "modulo_lista_5.h"
#include "modulo_stack_2.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct counter_stack{ //struttura capo-pila, raffigurante una legenda dello stack
  head top; //puntatore ad una struttura nodo
};



/*-------------------------------OPERATORI------------------------------------*/
object getFirst( pile first ){

  return ( getItem(first ->top, 0) );
}

int popStack( pile first ){

  return (deletePos(0, first ->top) == 1)?1:0;
}

int pushStack( pile first, object data ){

  return (addingNode(0, first ->top, data) == 1)?1:0;
}

int emptyStack( pile first ){

  return (emptyList(first->top) == 1)?1:0;
}

pile createPile( void ){

  pile new= malloc(sizeof(struct counter_stack));
  if( !new )
      return NULL;

  new ->top= createHead();

  return new;
}
