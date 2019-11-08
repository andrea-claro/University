#include<stdio.h>
#include<stdlib.h>

#include "modulo_object.h"
#include "modulo_albero_binario.h"

struct node{
  object item;
  struct node* left;
  struct node* right;
};

/*------------------------attaccare il file della pila--------------------------
void inOrderIter( tree root ){
  stack pile = newStack();

  if( !emptyBTree(root) )
      push( root, pile );

  tree temp, sx, dx, R;
  object r;

  while( !emptyStack(pile ) ){
      temp = top( pile );
      pop( pile );

      r = getRoot( temp );
      sx = leftBTree( temp );
      dx = rightBTree( temp );

      if( emptyBTree(sx) && emptyBTree(dx) )
          outputItem( temp ); // visitiamo la radice

      else {
          if( !emptyBTree(dx) )
              push( dx, pile ); // dx visitato per ultimo
              
          R = consBTree( temp, emptyBTree(), emptyBTree() );
          push( R, pile ); // radice visitata dopo sx

          if( !emptyBTree(sx) )
              push(sx, pile ); // sx visitato per primo
      }
  }
}




void postOrderIter( tree root ){
  stack pile = newStack();

  if( !emptyBTree(root) )
      push( root, pile );

  tree temp, sx, dx, R;
  object data;

  while( !emptyStack(pile) ){
      temp = top( pile );
      pop( pile );

      data = getRoot( temp );
      sx = leftBTree( temp );
      dx = rightBTree( temp );

      if( emptyBTree(sx) && emptyBTree(dx) )
          outputItem( data ); // visitiamo la radice

      else{
          R = consBTree( temp, emptyBTree(), emptyBTree() );
          push( R, pile ); // radice e’ ultima ad essere visitata

          if( !emptyBTree(dx) )
              push(dx, pile); // dx visitato dopo sx
          if( !emptyBTree(sx) )
              push(sx, pile); // sx visitato per primo }
  }
}


void preOrderIter( tree root ){
  stack pile = newStack();

  if( !emptyBTree(root) )
      push( root, pile );

  tree temp, sx, dx;

  while( !emptyStack(pile) ){
      temp = top( pile );
      pop( pile );

      outputItem( getRoot(temp) ); // visita radice sx = leftBTree(temp);
      dx = rightBTree( temp );
      if( !emptyBTree(dx) )
          push(dx, pile);
      if( !emptyBTree(sx) )
          push(sx, pile);       // inseriamo prima dx e poi sx
  }
}


---------------------attaccare il file della coda-------------------------------
void levelOrder( tree root ){
  tree sx, dx, R;
  queue tail = newQueue();

  enqueue(t, tail);

  while( !emptyQueue(tail) ){
      R = dequeue( tail );

      output_item( getRoot(R) );

      sx = leftBTree( root );
      dx = rightBTree( root );

      if ( sx )
          enqueue( sx, tail);
      if ( dx )
          enqueue( dx, c);
  }
}
*/

tree consBTree(object data, tree sx, tree dx){
  struct node *new = malloc ( sizeof(struct node) );
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
  tree new = malloc( sizeof(struct node) );
  if( !new )
      return NULL;

  new ->item = newObject();
  new ->left = NULL;
  new ->right = NULL;

  return( new );
}

int emtyBtree( tree root ){
  return( root==NULL )?1:0;
}

object getRoot( tree root ){
  if( !root )
      return NULL;

  return( root ->item );
}
