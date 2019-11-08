/********************************************************************************
* Il seguente file di testo risulta essere un ADT lista adibita all'uso di una lista
* concatenata di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_canzone.h"
#include "modulo_lista_3.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct node{ //struttura nodo, raffigurante un elemento di una lista
  object item; // dato di tipo object, il dato è il singolo elemento della lista
  list next; //puntatore ad una struttura nodo
};

struct counter_nodes{ //struttura capo-lista, raffigurante una legenda della lista
  int size; //dato che serve a ricordare quanti elementi sono presenti nella lista
  list first; //puntatore ad una struttura nodo
};



/*-----------------------OPERATORI NASCOSTI UTILIZZATI------------------------*/
/* 1) */static struct node* scrollForward( struct node* );
/* 2) */static struct counter_nodes* cloneHead( struct counter_nodes* );
/* 3) */static struct node* cloneNode( struct node* );
/* 4) */static void printNode( struct node* );
/* 5) */static struct node* scrollTo( struct counter_nodes*, int);
/* 6) */static int emptyNode( struct node* );
/* 7) */static struct node* createList( void );
/* 8) */static object getNode( int, struct counter_nodes* );
/* 9) */static void exchangeNode( struct counter_nodes*, struct node*, struct node* );
/* 10) */static struct node* scrollBackward( struct node*, struct counter_nodes* );
/*----------------------------------------------------------------------------*/



/*----------------------DESCRIZIONE OPERATORI NASCOSTI--------------------------
1)scorrere un puntatore a nodo in avanti
2)creare un clone della testa della lista
3)creare un clone di un nodo della lista
4)stampare i dati di un nodo
5)scorrere un puntatore a nodo sino ad una data posizione
6)ricavare come informazione se il puntatore a nodo punterà a null
7)creare un nodo
8)ricavare un nodo presente in una data posizione
9)scambiare due nodi tra loro se all'inizio della lista
10)scorrere un puntatore a nodo indietro
------------------------------------------------------------------------------*/



/*-----------------SPECIFICA SINTATTICA OPERATORI NASCOSTI----------------------
1) scrollForward( struct node* ) -> struct node*
2) cloneHead( struct counter_nodes* ) -> struct counter_nodes*
3) cloneNode( struct node* ) -> struct node*
4) printNode( struct node* ) -> void
5) scrollTo( struct counter_nodes*, int) -> struct node*
6) emptyNode( struct node* ) -> int
7) createList( void ) -> struct node*
8) getNode( int, struct counter_nodes* ) -> object
9) exchangeNode( struct counter_nodes*, struct node*, struct node* ) -> void
10) scrollBackward( struct node*, struct counter_nodes* ) -> struct node*
------------------------------------------------------------------------------*/



/*------------------SPECIFICA SEMANTICA OPERATORI NASCOSTI----------------------
1) scrollForward( node ) -> nodeNext
                                  pre_condition: (node != NULL)
                                  post_condition: (nodeNext != NULL)

2) cloneHead( top ) -> clone
                                  pre_condition: (top != NULL)
                                  post_condition: (clone != NULL)

3) cloneNode( node ) -> clone
                                  pre_condition: (node != NULL)
                                  post_condition: (clone != NULL)

4) printNode( node ) -> void
                                  pre_condition: (node != NULL)
                                  post_condition: stampa del nodo richiesto

5) scrollTo( top, pos ) -> node
                                  pre_condition: (pos >= 0) && (pos < sizeList( top )) && (top != NULL)
                                  post_condition: (node != NULL)

6) emptyNode( node ) -> flag
                                  pre_condition: (node != NULL)
                                  post_condition: (flag = 1 se nodo punta ad un altro elemento) || (flag = 0 se nodo
                                                  sta puntando a NULL)

7) createList( ) -> node
                                  pre_condition:
                                  post_condition: (node != NULL)

8) getNode( pos, top ) -> info
                                  pre_condition: (pos >= 0) && (pos < sizeList( top )) && (top != NULL)
                                  post_condition: (info != NULL)

9) exchangeNode( top, a, b ) -> void
                                  pre_condition: (top != NULL) && (a != NULL) && (b != NULL)
                                  post_condition: (top = < a ->b ->c ->d ->... ->n> diventa
                                                  top = < b ->a ->c ->d ->... ->n)

10) scrollBackward( node, top ) -> nodeBack
                                  pre_condition: (top != NULL) && (node != NULL)
                                  post_condition: (top = <e_1, e_2, e_3, ..., e_n> && node = e_3 ->
                                                  nodeBack = e_2)
------------------------------------------------------------------------------*/



