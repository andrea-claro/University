#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "modulo_object_struct.h"
#include "modulo_lista_5.h"
#include "modulo_albero_ricerca_binaria_3.h"
#include "modulo_catalogo.h"


/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct classifique{ //struttura nodo raffigurante una foglia dell'albero
  tree albero; //classifica squadre ordinate per nome;
  head lista;
  char* nome; //nome della classifica;
};



static int update( object, int, int );



/*-------------------------------OPERATORI------------------------------------*/
static int update( object data, int gw, int gf ){

  if(gw == gf){
      updateObject( data, 1, gw, gf );
      return (1);
  }

  else if(gw > gf){
      updateObject( data, 3, gw, gf );
      return (1);
  }

  else{
      updateObject( data, 0, gw, gf );
      return (1);
  }

  return (0);
}



class createClass( char* data ){

  class new= malloc(sizeof(struct classifique));
  if( !new )
      return NULL;

  new ->albero= newTree();
  new ->lista= createHead();
  new ->nome= malloc(sizeof(char));
  strcpy( new ->nome, data );

  return new;
}



int insertClass( class cat, int n ){

  if( !cat  ||  n < 0)
      return (0);

  object data= newObject();
  for( int k= 0; k < n; k++ ){
      data= insertObject();
      if( !inserTree( cat ->albero, data )  ||  !addingNode( k, cat ->lista, data) )
          return (0);
  }

  return (1);
}



int searchClass( char* data, class cat ){

  if( !cat  ||  !data )
      return(0);

  printObject( contains(cat ->albero, data) );

  return (1);
}



int updateClass( class cat, char* a, char* b, int gs1, int gs2 ){

  if( !cat  ||  !a  ||  !b  ||  contains(cat ->albero, a) == NULL  || contains(cat ->albero, b) == NULL )
      return (0);

  else if( !update( contains(cat ->albero, a), gs1, gs2)  ||  !update( contains(cat ->albero, b), gs2, gs1) )
      return (0);

  return (1);
}



void printClass( class cat ){

  if( !cat )
      printf("\n\nclassifica inesistente");

  printf("\n\nALBERO:\n");
  prinTree( cat ->albero );
  bubbleSortList( cat ->lista );
  printf("\n\nLISTA:");
  printList( cat ->lista );
}
