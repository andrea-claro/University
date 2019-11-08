/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ tree;
_ int;
_ struct node;
_ struct counter_nodes;
------------------------------------------------------------------------------*/



#include "modulo_object.h"



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct c_tree* tree;
typedef struct node* leaf;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ tree:
        tree è un insieme della doppia (*root, size)
            dove *root è un puntatore ad un tipo struct node
            dove size è un dato di tipo int

_ struct node:
        struct node è un insieme della tripla (*left, *right, item)
            dove *left è un puntatore ad un tipo struct node
            dove *right è un puntatore ad un tipo struct node
            dove item è un dato di tipo object
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */tree newTree( void );
/* 2) */int emptyTree( tree );
/* 3) */int cardinality( tree );
/* 4) */int contains( tree, object );
/* 5) */int inserTree( tree, object );
/* 6) */int removeTree( tree, object );
/* 7) */void prinTree( tree );
/* 8) */int sizeBtree( tree );
/* 9) */int levBtree( tree );
/* 10) */object getRoot( leaf );
/* 11) */int isBST( tree );
/* 12) */int searchMax( tree );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) reare un nuovo nodo dell'albero;
2) ricavare informazione sul fatto che l'albero sia vuoto o meno;
3) ricavare la dimensione dell'albero;
4) ricavare come informazione il fatto che un elemento sia presente o meno nell'albero;
5) inserimento di elementi all'interno dell'albero;
6) cancellazione di elementi all'interno di un albero;
7) stampa a video degli oggetti contenuto nell'albero;
8) conteggio del numero di foglie totali di un albero;
9) conteggio del numero di livelli dell'albero binario;
10) ricavare l'offetto della foglia;
11) verifica se l'albero è di ricerca binaria;
12) ricerca del massimo in un albero binario;

... altri operatori sono presenti nel codice del modulo base; questa scelta viene fatta sulla base
    dell'information hiding in modo da evitare che un utente possa venire a conoscenza della
    struttura interna di tutto il codice...
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE LIST----------------------
1) newTree( void ) -> tree;
2) emptyTree( tree ) -> int;
3) cardinality( tree ) -> int;
4) contains( tree, object ) -> int;
5) inserTree( tree, object ) -> int;
6) removeTree( tree, object ) -> int;
7) prinTree( tree ) -> void;
8) sizeBtree( tree ) -> int;
9) levBtree( tree ) ->int;
10) getRoot( struct node* ) -> object;
11) isBST( tree ) -> int;
12) searchMax( tree ) -> int;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE LIST------------------------
1) newTree( ) -> tree
                                  pre_condition:
                                  post_condition: (tree != NULL)

2) emptyTree( tree ) -> flag
                                  pre_condition: (tree != NULL)
                                  post_condition: (flag = 1 se l'albero risulta vuoto) || (flag = 0 se l'
                                                  albero è pieno)

3) cardinality( tree ) -> size
                                  pre_condition: (tree != NULL)
                                  post_condition: (size = -1 se l'albero e' vuoto) || (flag = (dimensione
                                                  dell'albero) se questo è pieno)

4) contains( tree, data ) -> flag
                                  pre_condition: (tree != NULL) && (data != NULL)
                                  post_condition: (flag = 1 se l'elemento è presente nell'albero) ||
                                                  (flag = 0 se l'elemento non è presente nell'albero)

5) inserTree( tree, data ) -> flag
                                  pre_condition: (tree != NULL) && (data != NULL)
                                  post_condition: (flag = 1 se l'elemento è stato aggiunto nell'albero) ||
                                                  (flag = 0 se l'elemento non è stato aggiunto nell'albero)

6) removeTree( tree, data ) -> flag
                                  pre_condition: (tree != NULL) && (data != NULL)
                                  post_condition: (flag = 1 se l'elemento è stato eliminato dall'albero) ||
                                                  (flag = 0 se l'elemento non è stato eliminato dall'albero)

7) prinTree( tree ) ->
                                  pre_condition: (tree != NULL)
                                  post_condition: (stampa a video degli oggetti dell'albero)

8) sizeBtree( tree ) -> n
                                  pre_condition:
                                  post_condition: (n + 1 per ogni leaf dell'albero)


9) levBtree( tree ) -> n
                                  pre_condition:
                                  post_condition: (n + 1 per ogni level dell'albero)

10) getRoot( leaf ) -> data
                                  pre_condition: (leaf != NULL)
                                  post_condition: (data è uguale all'oggetto inserito nel punto dell'albero)

11) isBST( tree ) -> flag
                                  pre_condition: (tree != NULL)
                                  post_condition: (flag = 0 se albero di ricerca binaria)
                                                  (flag = 1 se non albero di ricerca binaria)

12) searchMax( tree ) -> max
                                  pre_condition: (tree != NULL)
                                  post_condition: (max è uguale al valore della foglia posta sul
                                                  puntatore destro)
------------------------------------------------------------------------------*/
