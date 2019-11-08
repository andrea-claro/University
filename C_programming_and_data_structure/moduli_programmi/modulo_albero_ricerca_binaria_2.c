/********************************************************************************
* Il seguente file di testo risulta essere un ADT albero contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di una albero di ricerca binaria
* di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include <stdio.h>
#include <stdlib.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object.h"
#include "modulo_albero_ricerca_binaria.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct node{ //struttura nodo raffigurante una foglia dell'albero
  object item; //oggetto contenuto all'interno del nodo
  struct node *left; // puntatore del nodo ad un altro nodo (sinistro nella raffigurazione)
  struct node *right; // puntatore del nodo ad un altro nodo (destro nella raffigurazione)
};

struct c_tree{ //struttura capo-nodo raffigurante una legenda dell'albero binario
  struct node *root; //puntatore alla radice dell'albero
  int size; //elemento di riferimento per la quantità dei nodi presenti nell'albero
  char* classifica; //elemento di riferimento per il nome della classifica
};



/*-----------------------OPERATORI NASCOSTI UTILIZZATI------------------------*/
/* 1) */static void r_print( struct node* );
/* 2) */static int r_insert( struct node **, object );
/* 3) */static struct node* makeLeaf( object );
/* 4) */static int update( leaf, int, int );
/* 5) */static int u_contains( struct node *, char*, int, int);
/* 6) */static int p_contains( struct node *, char* );
/* 7) */static int s_contains( struct node *, char* );
/*----------------------------------------------------------------------------*/



/*----------------------DESCRIZIONE OPERATORI NASCOSTI--------------------------

------------------------------------------------------------------------------*/



/*-----------------SPECIFICA SINTATTICA OPERATORI NASCOSTI----------------------

------------------------------------------------------------------------------*/



/*------------------SPECIFICA SEMANTICA OPERATORI NASCOSTI----------------------

------------------------------------------------------------------------------*/



/*-------------------------------OPERATORI------------------------------------*/
static void r_print( struct node* point ){

  if(point != NULL){
      r_print( point ->left );
      printObject( point ->item );
      r_print( point ->right );
  }
}



static int r_insert( struct node **point, object data ){ // puntatore a puntatore per modifica

  int cmp,
      res;

  if( !(*point) ){ // albero vuoto, elemento non presente
      (*point)= makeLeaf( data );

      if(*point != NULL)
          res= 1; // inserimento riuscito
      else
          res= -1; // creazione nodo fallita
  }

  else {
      cmp= compareObject( data, (*point)->item );
      if(cmp < 0)
          res= r_insert( &((*point)->left), data );
      else if(cmp > 0)
          res= r_insert( &((*point)->right), data );
      else
          res= 0; // elemento già presente
  }
  return(res);
}



static struct node* makeLeaf( object data ){

  struct node *new= malloc(sizeof(struct node));
  if( !new )
      return(NULL);

  new ->item= data;
  new ->left= NULL;
  new ->right= NULL;

  return(new);
}



static int update( leaf point, int gw, int gf ){

  if(gw == gf)
      if( !updateGames(point ->item ) || !updatePoints(point ->item, 1) || !updateGoalW(point ->item, gw) || !updateGoalF(point ->item, -gf))
          return (0);

  else if(gw > gf)
      if( !updateGames(point ->item ) || !updatePoints(point ->item, 3) || !updateGoalW(point ->item, gw) || !updateGoalF(point ->item, -gf))
          return (0);

  else
      if( !updateGames(point ->item ) || !updatePoints(point ->item, 0) || !updateGoalW(point ->item, gw) || !updateGoalF(point ->item, -gf))
          return (0);

  return (1);
}



static int u_contains( struct node *point, char* data, int gw, int gf){

  int res, cmp;

  if( !point )
      res= 0; // elemento non trovato
  else{
      cmp= compareObject( data, point ->item );
      if( !cmp ){ // elemento trovato
          if( update( point, gw, gf ) )
              res= 1;
      }
      else if(cmp < 0) // elem < t->item
          res= r_contains( point ->left, data );
      else
          res= r_contains( point ->right, data );
  }
  return(res);
}



static int p_contains( struct node *point, char* data ){

  int res, cmp;

  if( !point )
      res= 0; // elemento non trovato
  else{
      cmp= compareObject( data, point ->item );
      if( !cmp ){ // elemento trovato
          res= 1;
          printObject( point ->item );
      }
      else if(cmp < 0) // elem < t->item
          res= r_contains( point ->left, data );
      else
          res= r_contains( point ->right, data );
  }
  return(res);
}



static int s_contains( struct node *point, char* data ){

  int res, cmp;

  if( !point )
      res= 0; // elemento non trovato
  else{
      cmp= compareObject( data, point ->item );
      if( !cmp ){ // elemento trovato
          res= 1;
      }
      else if(cmp < 0) // elem < t->item
          res= r_contains( point ->left, data );
      else
          res= r_contains( point ->right, data );
  }
  return(res);
}



int inserTree( tree point, object data ){

  if( !point )
      return(0);

  int res= r_insert( &(point ->root), data );
  if( res )
      (point ->size)++;

  return(res);
}



tree newTree( void ){

  tree new= malloc(sizeof(struct c_tree));
  if( !new )
      return(NULL);

  new ->root= NULL;
  new ->size= 0;

  return(new);
}



int contains( tree point, char* data ){

  return(point == NULL)?(-1):(s_contains(point ->root, data ));
}



void printLeaf( tree point, char* data ){
  p_contains(point ->root, data);
}



int updateTree( tree point, char* sq1, char* sq2, int gs1, int gs2 ){

  if( !contains(point, sq1) || !contains(point, sq2) )
      return (0);

  u_contains( point, sq1, gs1, gs2 );
  u_contains( point, sq2, gs1, gs2 );
}


void prinTree( tree point ){

  if( !point )
      return;

  r_print( point ->root );
}
