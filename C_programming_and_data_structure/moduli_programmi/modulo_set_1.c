#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include "modulo_object.h"
#include "modulo_set.h"



struct c_set{
  int size;
  set first;
};

struct series{
  object item;
  set next;
};



int addNumber( head top, object data ){

  if( !top || !data )
    return 0;

  set temp = createSet();
  temp ->item = data;

  if( emptySet( top ) ){
    top ->first = temp;
    top ->size++;
    return 1;
  }

  else{
    set browse = top ->first;

    if( ( temp ->item ) < ( browse ->item ) ){
      top ->first = temp;
      temp ->next = browse;
      top ->size++;
      return 1;
    }

    else if( ( temp ->item ) > ( browse ->item ) ){

      for( ; !emptyNumber( browse ) && ( temp ->item ) > ( browse ->item ) ; )
        browse = scrollForward( browse );

      temp ->next = browse;
      set back = scrollBackward( browse, top );
      back ->next = temp;
      top ->size++;
      return 1;
    }

    else
      return 0;
  }
}

head newSet( int n ){

  if( !n )
    return NULL;

  head top = createHead();

  for( int k = 0; k < n; k++ ){
    if( !addNumber( top, insertObject() ) )
      return NULL;
  }

    return top;
}

/*void deleteNumber( set point ){

  deleteObject( point ->item );
  free( point );
}*/

void printSet( head top ){
  set browse = top ->first;

  while( !emptyNumber( browse ) ){
    printNumber( browse );
    browse = scrollForward( browse );
  }
}
void printNumber( set point ){

  if( emptyNumber( point ) ){
    printf("\n\nIl nodo e' vuoto\n\n");
    return;
  }

  printObject( point ->item );
}

int sizeSet( head top ){

  if( emptySet( top ) )
    return 0;

  set temp = top ->first;
  int k;

  for( k = 0; !emptyNumber( temp ); k++, temp = scrollForward( temp ) );

  top ->size = k;

  return k;
}

/*set scrollTo( head top, int pos){

  if( emptySet( top ) || pos > sizeSet( top ) || pos < 0 )
    return NULL;

  set browse = top ->first;

  for( int k = 0; k < pos && !emptyNumber( browse ); browse = scrollForward( browse ), k++ );

  return browse;
}*/

int emptySet( head top ){

  if( emptyNumber( top ->first ) )
    return 1;

  else
    return 0;
}

int emptyNumber( set point ){

  if( !( point ) )
    return 1;

  else
    return 0;
}

set scrollBackward( set point, head top){

  if( emptySet( top ) )
    return NULL;

  set browse = top ->first;
  set back = top ->first;

  while( browse != point ){
    back = browse;
    browse = scrollForward( browse );
  }

  return back;

}

set scrollForward( set point){

  return (point ->next);
}

head createHead( void ){

  head temp;

  temp = malloc( sizeof( struct c_set ) );
  if( !temp )
    return NULL;

  temp ->size = 0;
  temp ->first = NULL;

  return temp;
}

set createSet( void ){

  set temp;

  temp = malloc( sizeof( struct series ) );
  if( !temp )
    return NULL;

  temp ->item = newObject();
  temp ->next = NULL;

  return temp;
}
