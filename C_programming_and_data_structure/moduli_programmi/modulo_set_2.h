/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ set;
_ int;
_ struct counter_sets;
------------------------------------------------------------------------------*/
#include "modulo_object.h"



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct counter_sets* set;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ set:
        set è un elemento capo dell'insieme set(head)
            dove head è un puntatore ad una struttura capo di una lista
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */int addNumber( set, object );
/* 2) */void printSet( set );
/* 3) */set createSet( void );
/* 4) */set insertSet( int );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) aggiungere un elemento all'insieme set
2) stampare l'insieme set
3) creare un elemento insieme di tipo set
4) inserire un numero prefissato di elementi in un insieme set
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE SET----------------------
1) addNumber( set, object ) -> boolean;
2) printSet( set ) -> void;
3) createSet( void ) -> set;
4) insertSet( int ) -> set;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE LIST------------------------
1) addNumber( x={e_1, e_2,..., e_n}, data ) -> flag
                                  pre_condition: (x={..., e_n,..., data, ..., e_m} dove (data > 0))
                                  post_condition: (flag= 1 se l'aggiunta è riuscita) || (flag= 0 se
                                                   l'aggiunta non è andata a buon termine)

2) printSet( x={e_1, e_2,..., e_n} ) ->
                                  pre_condition:
                                  post_condition: (stampa degli elementi di x{})

3) createSet( void ) -> x={e_1, e_2,..., e_n}
                                  pre_condition:
                                  post_condition: x={} viene allocato in memoria

4) insertSet( n ) -> x={e_1, e_2,..., e_n}
                                  pre_condition: (n > 0)
                                  post_condition: (x={e_1, e_2,..., e_n} dove n è il numero di elementi
                                                  scelto precedentemente)
------------------------------------------------------------------------------*/
