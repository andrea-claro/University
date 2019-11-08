/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ list;
_ head;
_ int;
_ struct node;
_ struct counter_nodes;
------------------------------------------------------------------------------*/



#include "modulo_object.h"



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct node* list;
typedef struct counter_nodes* head;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ list:
        list è un insieme della doppia (item, *next)
            dove item è un dato di tipo getObject
            dove *next è un puntatore al tipo list

_ head:
        head è un insieme della doppia (size, *first)
            dove size è un dato di tipo int
            dove *first è un puntatore al tipo list
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */head createHead( void );
/* 2) */int sizeList( head );
/* 3) */int emptyList( head );
/* 5) */int addingNode( int, head, object );
/* 6) */int deletePos( int, head );
/* 7) */int deleteList( head );
/* 8) */void printPos( int, head );
/* 9) */void printList( head );
/* 10) */head cloneList( head );
/* 11) */int searchList( head, object);
/* 12) */head reverseList( head );
/* 13) */head insertList( int );
/* 14) */object getItem( head, int );
/* 15) */int estraiMaxN( head, int);
/* 16) */int inserMinN( head, object, int );
/* 17) */void deleteNode( list );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) creare un elemento testa della lista che punta al primo punto-lista;
2) ricavare la dimensione della lista
3) ricavare come informazione il fatto che la lista sia vuota o meno
5) aggiungere un elemento alla lista in una data posizione
6) cancellare un elemento della lista in una data posizione
7) cancellare una lista
8) stampare a video un elemento della lista in una data posizione
9) stampare la lista
10) clonare la lista
11) scoprire se un elemento è presente o meno nella lista
12) capovolgere una lista
13) inserire n elementi in una lista, dove n è un numero scelto dall'utente
14) ricavare i dati presenti in una data posizione in lista
15) estrarre, cancellandolo il massimo tra n elementi della lista
16) inserire un elemento prima del minimo tra n elementi
17) eliminare un nodo

... altri operatori sono presenti nel codice del modulo base; questa scelta viene fatta sulla base
    dell'information hiding in modo da evitare che un utente possa venire a conoscenza della
    struttura interna di tutto il codice...
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE LIST----------------------
1) createHead( void ) -> head;
2) sizeList( head ) -> int;
3) emptyList( head ) -> int;
5) addingNode( int, head, object ) -> int;
6) deletePos( int, head ) -> int;
7) deleteList( head ) -> int;
8) printPos( int, head ) -> void;
9) printList( head ) -> void;
10) cloneList( head ) -> head;
11) searchList( head, object) -> int;
12) reverseList( head ) -> head;
13) insertList( int ) -> head;
14) getItem( head, int ) -> object;
15) estraiMaxN( head, int) -> int;
16) inserMinN( head, object, int ) -> int;
17) deleteNode( list ) -> void;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE LIST------------------------
1) createHead( ) -> top
                                  pre_condition:
                                  post_condition: (top != NULL)

2) sizeList( top ) -> n
                                  pre_condition: (top != NULL)
                                  post_condition: (n >= 0 dove n è la dimensione della lista)

3) emptyList( top ) -> flag
                                  pre_condition: (top != NULL)
                                  post_condition: (flag = 1 se la lista risulta vuota) || (flag = 0 se la
                                                  lista è piena)

5) addingNode( pos, top, data ) -> flag
                                  pre_condition: (pos >= 0) && (pos < (dimensione lista)) && (top != NULL)
                                  post_condition: (flag = 1 se l'aggiunta dell'elemento è andata a buon
                                                  fine) || (flag = 0 se l'aggiunta dell'elemento è fallita)

6) deletePos( pos, top ) -> flag
                                  pre_condition: (pos >= 0) && (pos < (dimensione lista)) && (top != NULL)
                                  post_condition: (flag = 1 se l'eliminazione dell'elemento ha
                                                  avuto successo) || (flag = 0 se l'eliminazione
                                                  dell'elemento è fallita)

7) deleteList( top ) -> flag
                                  pre_condition: (top != NULL)
                                  post_condition: (flag = 1 se (dimensione lista) = 0) || (flag = 0
                                                  se la lista non è stata eliminata)

8) printPos( pos, top ) ->
                                  pre_condition: (pos >= 0) && (pos < (dimensione lista)) && (top != NULL)
                                  post_condition: (stampa dell'elemento di posizione ricercata)

9) printList( top ) ->
                                  pre_condition: (top != NULL)
                                  post_condition: (stampa gli elementi della lista)

10) cloneList( top ) -> top'
                                  pre_condition: (top != NULL)
                                  post_condition: (list = <e_1, e_2, e_3, ..., e_n>
                                                   list' = <e_1', e_2', e_3', ..., e_n'> dove per ogni
                                                   e_i' = e_i)

11) searchList( top, data) -> flag
                                  pre_condition: (pos >= 0) && (pos < (dimensione lista)) && (top != NULL)
                                  post_condition: (flag = pos dell'elemento se presente in lista) ||
                                                  (flag = 0 se l'elemento non è presente in lista)

12) reverseList( top ) -> top'
                                  pre_condition: (top != NULL)
                                  post_condition: (top = <e_1, e_2, e_3, ..., e_n> &&
                                                  top' = <e_n, ..., e_3, e_2, e_1> dove "e" è un
                                                  elemento generico)

13) insertList( n ) -> top
                                  pre_condition: (n >= 0 dove n è il numero di elementi da voler inserire)
                                  post_condition: (top != NULL && top = <e_1, e_2, ..., e_n> dove "e" è
                                                  un elemento generico) && ((dimensione lista) = n)

14) getItem( top, pos ) -> data
                                  pre_condition: (pos >= 0) && (pos < (dimensione lista)) && (top != NULL)
                                  post_condition: (data != NULL)

15) estraiMaxN( top, n) -> flag
                                  pre_condition: (top != NULL) && (n >= 0) && (n < sizeList( top ))
                                  post_condition: (flag = 1 se sizeList( top ) - 1 ) || (flag = 0
                                                  se sizeList( top ))

16) inserMinN( top, data, n ) -> flag
                                  pre_condition: (top != NULL) && (n >= 0) && (n < sizeList( top )) && (data != NULL)
                                  post_condition: (flag = 1 se sizeList( top ) + 1 ) || (flag = 0
                                                  se sizeList( top ))

17) deleteNode( node ) ->
                                  pre_condition: (node != NULL)
                                  post_condition: (il nodo viene cancellato)
------------------------------------------------------------------------------*/
