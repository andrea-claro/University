/********************************************************************************
* Il seguente file di testo risulta essere un ADT albero contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di uno albero binario
* di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object.h"
#include "modulo_stack_2.h"
#include "modulo_coda_3.h"
#include "modulo_albero_binario_2.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct node{ //struttura nodo raffigurante un punto dell'albero
  object item; //oggetto contenuto all'interno del nodo dell'albero
  struct node* left; //puntatore al ramo sinistro dell'albero
  struct node* right; //puntatore al ramo destro dell'albero
};



/*-------------------------------OPERATORI------------------------------------*/
void r_print( tree point ){

  if(point != NULL){
      printObject( point ->item );
      r_print( point ->left );
      r_print( point ->right );
  }
}



int sizeBtree( tree point ){

  int k= 0;

  if(point == NULL )
      return k;

  else{
      k++;
      k+= sizeBtree( point ->left );
      k+= sizeBtree( point ->right );
  }

  return k;
}



int levBtree( int n, tree point ){

  if(point == NULL )
      return n;

  else{
      n++;
      return(n + levBtree( 0, point ->left ) );
      return(n + levBtree( 0, point ->right ) );
  }
}



/*int inOrderIter( tree root ){

  stack pile= createPile();

  if( !emptyBTree(root) )
      if( !pushStack(pile, getRoot(root)) )
          return(0);

  tree temp, sx, dx, R;
  object r;

  while( !emptyStack(pile ) ){
      temp ->item= getFirst( pile );
      if( !popStack(pile) )
          return(0);

      r= getRoot( temp );
      sx= leftBTree( temp );
      dx= rightBTree( temp );

      if( emptyBTree(sx) && emptyBTree(dx) )
          printObject( temp ); // visitiamo la radice

      else{
          if( !emptyBTree(dx) )
              if( !pushStack(pile, getRoot(dx)) ) // dx visitato per ultimo
                  return(0);

          R= consBTree( temp, emptyBTree(), emptyBTree() );

          if( !pushStack(pile, getRoot(R)) ) // radice visitata dopo sx
              return(0);

          if( !emptyBTree(sx) )
              if( !pushStack(pile, getRoot(sx)) ) // sx visitato per primo
                  return(0);
      }
  }
  return(1);
}



int postOrderIter( tree root ){

  stack pile= createPile();

  if( !emptyBTree(root) )
      if( !pushStack(pile, getRoot(root)) )
          return(0);

  tree temp, sx, dx, R;
  object data;

  while( !emptyStack(pile) ){
      temp ->item= getFirst( pile );
      if( !popStack(pile) )
          return(0);

      data= getRoot( temp );
      sx= leftBTree( temp );
      dx= rightBTree( temp );

      if( emptyBTree(sx) && emptyBTree(dx) )
          printObject( data ); // visitiamo la radice

      else{
          R= consBTree( data, sx, dx );
          if( !pushStack(pile, getRoot(R)) ) // radice e’ ultima ad essere visitata
              return(0);

          if( !emptyBTree(dx) )
              if( !pushStack(pile, getRoot(dx)) ) // dx visitato dopo sx
                  return(0);
          if( !emptyBTree(sx) )
              if( !pushStack(pile, getRoot(sx)) ) // sx visitato per primo }
                  return(0);
      }
  }
  return(1);
}



int preOrderIter( tree root ){

  pile stack= createPile();

  if( !emptyBtree(root) )
      if( !pushStack(stack, getRoot(root)) )
          return(0);

  tree temp, sx, dx;

  while( !emptyStack(stack) ){
      temp ->item= getFirst( stack );
      if( !popStack(stack) )
          return(0);

      printObject( getRoot(temp) ); // visita radice
      dx= rightBtree( temp );
      sx= leftBtree( temp );

      if( !emptyBtree(dx) )
          if( !pushStack(stack, getRoot(dx)) )
              return(0);
      if( !emptyBtree(sx) )
          if( !pushStack(stack, getRoot(sx)) )       // inseriamo prima dx e poi sx
              return(0);
  }
  return(1);
}

DA TESTARE */



int levelOrderIter( tree root ){

  tree sx, dx, R;
  queue tail= createQueue();

  if( !enQueue(tail, getRoot(root)) )
      return(0);

  while( !emptyQueue(tail) ){
      R ->item= deQueue( tail );

      printObject( getRoot(R) );

      sx= leftBtree( root );
      dx= rightBtree( root );

      if( sx )
          if( !enQueue(tail, getRoot(sx)) )
              return(0);
      if( dx )
          if( !enQueue(tail, getRoot(dx)) )
              return(0);
  }
  return(1);
}



tree consBtree( object data, tree sx, tree dx ){

  struct node *new= malloc(sizeof(struct node));
  if ( !new )
      return NULL;

  new ->left = sx;
  new ->right = dx;
  new ->item = data;

  return new;
}



tree rightBtree( tree root ){

  if( !root )
      return NULL;

  return( root ->right );
}



tree leftBtree( tree root ){

  if( !root )
      return NULL;

  return( root ->left );
}



tree newBtree( void ){

  tree new= malloc( sizeof(struct node) );
  if( !new )
      return NULL;

  new ->item= newObject();
  new ->left= NULL;
  new ->right= NULL;

  return( new );
}



int emptyBtree( tree root ){
  return(root == NULL)?1:0;
}



object getRoot( tree root ){
  if( !root )
      return newObject();

  return( getObject(root ->item) );
}
