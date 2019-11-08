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
  char* code; //in questa struttura il codice fa da chiave
  char* destination;
  char* operator;
  int durata,
      prezzo,
      posti;
};



/*-------------------------------OPERATORI------------------------------------*/
void updateSeats( object data, int n ){
  data->posti= n;
}



void updatePrice( object data, int n ){
  data->prezzo= n;
}



char* getKey( object data ){

  if(data != NULL)
      return data->code;

  return NULLITEM;
}



object insertObject( void ){

  object data= newObject();

  data ->code= malloc(15*sizeof(char));
  data ->destination= malloc(15*sizeof(char));
  data ->operator= malloc(15*sizeof(char));

  printf("Inserisci codice viaggio:\t");
  scanf("%s", data->code);
  printf("Inserisci destinazione:\t");
  scanf("%s", data->destination);
  printf("Inserisci tour-operator:\t");
  scanf("%s", data->operator);
  printf("Inserisci durata:\t");
  scanf("%d", &data->durata);
  printf("Inserisci prezzo per persona:\t");
  scanf("%d", &data->prezzo);
  printf("Inserisci posti disponibili:\t");
  scanf("%d", &data->posti);

  return data;
}



void printObject( object data ){
  if(data != NULL)
  printf("codice:  %s\ndestinazione:  %s\noperator:  %s\ndurata:  %d\nprezzo:  %d\nposti:  %d",
              data->code, data->destination, data->operator, data->durata, data->prezzo, data->posti);
}



char* getObject( object data ){
  if(data != NULL)
      return data ->destination;

  return NULLITEM;
}



int compareObject( object a, object b ){

  if( !strcmp(a ->code, b ->code) ){ //controllo punteggi squadre
          return (0);
  }

  else if(strcmp(a ->code, b ->code)  ==  -1)
      return(-1);

  else
      return(1);
}



object newObject( void ){

  object data= malloc(sizeof(struct item));
  if( !data )
      return NULLITEM;

  data->code= NULLITEM;
  data->destination= NULLITEM;
  data->operator= NULLITEM;
  data->durata= 0;
  data->prezzo= 0;
  data->posti= 0;

  return data;
}



void deleteObject( object data ){
    free( data->code );
    free( data->destination );
    free( data->operator );
    free( data );
}
