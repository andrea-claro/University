/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ tree;
_ int;
_ struct node;
------------------------------------------------------------------------------*/



#include "modulo_object.h"



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct node* tree;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ tree:
        dove tree è un insieme della tripla (item, *left, *right)
            dove item è un dato di tipo object
            dove *left è un puntatore al tipo struct node
            dove *right è un puntatore al tipo struct node
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */tree consBtree( object, tree, tree );
/* 2) */tree rightBtree( tree );
/* 3) */tree leftBtree( tree );
/* 4) */tree newBtree( void );
/* 5) */int emptyBtree( tree );
/* 6) */int inOrderIter( tree );
/* 7) */int postOrderIter( tree );
/* 8) */int preOrderIter( tree );
/* 9) */int levelOrderIter( tree );
/* 10) */object getRoot( tree );
/* 11 */void r_print( tree );
/* 12 */int sizeBtree( tree );
/* 13 */int levBtree( int, tree );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) unisce due sottoalberi ad una radice superiore;
2) viaggia attraverso il ramo destro;
3) viaggia attraverso il ramo sinistro;
4) crea un nuovo punto dell'albero;
5) ricava informazioni sulla completezza dell'albero;
6) scompattamento in ordine simmetrico dell'albero attraverso un algoritmo iterativo;
7) scompattamento in ordine partente dalle foglie, dell'albero attraverso un algoritmo iterativo;
8) scompattamento in ordine partente dalla radice, dell'albero attraverso un algoritmo iterativo;
9) scompattamento in ordine per livello, dell'albero attraverso un algoritmo iterativo;
10) prelevamento dell'elemento nodo;
11) stampa a video in pre ordine dell'albero;
12) conteggio delle foglie di un albero;
13) conteggio del numero dei livelli di un albero;
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE STACK----------------------
1) consBTree( object, tree, tree ) -> tree;
2) rightBtree( tree ) -> tree;
3) leftBtree( tree ) -> tree;
4) newBtree( void ) -> tree;
5) emptyBtree( tree ) -> boolean;
6) inOrderIter( tree ) -> boolean;
7) postOrderIter( tree ) -> boolean;
8) preOrderIter( tree ) -> boolean;
9) levelOrderIter( tree ) -> boolean;
10) getRoot( tree ) -> object;
11) r_print( tree ) -> void;
12) sizeBtree( tree ) -> int;
13) levBtree( int, tree ) -> int;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE STACK------------------------
1) consBTree( data, sx, dx ) -> root
                                  pre_condition: (data != NULL) && (sx != NULL) && (dx != NULL)
                                  post_condition: (root != NULL) && (puntatore di root a snx punta a sx) &&
                                                  (puntatore di root a dsx punta a dx)

2) rightBtree( root ) -> root'
                                  pre_condition: (root != NULL)
                                  post_condition: (ritorna root'= puntatore di root a dsx)

3) leftBtree( root ) -> root'
                                  pre_condition: (root != NULL)
                                  post_condition: (ritorna root'= puntatore di root a snx)

4) newBtree( void ) -> root
                                  pre_condition:
                                  post_condition: (root != NULL)

5) emptyBtree( root ) -> flag
                                  pre_condition: (root != NULL)
                                  post_condition: (flag = 1 se la radice risulta essere uguale a NULL) ||
                                                  (flag = 0 se la radice risulta essere diversa da NULL)

6) inOrderIter( root ) -> flag
                                  pre_condition: (root != NULL)
                                  post_condition: (flag = 1 se l'ordinamento è stato inpilato) ||
                                                  (flag = 0 se l'ordinamento non è stato inpilato)

7) postOrderIter( root ) -> flag
                                  pre_condition: (root != NULL)
                                  post_condition: (flag = 1 se l'ordinamento è stato inpilato) ||
                                                  (flag = 0 se l'ordinamento non è stato inpilato)

8) preOrderIter( root ) -> flag
                                  pre_condition: (root != NULL)
                                  post_condition: (flag = 1 se l'ordinamento è stato inpilato) ||
                                                  (flag = 0 se l'ordinamento non è stato inpilato)

9) levelOrderIter( root ) -> flag
                                  pre_condition: (root != NULL)
                                  post_condition: (flag = 1 se l'ordinamento è stato accodato) ||
                                                  (flag = 0 se l'ordinamento non è stato accodato)

10) getRoot( root ) -> data
                                  pre_condition: (root != NULL)
                                  post_condition: (ritorna data= oggetto puntato dalla root)

11) r_print( root ) ->
                                  pre_condition: (root != NULL)
                                  post_condition: (stampa dell'oggetto dell'albero)

12) sizeBtree( root ) -> n
                                  pre_condition: (root != NULL)
                                  post_condition: (n+1 per ogni foglia dell'albero)

13) levBtree( n, root ) -> n
                                  pre_condition: (root != NULL) && (n = 0)
                                  post_condition: (n+1 per ogni livello dell'albero)

------------------------------------------------------------------------------*/