/*-------------------------------OPERATORI------------------------------------*/

/*
funzione da controllare per l'eliminazione ricorsiva dei primi x elementi
head deleteListRicor( head top, int x ){

  if( !top || !x )
    return top;

  else
    return deleteListRicor( (top ->first ->next), (x -1) )
}
*/
int posObject( object data, head top){

  if( emptyList( top ) || !data )
    return -1;

  list temp = top ->first;
  int k;

  for( k = -1; !emptyNode( temp ) && k < sizeList( top ) && temp ->item != data; k++, browse = scrollForward( browse ) );
      return (k + 1);
}

int addingNode( int pos, head top, object data ){

  if ( pos < 0 || pos > sizeList( top ) || emptyList( top ) )
    return 0;

  list temp = createList();

  if( !pos ){
    temp ->next = top ->first;
    top ->first = temp;
    top ->size++;
    temp ->item = data;

    return 1;
  }

  else{
    list browse = scrollTo( top, (pos - 1) );

    temp ->next = browse ->next;
    browse ->next = temp;
    top ->size++;
    temp ->item = data;

    return 1;
  }
}


int deletePos( int pos, head top ){

  if ( pos < 0 || pos > sizeList( top ) || emptyList( top ) )
    return 0;

  list temp = top ->first;

  if ( !pos ){
    top ->first = temp ->next;
    deleteNode( temp );
    top ->size--;

    return 1;
  }

  else{
    list browse = scrollTo( top, pos );
    temp = scrollBackward( browse, top );
    temp ->next = browse ->next;

    deleteNode( browse );
    top ->size--;

    return 1;
    }
}

int deleteList( head top ){

  if( emptyList( top ) )
    return 0;

  while( !emptyList( top ) ){
    list temp = top ->first;

    top ->first = temp ->next;

    if( deleteNode( temp ) ){
      top ->size--;

    else
      return 0;
    }
  }

  if( !sizeList( top ) )
    return 1;

  else
    return 0;

}

void printPos( int pos, head top ){

  if ( pos < 0 || pos > sizeList( top ) || emptyList(top) )
    return;

  list browse = top ->first;

  for( int k = 0; k < pos && !emptyNode( browse ); k++, browse = scrollForward( browse ) );

  printNode( browse );
}

void printList( head top){

  if( emptyList( top ) ){
    printf("\n\nla lista e' vuota\n\n");
    return;
  }

  head temp = cloneList( top );
  list browse = temp ->first;

  for( ; !emptyNode( browse ); browse = scrollForward(browse) )
    printNode( browse );

  deleteList( temp );
}

head cloneList( head top ){

  if( !top )
    return NULL;

  head temp =reverseList( top );
  temp = reverseList( temp );

  return( temp == top )?temp:NULL;
}

int searchList( head top, object data){

  if( !data || emptyList( top ) )
    return 0;

  list browse = top ->first;

  while( !emptyNode( browse ) ){
    if( compareObject( browse ->item, data ) )
      return 1;

    else
      browse = scrollForward( browse );
  }

  return 0;
}


head reverseList( head top ){

  if( !top )
    return NULL;

  head temp = createHead();

  list browse = top ->first;

  for(  int k = 0; browse; browse = scrollForward( browse ), k++  )
    if(  !addingNode( 0, temp, browse ->item ) )
      return NULL;

  return temp;
}


head insertList( int n ){

  if( n < 0 )
    return NULL;

  head temp = createHead();

  for( int k = 0; k < n; k++ ){
    if( !addingNode( k, temp, insertObject() ) )
      return NULL;
  }

  return temp;
}

//Nella funzione getitem il valore di ritorno non sarà object ma bisogna cambiarlo a secondo di
//cosa ritorna nel modulo_Object.c la funzione getObject
object getItem( head top, int pos ){

  if( emptyList( top ) || pos < 0 || pos > sizeList( top ) )
    return NULL;

