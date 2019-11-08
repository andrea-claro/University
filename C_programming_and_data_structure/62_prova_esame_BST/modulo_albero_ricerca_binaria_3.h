/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ tree;
_leaf;
_ int;
_ struct node;
_ struct counter_nodes;
------------------------------------------------------------------------------*/



#include "modulo_object_struct.h"



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct c_tree* tree;
typedef struct node* leaf;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ tree:
        tree è un insieme della doppia (*root, size)
            dove *root è un puntatore ad un tipo struct node
            dove size è un dato di tipo int

_ leaf:
        leaf è un insieme della tripla (*left, *right, item)
            dove *left è un puntatore ad un tipo struct node
            dove *right è un puntatore ad un tipo struct node
            dove item è un dato di tipo object
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */tree newTree( void );
/* 2) */int emptyTree( leaf );
/* 3) */int cardinality( tree );
/* 4) */object contains( tree, char* );
/* 5) */int inserTree( tree, object );
/* 6) */int removeTree( tree, object );
/* 7) */void prinTree( tree );
/* 8) */int sizeBtree( tree );
/* 9) */int levBtree( tree );
/* 10) */int getRoot( leaf );
/* 11) */int isBST( tree );
/* 12) */int searchMax( tree );
/* 13) */leaf consTree( object, leaf, leaf );
/* 14) int inOrderIter( tree );
15) int postOrderIter( tree );
16) int preOrderIter( tree );
17) int levelOrderIter( tree );*/
/* 18) */int emptyBtree( tree );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) creare un nuovo capo-nodo dell'albero;
2) ricavare informazione sul fatto che l'albero sia vuoto o meno;
3) ricavare se il nodo è vuoto o meno;
4) ricavare come informazione il fatto che un elemento sia presente o meno nell'albero;
5) inserimento di elementi all'interno dell'albero;
6) cancellazione di elementi all'interno di un albero;
7) stampa a video degli oggetti contenuti nell'albero;
8) conteggio del numero di foglie totali di un albero;
9) conteggio del numero di livelli dell'albero binario;
10) ricavare l'oggetto della foglia;
11) verifica se l'albero è di ricerca binaria;
12) ricerca del massimo in un albero binario;
13) costruzione di un albero a partire da due sottoalberi;
14) visita di un albero in ordine con algoritmo iterativo;
15) visita di un albero in postordine con algoritmo iterativo;
16) visita di un albero in preordine con algoritmo iterativo;
17) visita di un albero per livelli con algoritmo iterativo;
18) ricavare se l'albero è vuoto o meno;

... altri operatori sono presenti nel codice del modulo base; questa scelta viene fatta sulla base
    dell'information hiding in modo da evitare che un utente possa venire a conoscenza della
    struttura interna di tutto il codice...
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE TREE----------------------
1) newTree( void ) -> tree;
2) emptyTree( leaf ) -> int;
3) cardinality( tree ) -> int;
4) contains( tree, char* ) -> object;
5) inserTree( tree, char* ) -> int;
6) removeTree( tree, object ) -> int;
7) prinTree( tree ) -> void;
8) sizeBtree( tree ) -> int;
9) levBtree( tree ) ->int;
10) getRoot( leaf ) -> int;
11) isBST( tree ) -> int;
12) searchMax( tree ) -> int;
13) consTree( object, leaf, leaf ) -> leaf;
14) inOrderIter( tree ) -> int;
15) postOrderIter( tree ) -> int;
16) preOrderIter( tree ) -> int;
17) levelOrderIter( tree ) -> int;
18) emptyBtree( tree ) -> int;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE TREE------------------------
1) newTree( ) -> tree={}
                                  pre_condition:
                                  post_condition: tree={ NULL }

2) emptyTree( leaf={} ) -> flag
                                  pre_condition: tree != NULL
                                  post_condition: flag=1 se leaf={ NULL }, altrimenti flag=0

3) cardinality( tree={} ) -> size
                                  pre_condition: tree != NULL
                                  post_condition: size=-1 se tree={ NULL }, altrimenti size=n dove n è il numero degli elementi di tree

4) contains( tree={}, info ) -> data={}
                                  pre_condition: tree != NULL, data != NULL
                                  post_condition: tree={leaf_1, leaf_2,..., leaf_n} e leaf={data_1=(), data_2=(), ..., data_n=()} e info= data_i data_i viene ritornato
5) inserTree( tree={}, data={} ) -> flag
                                  pre_condition: tree != NULL, data != NULL
                                  post_condition: tree={leaf_1, leaf_2,..., leaf_n} e flag=1 se data non è già una leaf e tree'={leaf_1, leaf_2,...,data,..., leaf_n}, altrimenti flag=0

6) removeTree( tree={}, data={} ) -> flag
                                  pre_condition: tree != NULL, data != NULL
                                  post_condition: tree={leaf_1, leaf_2,...,data..., leaf_n} e flag=1 se data è già una leaf e tree'={leaf_1, leaf_2,..., leaf_n}. altrimenti flag=0

7) prinTree( tree={} ) ->
                                  pre_condition: tree != NULL
                                  post_condition: ogni data_i di tree={data_1, data_2,..., data_n} viene stampato a video

8) sizeBtree( tree ) -> n
                                  pre_condition: tree != NULL
                                  post_condition: tree={data_1, data_2,..., data_n} dove n è il numero di elementi


9) levBtree( tree ) -> n
                                  pre_condition: tree != NULL
                                  post_condition: tree={lev_1, lev_2,..., lev_n} dove n è il numero di livelli dell'albero

10) getRoot( leaf={} ) -> data
                                  pre_condition: leaf != NULL
                                  post_condition: leaf={data_1, data_2,..., data_n} e data=data_i appartenente a leaf

11) isBST( tree={} ) -> flag
                                  pre_condition: tree != NULL
                                  post_condition: flag = 0 se albero di ricerca binaria, altrimenti flag=1

12) searchMax( tree={} ) -> max
                                  pre_condition: tree != NULL
                                  post_condition: tree={leaf_1, leaf_2,...,data..., leaf_n} e max= l'oggetto data_i massimo appertenente ad uno degli oggetti leaf_i

13) consTree( data={}, sx={}, dx={} ) -> root
                                  pre_condition:
                                  post_condition: root={data, sx, dx }

14) inOrderIter( tree={} ) -> flag
                                  pre_condition: tree != NULL
                                  post_condition: tree={leaf_1, leaf_2,...,data..., leaf_n} e flag=1 se stampato in ordine(foglia_sx, foglia, foglia_dx), altrimenti flag=0

15) postOrderIter( tree={} ) -> flag
                                  pre_condition: tree != NULL
                                  post_condition: tree={leaf_1, leaf_2,...,data..., leaf_n} e flag=1 se stampato in ordine(foglia_sx, foglia_dx, foglia), altrimenti flag=0

16) preOrderIter( tree={} ) -> flag
                                  pre_condition: tree != NULL
                                  post_condition: tree={leaf_1, leaf_2,...,data..., leaf_n} e flag=1 se stampato in ordine(foglia, foglia_sx, foglia_dx), altrimenti flag=0

17) levelOrderIter( tree={} ) -> flag
                                  pre_condition: tree != NULL
                                  post_condition: tree={leaf_1, leaf_2,...,data..., leaf_n} e flag=1 se stampato in ordine di livelli, altrimenti flag=0

18) emptyBtree( tree={} ) -> flag
                                  pre_condition: tree != NULL
                                  post_condition: flag=1 se tree={ NULL }, altrimenti flag=0

------------------------------------------------------------------------------*/
