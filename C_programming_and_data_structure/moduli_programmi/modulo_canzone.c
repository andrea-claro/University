#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include "modulo_canzone.h"

struct info{
  char autore[15],
       titolo[15];
  int durata;
};
/*-------------------------------OPERATORI------------------------------------*/
object insertObject( void ){

  object data = newObject();

  printf("Inserisci autore:\t");
  scanf("%s", data ->autore);
  printf("Inserisci titolo:\t");
  scanf("%s", data ->titolo);
  printf("Inserisci durata:\t");
  scanf("%d", &data ->durata);

  return data;
}

void printObject( object data ){

  if( data )
  printf("\nIl dato:\nAutore:\t%s\nNome canzone:\t%s\nDurata:\t%d\n", data ->autore, data ->titolo, data ->durata);
}

object getObject( object data ){

  if( !data ){
    strcpy( data ->titolo, "null");
    strcpy( data ->autore, "null");
    data ->durata = 0;
    return data;
  }

  else
    return data;
}

int compareObject( object a, object b ){

  return ( (!strcmp(a ->titolo, b ->titolo)) && (!strcmp(a ->autore, b ->autore)) && (a ->durata == b ->durata) )?1:0;
}

object newObject( void ){

  object data;

  data = malloc( sizeof( object ) );
  if( !data )
    return NULL;

  return data;
}

void deleteObject( object data ){

  data = NULL;
}
