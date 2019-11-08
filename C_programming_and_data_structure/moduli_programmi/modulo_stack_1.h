/********************************************************************************
* Il seguente file di testo risulta essere un ADT pila contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di uno stack
* di elementi.
*********************************************************************************/



/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ pile;
_ head;
_ int;
_ struct node;
_ struct counter_stack;
------------------------------------------------------------------------------*/



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct counter_stack* head;
typedef struct node* pile;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ pile:
        list è un insieme della doppia (item, *behind)
            dove item è un dato di tipo object
            dove *behind è un puntatore al tipo struct node

_ head:
        head è un insieme della doppia (size, *first)
            dove size è un dato di tipo int
            dove *first è un puntatore al tipo struct node
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */int pushStack( head );
/* 2) */int emptyStack( head );
/* 3) */pile createNode( void );
/* 4) */head createHead( void );
/* 5) */int pop( head );
/* 6) */object getItem( head );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) inserire un elemento nella pila;
2) ricavare come informazione il fatto che la pila sia vuota o meno
3) creare un nodo dello stack
4) creare un punto-capo della pila
5) rimuovere un elemento dalla pila
6) recuperare informazioni riguardanti il primo elemento della pila
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE STACK----------------------
1) pushStack( head ) -> int;
2) emptyStack( head ) -> int;
3) createNode( void ) -> pile;
4) createHead( void ) -> head;
5) pop( head ) -> int;
6) getItem( head ) -> object;
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

3) createNode( ) -> node
                                  pre_condition:
                                  post_condition: (node != NULL)

4) createHead( ) -> top
                                  pre_condition:
                                  post_condition: (top != NULL)

5) pop( top ) -> flag
                                  pre_condition: (top != NULL)
                                  post_condition: (flag = 1 se l'eliminazione dell'elemento è andata a buon
                                                fine) || (flag = 0 se l'eliminazione dell'elemento è fallita)

6) getItem( top ) -> data
                                  pre_condition: (top != NULL)
                                  post_condition: (data != NULL)
------------------------------------------------------------------------------*/
