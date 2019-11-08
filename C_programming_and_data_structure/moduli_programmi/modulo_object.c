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



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct item{ //struttura raffigurante un oggetto generico di tipo item
      //in questo caso riferendosi ad una struttura squadra all'interno della classifica di un campionato
  char* nome; //puntatore al nome della squadra
        //in questa struttura il nome fa da chiave
  int
      gameplay, //numero partite giocate
      points, //numero punti accumulati
      goal_w, //numero reti segnate
      goal_f; //numero reti subite
}



/*-------------------------------OPERATORI------------------------------------*/
char* getKey( object data ){

  if(data != NULL)
      return data ->nome;

  return NULL;
}



object insertObject( void ){

  object data= newObject();

  printf("Inserisci nome:\t");
  scanf("%s", data ->nome);
  printf("\n# partite giocate:\t");
  scanf("%d", &data ->gameplay);
  printf("\n# punti:\t");
  scanf("%d", &data ->points);
  printf("\n# goal fatti:\t");
  scanf("%d", &data ->goal_w);
  printf("\n# goal subiti:\t");
  scanf("%d", &data ->goal_f);

  return data;
}



void printObject( object data ){
  if(data != NULL)
  printf("Nome:  %s\nn# partite giocate:  %d\nn# punti squadra:  %d\nn# reti segnate:  %d\nn# reti subite:  %d",
                                  data ->nome, data ->gameplay, data ->points, data ->goal_w, data ->goal_f);
}



int getObject( object data ){
  if(data != NULL)
      return data ->points;
}



int compareObject( object a, object b ){

  if((a ->points) == (b ->points)){ //controllo punteggi squadre
      if((a ->goal_w) == (b ->goal_w)) //controllo goal segnati nel caso il punteggio sia uguale
          return (0);
      else if((a ->goal_w) < (b ->goal_w))
          return (-1);
      else
          return (1);
  }

  else if((a ->points) < (b ->points))
      return(-1);

  else
      return(1);
}



object newObject( void ){

  object data= malloc(sizeof(struct item));
  data= NULLITEM;

  return data;
}



void deleteObject( object data ){
    free( data ->nome );
    free( data );
}
