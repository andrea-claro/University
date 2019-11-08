#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#include "modulo_object.h"
#include "modulo_list.h"

struct node{
  object point;
  list next;
}

struct counter_nodes{
  int size;
  list first;
}

head cloneList( head top ){

  head temp;

  temp = createHead();

  for (int k = 1; browse; browse = browse ->next, k++){
    list copy;
    copy =createList();

    temp = addingNode( k, temp );
  }
}

list cloneNode( list node ){

  list temp;

  temp = createList();
  temp ->point = //getObject();

  return temp;
}

void printPos( int pos, head top ){

  list temp = top ->fist;

  if ( !pos ){
    printNode( temp );
    return;
  }

  for(int k = 1; k < pos && pos < top ->size; k++)
    temp = temp ->next;

  printNode( temp );
}

void printList( head top ){

    head temp = top;
    list browse = temp ->first;
    while( emptyList( temp ) ){
      printNode( temp ->first );

      browse = browse ->next;
      temp ->first = browse;
    }
}

void printNode( list node ){
  printf("\nIl contenuto del nodo risulta:\t ");
  //printObject();
}

head deleteList( head top ){

  while( emptyList( top ) ){
    list temp = top ->first;

    top ->first = temp ->next;
    deleteNode( temp );
  }
}

head deletePos( int pos, head top ){

  list temp = top ->first;

  if ( !pos ){
    top ->first = temp ->next;
    deleteNode( temp );
    return top;
  }

  for(int k = 1; k < (pos - 1) && (pos - 1) < top ->size; k++)
    temp = temp ->next;

  list link = temp;

  temp = temp ->next;
  link ->next = temp ->next;
  deleteNode( temp );

  return top;
}

void deleteNode( list node ){
  //deleteObject( node );
  free( node ->next );
  free( node );
  top ->size--;
}

head addingNode( int pos, head top ){

  list temp = createList();

  if( !pos ){
    temp ->next = top ->first;
    top ->first = temp;
    top ->size++;
    temp ->point = //inputObject();

    return top;
  }

  list browse = top ->first;

  for(int k = 1; k < pos && pos < top ->size; k++)
    browse = browse ->next;

  temp ->next = browse ->next;
  browse ->next = temp;
  top ->size++;
  temp ->point = //inputObject();

  return top;
}

void addingObject( int pos, /*object data,*/ head top ){

  top = addingNode( pos, top);

  list temp = top ->first;

  if( !pos ){
    //addObject( object data );
    return;
  }

  for(int k = 1; k < pos && pos < top ->size; k++)
    temp = temp ->next;

  //addObject( object data );
}

int posList( /*object flag,*/ head top ){

  list temp = top ->first;
  int k = 0;
  while( k < top ->size ){
    if( /*compareObject( object flag )*/ )
      return k;
    temp = temp ->next;
    k++;
  }
}

int emptyList( head top ){

  if( !top ->first )
    return 0;
  else
    return 1;
}

list getNode( int pos, head top ){

  list temp = top ->first;

  for( int k = 0; k < pos; k++){
    temp = temp ->next;
  }

  return temp;
}

int sizeHead( head top ){
  if( !head )
    return 0;
  else
    return head ->size;
}

list createList( void ){

  list temp;

  temp = malloc( sizeof( struct node ) );
  if(! temp )
    exit( printf("There isn't enough space" ) );

  //deleteObject( temp );
  temp ->next = NULL;

  return temp;
}

head createHead( void ){

  head temp;

  temp = malloc( sizeof( struct counter_nodes ) );
  if( !temp )
    exit( printf("There isn't enough space" ) );

  head ->size = 0;
  head ->first = NULL;

  return temp;
}
