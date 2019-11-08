/********************************************************************************
* Il seguente file di testo risulta essere un ADT oggetto, adibita all'uso di un elemento
* di una lista lista concatenata di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include"modulo_object.h"



/*-------------------------------OPERATORI------------------------------------*/
object insertObject( void ){

  object data;

  printf("Inserisci:\t");
  scanf("%d", &data);

  return data;
}

void printObject( object data ){

  printf("\nIl dato:\t%d\n", data);
}

object getObject( object data ){
  return data;
}

int compareObject( object a, object b ){
  return ( a == b )?1:0;
}

object newObject( void ){

  object data = 0;

  return data;
}

void deleteObject( object data ){
    data = 0;
}
