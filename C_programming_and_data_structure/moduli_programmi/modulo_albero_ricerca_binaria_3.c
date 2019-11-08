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

};



/*-----------------------OPERATORI NASCOSTI UTILIZZATI------------------------*/
/* 1) */static void r_print( struct node* );
/* 2) */static int r_delete( struct node **, object );
/* 3) */static object deleteMax( struct node ** );
/* 4) */static int r_insert( struct node **, object );
/* 5) */static struct node* makeLeaf( object );
/* 6) */static int r_contains( struct node *, object );
/* 7) */static int r_size( struct node* );
/* 8) */static int r_level( int, struct node* );
/* 9 */static struct node* rightBtree( struct node* );
/* 10) */static struct node* leftBtree( struct node* );
/* 11) */static int verifBST( struct node*, int, int );
/* 12) */static int r_searchMax( int, struct node* );
/*----------------------------------------------------------------------------*/



/*----------------------DESCRIZIONE OPERATORI NASCOSTI--------------------------
1) stampa degli elementi dell'albero;
2) eliminazione di un elemento scelto nell'albero;
3) ritorno di un valore massimo tra le foglie dell'albero;
4) inserimento di un elemento nell'albero;
5) creazione di una foglia per l'inserimento di un nuovo elemento nell'albero;
6) ricerca di un elemento nell'albero;
7) conteggio del numero di foglie dell'albero;
8) contegigo del numero di livello dell'albero;
9) spostamento sul nodo puntato da sinistra;
10) spostamento sul nodo puntato da destra;
11) verifica dell'albero se albero di ricerca binaria o meno;
12) ricerca dell'elemento massimo nell'albero binario;
------------------------------------------------------------------------------*/



/*-----------------SPECIFICA SINTATTICA OPERATORI NASCOSTI----------------------
1) r_print( struct node* ) -> void;
2) r_delete( struct node **, object ) -> int;
3) deleteMax( struct node ** ) -> object;
4) r_insert( struct node **, object ) -> int;
5) makeLeaf( object ) -> struct node*;
6) r_contains( struct node *, object ) -> int;
7) r_size( struct node* ) -> int;
8) r_level( int, struct node* ) -> int;
9) rightBtree( struct node* ) ->struct node*;
10) leftBtree( struct node* ) ->struct node*;
11) verifBST( struct node*, int, int ) -> int;
12) r_searchMax( int, struct node* ) -> int;
------------------------------------------------------------------------------*/



/*------------------SPECIFICA SEMANTICA OPERATORI NASCOSTI----------------------
1) r_print( leaf={} ) ->
                                  pre_condition: leaf != NULL
                                  post_condition: ogni data_i di leaf={data_1, data_2,..., data_n} viene stampato a video

2) r_delete( leaf={}, data={} ) -> flag
                                  pre_condition:  leaf != NULL, data != NULL
                                  post_condition: flag=1 se data=leaf e leaf eliminato, altrimenti flag=0

3) deleteMax( leaf={} ) -> data={}
                                  pre_condition: leaf={data_1=(), data_2=(), ..., data_n=()} != NULL
                                  post_condition:  l'oggetto leaf avente il data_i massimo viene cancellato e riportato

4) r_insert( leaf={}, data={} ) -> flag
                                  pre_condition: leaf={} != NULL, data={} != NULL
                                  post_condition: flag=1 se data non è già una leaf e viene aggiunto come tale, altrimenti flag=0

5) makeLeaf( data={} ) -> leaf={}
                                  pre_condition:  data != NULL
                                  post_condition: data viene allocato in memoria come un oggetto leaf

6) r_contains( leaf={}, data={} ) -> flag
                                  pre_condition: leaf != NULL, data != NULL
                                  post_condition: flag=1 se data è una leaf, altrimenti flag=0

7) r_size( leaf={} ) -> n
                                  pre_condition: leaf != NULL
                                  post_condition: n+1 per ogni leaf != NULL

8) r_size( leaf={} ) -> n
                                  pre_condition: leaf != NULL
                                  post_condition: n+1 per ogni livello di leaf all'interno dell'albero

9) rightBtree( leaf={} ) -> leafd={}
                                  pre_condition: leaf != NULL
                                  post_condition: leaf= <leaf, leafs, leafd>

10 leftBtree( leaf={} ) -> leafs={}
                                  pre_condition: leaf != NULL
                                  post_condition: leaf= <leaf, leafs, leafd>

11) verifBST( leaf={}, min, max ) -> flag
                                  pre_condition: leaf != NULL
                                  post_condition: flag=0 se albero di ricerca binaria, altrimenti flag=1

12) r_searchMax( max, leaf={} ) -> max
                                  pre_condition: leaf={data_1=(), data_2=(), ..., data_n=()} != NULL
                                  post_condition: max= l'oggetto data_i massimo appertenente ad uno degli oggetti leaf
------------------------------------------------------------------------------*/



