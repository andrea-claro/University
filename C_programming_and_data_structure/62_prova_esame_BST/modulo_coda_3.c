/********************************************************************************
* Il seguente file di testo risulta essere un ADT pila contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di uno stack
* di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object_struct.h"
#include "modulo_coda_3.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct node{ //struttura nodo raffigurante un elemento della pila
  object item; //oggetto condenuto all'interno del nodo di tipo object
  struct node* next; //puntatore ad un altra struttura nodo
};

struct counter_nodes{ //struttura capo coda raffigurante una legenda di essa stessa
  int size; //marcatore di grandezza della coda
  struct node *head, //puntatore di testa della coda ad una struttura noda
              *tail; //puntatore di coda della coda ad una struttura nodo
};



/*-------------------------------OPERATORI------------------------------------*/
object deQueue( queue top ){

  if( emptyQueue(top) || !top ->size )
      return newObject();

  point browse= top ->head;
  object temp= getObject( browse ->item );

  top ->head= browse ->next;
  free( browse );

  if( emptyNode(top ->head) )
      top ->tail= NULL;

  top ->size--;

  return temp;
}



int enQueue( queue top, object data ){

  if( emptyQueue(top) )
      return 0;

  point new= createPoint();
  new ->item= data;

  if( emptyNode(top ->head) )
      top ->head= new;
  else{
      point temp= top ->tail;
      temp ->next= new;
  }

  top ->tail= new;
  top ->size++;

  return 1;
}



int emptyQueue( queue top ){

  return (top == NULL)?1:0;
}



int emptyNode( point dot ){

  return (dot == NULL)?1:0;
}



point createPoint( void ){

  point new= malloc(sizeof(struct node));
  if( !new )
      return NULL;

  new ->next= NULL;
  new ->item= newObject();

  return new;
}



queue createQueue( void ){

  queue new= malloc(sizeof(struct counter_nodes));
  if( !new )
      return NULL;

  new ->head= NULL;
  new ->tail= NULL;
  new ->size= 0;

  return new;
}
