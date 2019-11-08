/********************************************************************************
* Il seguente file di testo risulta essere un ADT oggetto, adibita all'uso di un elemento
* di una lista lista concatenata di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include"modulo_object_struct.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct item{ //struttura raffigurante un oggetto generico di tipo item
      //in questo caso riferendosi ad una struttura squadra all'interno della classifica di un campionato
  char* titolo; //in questa struttura il titolo fa da chiave
  char* cantante;
  int anno; //numero reti subite
};



/*-------------------------------OPERATORI------------------------------------*/
char* getKey( object data ){

  if(data != NULL)
      return data->titolo;

  return NULLITEM;
}



object insertObject( void ){

  object data= newObject();

  data ->titolo= malloc(15*sizeof(char));
  data ->cantante= malloc(15*sizeof(char));

  printf("Inserisci titolo:\t");
  scanf("%s", data->titolo);
  printf("Inserisci cantante:\t");
  scanf("%s", data->cantante);
  printf("Inserisci anno:\t");
  scanf("%d", &data->anno);

  return data;
}



void printObject( object data ){
  if(data != NULL)
  printf("titolo:  %s\ncantante:  %s\nanno:  %d", data ->titolo, data ->cantante, data ->anno);
}



char* getObject( object data ){
  if(data != NULL)
      return data ->titolo;

  return NULLITEM;
}



int compareObject( object a, object b ){

  if( !strcmp(a ->cantante, b ->cantante) ){ //controllo punteggi squadre
          return (0);
  }

  else if(strcmp(a ->cantante, b ->cantante)  ==  -1)
      return(-1);

  else
      return(1);
}



object newObject( void ){

  object data= malloc(sizeof(struct item));

  if( !data )
      return NULLITEM;

  data ->titolo= NULLITEM;
  data ->cantante= NULLITEM;
  data ->anno= 0;

  return data;
}



void deleteObject( object data ){
    free( data ->titolo );
    free( data ->cantante );
    free( data );
}