/*-------------------------------OPERATORI------------------------------------*/
static int r_searchMax( int max, struct node* point ){

  if( !point )
      return max;

  max= getObject( point ->item );

  return(max= r_searchMax(max, rightBtree(point)));
}



static struct node* rightBtree( struct node* root ){

  if( !root )
      return NULL;

  return( root ->right );
}



static struct node* leftBtree( struct node* root ){

  if( !root )
      return NULL;

  return( root ->left );
}



static int verifBST( struct node* point, int min, int max ){

  if (point == NULL)
      return 1;

  if ( (min != -1) && (getRoot(point) < min) )
      return 0;
  if ( (max != -1) && (getRoot(point) > max) )
      return 0;

  return(verifBST(leftBtree(point), min, getRoot(point)) && verifBST(rightBtree(point), getRoot(point), max) );
}



static int r_level( int n, struct node* point ){

  if(point == NULL )
      return n;

  n++;

  return( (n + r_level(0, point ->left)) && (n + r_level(0, point ->right)) );
}



static int r_size( struct node* point ){

  int k= 0;

  if(point == NULL )
      return k;

  k++;

  return(k+= r_size( point ->left )) && (k+= r_size( point ->right ));
}



static void r_print( struct node* point ){

  if(point != NULL){
      r_print( point ->left );
      printObject( point ->item );
      r_print( point ->right );
  }
}


static int r_delete( struct node **point, object data ){

  int res, cmp;

  if( !(*point) )
      res= 0; // elemento non presente – eliminazione fallita
  else{
      cmp= compareObject( data, (*point)->item );

      if(cmp < 0) // elem < *t->item
          res= r_delete( &((*point)->left), data ); // continua a sx
      else if(cmp > 0) // elem > *t->item
          res= r_delete ( &((*point)->right), data ); // continua a dx
// altrimenti cmp == 0, e quindi trovato elemento da eliminare
      else if( !(*point)->left ){ // non ha sottoalbero sinistro
          struct node *temp= *point; // punta a nodo da eliminare
          *point= (*point) ->right; // ok anche se *t->right == NULL
          free( temp );
          res= 1; // eliminazione riuscita
      }
      else if( !(*point)->right ){ // non ha sottoalbero destro
          struct node *temp= *point;
          *point= (*point)->left; // ok anche se *t->left == NULL
          free( temp );
          res= 1; // eliminazione riuscita
      }
      else { // *t ha entrambi i sottoalberi
          (*point)->item= deleteMax( &((*point)->left) );
          res= 1; // eliminazione riuscita
      }
  }
  return(res);
}



static object deleteMax( struct node **point ){
// continuiamo a scendere a dx finché il sottoalbero dx è vuoto
  if((*point)->right != NULL)
      return deleteMax( &((*point)->right ) );
// se sottoalbero dx è vuoto, *t->item è l’elemento max // e *t punta al nodo da eliminare
  object data= (*point)->item;

  struct node *temp= *point;
  (*point)= (*point)->left; // il nodo puntato da *t può avere figlio sx
  free( temp );

return(data);
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



static int r_contains( struct node *point, object data ){

  int res, cmp;

  if( !point )
      res= 0; // elemento non trovato
  else{
      cmp= compareObject( data, point ->item );
      if( !cmp )
          res= 1; // elemento trovato
      else if(cmp < 0) // elem < t->item
          res= r_contains( point ->left, data );
      else
          res= r_contains( point ->right, data );
  }
  return(res);
}



int searchMax( tree point ){

  int max= 0;

  return(point == NULL)?max:(max= r_searchMax(max, point ->root));
}



object getRoot( leaf root ){

  if( !root )
      return newObject();

  return( getObject(root ->item) );
}



int isBST( tree point ){

  if (point == NULL)
      return 1;

  return verifBST( point ->root, -1, -1 );
}



int removeTree( tree point, object data ){

  if( !point )
      return(-1);

  int res= r_delete( &(point ->root), data );
  if(res == 1)
      (point ->size)--;

  return(res);
}



void prinTree( tree point ){

  if( !point )
      return;

  r_print( point ->root );
}



int contains( tree point, object data ){

  return(point == NULL)?(-1):(r_contains(point ->root, data ));
}



int inserTree( tree point, char* data ){

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


int levBtree( tree point ){

  int n= 0;

  if(point == NULL )
      return n;

  return(n + r_level( 0, point ->root ));
}



int sizeBtree( tree point ){

  int n= 0;

  if(point == NULL )
      return n;

  return(n= r_size(point ->root));
}



int emptyTree( tree point ){

  return(point == NULL)?(-1):(point ->size == 0);
}



int cardinality( tree point ){

  return(point == NULL)?(-1):(point ->size);
}
