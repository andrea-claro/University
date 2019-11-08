/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ point;
_ queue;
_ int;
_ struct node;
_ struct counter_stack;
------------------------------------------------------------------------------*/



#include "modulo_object_struct.h"



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct node* point;
typedef struct counter_nodes* queue;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ point:
        dove point è un insieme della doppia (item, *next)
            dove item è un dato di tipo object
            dove *next è un puntatore al tipo struct node

_ queue:
        dove point è un insieme della tripla (size, *head, *tail)
            dove size è un dato di tipo int
            dove *head è un puntatore al tipo struct node
            dove *tail è un puntatore al tipo struct node
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */object deQueue( queue );
/* 2) */int enQueue( queue, object );
/* 3) */int emptyQueue( queue );
/* 4) */int emptyNode( point );
/* 5) */point createPoint( void );
/* 6) */queue createQueue( void );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) eliminazionedi un elemento dalla coda;
2) inserimento di un elemento nella coda;
3) ricava informazioni sul fatto che la coda sia vuota o meno;
4) ricavare informazioni sul fatto che il nodo della coda sia vuoto o meno;
5) creare un punto della coda;
6) creare un punto capo della coda
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE STACK----------------------
1) deQueue( queue ) -> object;
2) enQueue( queue, object ) -> int;
3) emptyQueue( queue ) -> int;
4) emptyNode( point ) -> int;
5) createPoint( void ) -> point;
6) createQueue( void ) -> queue;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE STACK------------------------
1) deQueue( top ) -> data
                                  pre_condition: (top != NULL)
                                  post_condition: (l'elemento testa della coda)

2) enQueue( top, object ) -> flag
                                  pre_condition: (top != NULL)
                                  post_condition: (flag = 1 se la coda è stata riempita) || (flag = 0 se
                                                    la coda non è stata riempita)

3) emptyQueue( top ) -> flag
                                  pre_condition:
                                  post_condition: (flag = 1 se la coda è vuota) || (flag = 0 se
                                                   la coda non è vuota)

4) emptyNode( dot ) -> flag
                                  pre_condition:
                                  post_condition: (flag = 1 se il nodo è vuoto) || (flag = 0 se
                                                   il nodo non è vuoto)

5) createPoint( ) -> dot
                                  pre_condition:
                                  post_condition: (dot != NULL)

6) createQueue( ) -> top
                                  pre_condition:
                                  post_condition: (top != NULL)

------------------------------------------------------------------------------*/
