/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ pile;
_ head;
_ int;
_ struct node;
_ struct counter_stack;
------------------------------------------------------------------------------*/



#include "modulo_object_struct.h"



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct counter_stack* pile;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ pile:
        list è un insieme dei dati di tipo head
            dove head è un insieme della doppia (size, *first)
                dove size è un dato di tipo int
                dove *first è un puntatore al tipo struct node
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */int pushStack( pile, object );
/* 2) */int emptyStack( pile );
/* 3) */pile createPile( void );
/* 4) */int popStack( pile );
/* 5) */object getFirst( pile );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) inserire un elemento nella pila;
2) ricavare come informazione il fatto che la pila sia vuota o meno
3) creare un punto-capo della pila
4) rimuovere un elemento dalla pila
5) recuperare informazioni riguardanti il primo elemento della pila
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE STACK----------------------
1) pushStack( pile ) -> int;
2) emptyStack( pile ) -> int;
3) createHead( void ) -> head;
4) pop( pile ) -> int;
5) getFirst( pile ) -> object;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE STACK------------------------
1) pushStack( top ) -> flag
                                  pre_condition: (top != NULL)
                                  post_condition: (flag = 1 se l'elemento è stato aggiunto) || (flag = 0 se
                                                    l'elemento non è stato aggiunto)

2) emptyStack( top ) -> flag
                                  pre_condition: (top != NULL)
                                  post_condition: (flag = 1 se lo stack è vuoto) || (flag = 0 se
                                                    lo stack non è vuoto)

3) createHead( ) -> top
                                  pre_condition:
                                  post_condition: (top != NULL)

4) pop( top ) -> flag
                                  pre_condition: (top != NULL)
                                  post_condition: (flag = 1 se l'eliminazione dell'elemento è andata a buon
                                                fine) || (flag = 0 se l'eliminazione dell'elemento è fallita)

5) getItem( top ) -> data
                                  pre_condition: (top != NULL)
                                  post_condition: (data != NULL)
------------------------------------------------------------------------------*/