  return ( getObject( getNode( pos, top ) ->item ) );
}

int estraiMaxN( head top, int pos ){

  if( emptyList( top ) || pos < 0 || pos > sizeList( top ) )
    return 0;

  list browse = top ->first;
  list max = browse;

  for( int k = 0; k < pos && !emptyNode( browse ); k++, browse = scrollForward( browse ) )
    if( getObject( max ->item) < getObject( browse ->item ) )
      max = browse;

  browse = scrollBackward( max, top );

  browse ->next = max ->next;

  deleteNode( max );
    top ->size--;

    return 1;
}

int inserMinN( head top, object data, int pos ){

    if( emptyList( top ) || pos < 0 || pos > sizeList( top ) || !data )
      return 0;

    list browse = top ->first;
    list min = top ->first;

    for( int k = 0; k < pos && !emptyNode( browse ); k++, browse = scrollForward( browse ) )
      if( getObject( min ->item ) > getObject( browse ->item ) )
        min = browse;

    browse = top ->first;
    int k = 0;

    for( k; browse != min && !emptyNode( browse ); k++, browse = scrollForward( browse ) );

    if( addingNode( k, top, data ) )
      return 1;

    else
      return 0;
}

void deleteNode( list point ){

  deleteObject( point ->item );
  free( point );
}

static struct counter_nodes* cloneHead( struct counter_nodes* top){

  if( !top )
    return NULL;

  head temp = createHead();

  temp ->size = top ->size;
  temp ->first = NULL;

  return temp;
}

static void printNode( struct node* point ){

  if( emptyNode( point ) ){
    printf("\n\nIl nodo e' vuoto\n\n");
    return;
  }

  printf("\nIl contenuto del nodo risulta:\t ");
  printObject( node ->item );
}

static object getNode( int pos, struct counter_nodes* top ){

  if( emptyList( top ) || pos > sizeList( top ) || pos < 0 )
    return NULL;

  list browse = top ->first;
  for( int k = 0; !emptyNode( browse ) && k < pos; k++, browse = scrollForward( browse ) );

  return browse;
}

static void exchangeNode( struct counter_nodes* top, struct node* one, struct node* two ){

  if( emptyList( top ) || !a || !b )
    return;

  one ->next = scrollForward( two );
  two ->next = one;

  int n = posObject( one ->item, top );
  list browse = scrollTo( top, ( pos - 1 ) );

  browse ->next = two;
}

static struct node* scrollTo( struct counter_nodes* top, int pos){

  if( emptyList( top ) || pos > sizeList( top ) || pos < 0 )
    return NULL;

  list browse = top ->first;

  for( int k = 0; k < pos && !emptyNode( browse ); browse = scrollForward( browse ), k++ );

  return browse;
}

static struct node* scrollBackward( struct node* point, struct counter_nodes* top){

  if( emptyList( top ) || emptyNode( point ) )
    return NULL;

  list browse = top ->first;

  for( ; !emptyNode( browse ) && browse != point; browse = scrollForward( browse ) );

  return browse;

}

static struct node* scrollForward( struct node* point){

  return (point ->next)
}

int emptyList( head top ){

  if( emptyNode( top ->first ) )
    return 1;

  else
    return 0;
}

int sizeList( head top ){

  if( emptyList( top ) )
    return 0;

  list temp = top ->first;
  int k;

  for( k = 0; !emptyNode( temp ); k++ )
    temp = scrollForward( temp );

  top ->size = k;

  return k;
}

static struct node* cloneNode( struct node* point ){

  if( emptyNode( point ) )
    return NULL;

  struct node* temp = createList();

  temp ->item = point ->item;
  temp ->next = NULL;

  return temp;
}

static int emptyNode( struct node* point ){

  if( !point )
    return 1;

  else
    return 0;
}

head createHead( void ){

  head temp;

  temp = malloc( sizeof( struct counter_nodes ) );
  if( !temp )
    return NULL;

  temp ->size = 0;
  temp ->first = NULL;

  return temp;
}

static struct node* createList( void ){

  struct node* temp;

  temp = malloc( sizeof( struct node ) );
  if( !temp )
    return NULL;

  temp ->item = NULL;
  temp ->next = NULL;

  return temp;
}
