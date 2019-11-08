#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#include "modulo_object.h"
#include "modulo_coda_2.h"

struct counter_nodes{
  int size;
  struct node* first;
};

struct node{
  object item;
  struct node* next;
};

void deleteTail( head top, head tail ){

  if( emptyTail( top, tail ) )
    printf("\nla coda e' vuota\n");

  while( !emptyTail( top, tail ) ){
  queue browse = tail ->first;
  tail ->first = scrollBackward( top, tail ->first );

  queue temp = tail ->first;
  temp ->next = browse ->next;
  deleteNode( browse );
  }
}

void deleteNode( queue node ){

  if( !emtyNode( node ) ){
    deleteObject( node ->item );
    free( node );
  }
}

queue popTail( head top, head tail ){

  if( emptyTail( top, tail ) )
    return NULL;;

  queue browse = tail ->first;

  tail ->first = scrollBackward( top, browse );

  queue temp = tail ->first;
  temp ->next = browse ->next;

  return browse;
}

queue scrollBackward( head top, queue node ){

    if( emptyNode( top ->first ) )
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

int sizeTail( head top, head tail ){

  if( emptyNode( top, tail ) )
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

int emptyTail( head top, head tail ){

  if( (!top ->first) == (!tail ->first) )
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
