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
/* 1) */int inserTree( tree, object );
/* 2) */tree newTree( void );
/* 3) */int contains( tree, char* );
/* 4) */void printLeaf( tree, char* );
/* 5) */int updateTree( tree, char*, char*, int, int );
/* 6) */void prinTree( tree );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1)

... altri operatori sono presenti nel codice del modulo base; questa scelta viene fatta sulla base
    dell'information hiding in modo da evitare che un utente possa venire a conoscenza della
    struttura interna di tutto il codice...
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE LIST----------------------
1)
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE LIST------------------------
1)
------------------------------------------------------------------------------*/
