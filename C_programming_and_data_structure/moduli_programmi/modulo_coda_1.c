#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#include "modulo_object.h"
#include "modulo_coda_1.h"

struct counter_nodes{
  int size;
  struct node* first;
};

struct node{
  object item;
  struct node* next;
};

void deleteTail( head top ){

  if( emptyTail( top ) )
    printf("\nla coda e' vuota\n");

  while( !emptyTail( top ) ){
  browse = top ->first;

  top ->first = browse ->next;
  deleteNode( browse );
  }
}
void deleteNode( queue node ){

  if( !emtyNode( node ) ){
    deleteObject( node ->item );
    free( node );
  }
}
queue popTail( head top ){

  if( emptyTail( top ) )
    return NULL;;

  queue browse = top ->first;

  while( browse ->next )
    browse = scrollForward( browse );

  queue back = scrollBackward( top, browse );

  back ->next = browse ->next;

  return getObject( browse );
}

queue scrollBackward( head top, queue node ){

    if( emptyTail( top ) )
      return NULL;

    queue browse = top ->first;

    while( browse ->next != node )
      browse = scrollForward( browse );

    return browse;
}

int pushTail( head top ){

  if( !top )
    return 0;

  queue temp = createNode();

  temp ->next = top ->first;
  top ->first = temp;

  return 1;
}

int sizeTail( head top ){

  if( emptyTail( top ) )
    return 0;

  queue browse = top ->first;
  int k;

  for( k = 0; !emtyNode( browse ); browse = scrollForward( browse ), k++ );

  top ->size = k;

  return k;
}

queue scrollForward( queue node ){
  return node ->next;
}

int emtyNode( queue node ){

  if( !queue )
    return 1;

  else
    return 0;
}

int emptyTail( head top ){

  if( !top ->next )
    return 1;

  else
    return 0;
}

queue createNode( void ){

  queue temp;

  if ( !temp )
    return NULL;

  temp ->item = insertObject();
  temp ->next = NULL;
}

head createHead( void ){

  head temp;

  temp = malloc( sizeof( struct counter_nodes) );
  if( !temp )
    return NULL;

  temp ->size = 0;
  temp ->first = NULL;

  return temp;
}
