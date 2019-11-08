/********************************************************************************
* Il seguente file di testo risulta essere un ADT lista adibita all'uso di una lista
* concatenata di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object.h"
#include "modulo_lista_3.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct node{ //struttura nodo, raffigurante un elemento di una lista
  object item; // dato di tipo object, il dato è il singolo elemento della lista
  list next; //puntatore ad una struttura nodo
};

struct counter_nodes{ //struttura capo-lista, raffigurante un legenda della lista
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
/* 8) */static struct node* getNode( int, struct counter_nodes* );
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
8) getNode( int, struct counter_nodes* ) -> struct node*
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

8) getNode( pos, top ) -> node
                                  pre_condition: (pos >= 0) && (pos < sizeList( top )) && (top != NULL)
                                  post_condition: (node != NULL)

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
static struct node* scrollBackward( struct node* node, struct counter_nodes* top ){

  if( !node || !top )
    return NULL;

  else if( node == top ->first)
    return NULL;

  else{
    list browse = top ->first;

    while( browse ->next != node ){
      browse = scrollForward( browse );
    }

    return browse;
  }
}

int inserMinN( head top, object data, int n ){

  if( !top || n < 0 || n > top ->size || !data)
    return 0;

  list browse = top ->first;
  list min = browse;

  for( int k = 0; k < n || emptyNode( browse ); k++, browse = scrollForward( browse ) )
    if( min ->item > browse ->item )
      min = browse;

  browse = top ->first;
  int k = 0;

  while( browse ->next != min ){
    browse = scrollForward( browse );
    k ++;
  }

  if( addingNode( k, top, data ) )
    return 1;

  else
    return 0;
}

int estraiMaxN( head top, int n){

  if( !top || n < 0 || n > top ->size )
    return 0;

  list browse = top ->first;
  list max = browse;

  for( int k = 0; k < n || emptyNode( browse ); k++, browse = scrollForward( browse ) )
    if( max ->item < browse ->item )
      max = browse;

  browse = scrollBackward( max, top );

  browse ->next = max ->next;

  if( deleteNode( max ) ){
    top ->size--;
    return 1;
  }

  else
    return 0;
}

head insertList( int n ){

  if( n <= 0)
    return NULL;

  object data;
  head temp = createHead();

  for( int k = 0; k < n; k++ ){
    data = insertObject();
    if( !addingNode( 0, temp, data ) )
      return NULL;
  }

  return temp;
}

static void exchangeNode( struct counter_nodes* top, struct node* a, struct node* b){

  if( !top || !a || !b )
    return;
  a ->next = scrollForward( b );
  b ->next = a;

  int n = posList( a ->item, top );
  list browse = scrollTo( top, ( n - 1 ) );

  browse ->next = b;
}

static struct node* scrollForward( struct node* node ){

  if( !node )
    return NULL;

  else if( node ->next )
    node = node ->next;
    return node ;
}

head reverseList( head top ){

  if( !top )
    return NULL;

  head temp = createHead();

  list browse = top ->first;

  for(  int k = 0; browse; browse = scrollForward( browse ), k++  )
    if(  !addingNode( 0, temp, getItem( top, k ) ) )
      return NULL;

  return temp;
}

object getItem( head top, int pos ){

  if( pos <= 0 || pos > sizeList( top ) || !top )
    return 0;
  list temp = getNode( pos, top );
  return ( getObject( temp ->item ) );
}

int searchList( head top, object data){

  if( !data || !top )
    return 0;

  list temp = top ->first;

  do{
    if( compareObject( temp ->item, data ) )
      return 1;

    else
      temp = scrollForward( temp );
  }while( emptyNode( temp ) );

  return 0;
}

head cloneList( head top ){

  if( !top )
    return NULL;

  head temp =reverseList( top );
  temp = reverseList( temp );

  if( temp == top)
    return temp;
  else
    return NULL;
}

static struct counter_nodes* cloneHead( struct counter_nodes* top ){

  if( !top )
    return NULL;

  head temp = createHead();

  temp ->size= top ->size;

  return temp;
}

static struct node* cloneNode( struct node* node ){

  if( !node )
    return NULL;

  list temp = createList();

  temp ->item = getObject( node ->item);

  return temp;
}

void printList( head top ){

  if( !top )
    return;

  list browse = top ->first;

  do{
    printNode( browse );
    browse = scrollForward( browse );
  }while( emptyNode( browse ) );
}

void printPos( int pos, head top ){

  if ( pos < 0 || pos > top ->size || !top)
    return;

  list temp = top ->first;

  if ( !pos ){
    printNode( temp );
  }

  else{
    temp = scrollTo( top, pos );
    printNode( temp );
  }
}

static void printNode( struct node* node ){

  if( !node ){
    printf("\n Il nodo risulta vuoto\n");

    return;
  }

  printf("\nIl contenuto del nodo risulta:\t ");
  printObject( node ->item );
}

int deleteList( head top ){

  if( !top )
    return 0;

  while( emptyList( top ) ){
    list temp = top ->first;

    top ->first = temp ->next;

    if( deleteNode( temp ) ){
      top ->size--;
    }
  }

  if( sizeList( top ) == 0 )
    return 1;

  else
    return 0;

}

int deleteNode( list node ){

  if( !node )
    return 0;

  else{
    deleteObject( node ->item );
    free( node );

    return 1;
  }
}

int deletePos( int pos, head top ){

  if ( pos < 0 || pos > ( top ->size -1 ) || !top )
    return 0;

  list temp = top ->first;

  if ( !pos ){
    top ->first = temp ->next;

    if( deleteNode( temp ) ){
      top ->size--;

      return 1;
    }
    else
      return 0;
  }

  else{
    list browse = scrollTo( top, pos );

    temp = scrollTo( top, ( pos - 1 ) );
    temp ->next = browse ->next;

    if( deleteNode( browse ) ){
      top ->size--;

      return 1;
    }

    else
      return 0;
  }
}

int addingNode( int pos, head top, object data ){

  if ( pos < 0 || pos > top ->size || !top)
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
    list browse = scrollTo( top, pos );

    temp ->next = browse;
    browse ->next = temp;
    top ->size++;
    temp ->item = data;

    return 1;
  }
}

static struct node* scrollTo( struct counter_nodes* top, int pos){

  if ( pos < 0 || pos > top ->size || !top )
    return NULL;

  list temp = top ->first;

  for( int k = 0; k < pos && pos < top ->size; k++)
    temp = scrollForward( temp );

  return temp;
}

int posList( object data, head top ){

  if( !top || !data )
    return -1;

  list temp = top ->first;
  int k = 0;

  while( k < top ->size ){
    if( compareObject( data, temp ->item) )
      return k;
    temp = temp ->next;
    k++;
  }
  return -1;
}

static int emptyNode( struct node* node ){

  if( !node ->next)
    return 0;
  else
    return 1;
}

int emptyList( head top ){

  if( !top ->first )
    return 0;
  else
    return 1;
}

static struct node* getNode( int pos, struct counter_nodes* top ){

  if ( pos < 0 || pos > top ->size || !top)
    return NULL;

  list temp = top ->first;

  for( int k = 0; k < pos; k++){
    temp = temp ->next;
  }

  return temp;
}

int sizeList( head top ){
  if( !top )
    return 0;
  else
    return top ->size;
}

static struct node* createList( void ){

  list temp;

  temp = malloc( sizeof( struct node ) );
  if(! temp )
    return NULL;

  temp ->next = NULL;
  temp ->item = newObject( );

  return temp;
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
