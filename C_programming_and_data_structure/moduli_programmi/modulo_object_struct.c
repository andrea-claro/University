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
};



/*-------------------------------OPERATORI------------------------------------*/
void updateGames( object data ){
  data ->gameplay++;
}



void updatePoints( object data, int n ){
  data ->points= (data ->points + n);
}



void updateGoalW( object data, int n ){
  data ->goal_w= (data ->goal_w + n);
}



void updateGoalF( object data, int n ){
  data ->goal_f= (data ->goal_f + n);
}



char* getKey( object data ){

  if(data != NULL)
      return data ->nome;

  return NULL;
}



object insertObject( void ){

  object data= newObject();

  data ->nome= malloc(15*sizeof(char));

  printf("\n\nInserisci nome:\t");
  scanf("%s", data ->nome);
  printf("# partite giocate:\t");
  scanf("%d", &data ->gameplay);
  printf("# punti:\t");
  scanf("%d", &data ->points);
  printf("# goal fatti:\t");
  scanf("%d", &data ->goal_w);
  printf("# goal subiti:\t");
  scanf("%d", &data ->goal_f);

  return data;
}



void printObject( object data ){
  if(data != NULL)
  printf("Nome:  %s\nn# partite giocate:  %d\nn# punti squadra:  %d\nn# reti segnate:  %d\nn# reti subite:  %d\n\n",
                                  data ->nome, data ->gameplay, data ->points, data ->goal_w, data ->goal_f);
}



int getObject( object data ){
  return data ->points;
}



int compareObject( char* a, char* b ){

  if( !strcmp(a, b) ) //controllo punteggi squadre
      return (0);
  else if( strcmp(a , b)== (-1) )
      return (-1);
  else
      return (1);
}



object newObject( void ){

  object data= malloc(sizeof(struct item));
  
  data ->nome= NULL;
  data ->gameplay= NULLITEM;
  data ->points= NULLITEM;
  data ->goal_w= NULLITEM;
  data ->goal_f= NULLITEM;

  return data;
}



void deleteObject( object data ){
    free( data ->nome );
    free( data );
}
