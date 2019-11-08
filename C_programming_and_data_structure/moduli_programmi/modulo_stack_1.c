/********************************************************************************
* Il seguente file di testo risulta essere un ADT pila adibita all'uso di uno stack
* di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object.h"
#include "modulo_stack.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct counter_stack{ //struttura capo-pila, raffigurante una legenda dello stack
  int size; //dato che serve a ricordare quanti elementi sono presenti nello stack
  list stack; //puntatore ad una struttura nodo
};

struct node{ //struttura nodo, raffigurante un elemento di una pila
  object item; // dato di tipo object, il dato è il singolo elemento della pila
  pile behind; //puntatore ad una struttura nodo
};



/*-------------------------------OPERATORI------------------------------------*/
object getItem( head top ){

  pile = top ->first;

  return getObject( pile ->item );
}

int pop( head top ){

  if( !top )
    return 0;

  pile browse = top ->first;

  top ->first = browse ->behind;
  browse ->item = deleteObject();
  top ->size--;
  free( browse );

  return 1;
}

int pushStack( head top ){

  if( !top )
    return 0;

  pile temp = createNode();

  temp ->item = insertObject();
  temp ->behind = top ->stack;
  top ->stack = temp;
  top ->size++;

  return 1;
}

int emptyStack( head top ){

  if( !top ->stack )
    return 1;

  else
    return 0;
}

pile createNode( void ){

  pile temp;

  temp = malloc( sizeof( struct node ) );
  if( !temp )
    return NULL;

  temp ->item = NULL;;
  temp ->behind = NULL;

  return temp;
}

head createHead( void ){

  head temp;

  temp = malloc( sizeof( struct counter_stack ) );
  if( !temp )
    return NULL;

  temp ->size = 0;
  temp ->stack = NULL;

  return temp;
}
