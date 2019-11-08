/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ hashtable;
_ hashmodule;
_ int;
_ char;
_ struct elem;
_ struct hash;
------------------------------------------------------------------------------*/



/*-----------------------------TIPI DI DATO CREATI----------------------------*/

typedef struct hash* hashtable;
typedef struct elem* hashmodule;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ hashtable:
        hashtable è un insieme della doppia (**table, size)
            dove **table è un array di puntatori di un tipo struct elem
            dove size è un dato di tipo int

_ hashmodule:
        hashmodule è un insieme della doppia (*next, item)
            dove *next è un puntatore ad un tipo struct elem
            dove item è un dato di tipo object
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */void destroyHash( hashtable );
/* 2) */int deleteHash( hashtable, char* );
/* 3) */object searchHash( hashtable, char* );
/* 4) */int insertHash( hashtable, object );
/* 5) */hashtable newHashtable( int );
/* 6) */int hash( char *, int );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) cancellare una tabella dati;
2) cancellare l'elemento della tabella con una data chiave;
3) ricerca di un elemento all'interno della tabella;
4) inserimento di elementi all'interno della tabella dati;
5) creazione di una nuova tabella dati;
6) funzione di modularizzazione per l'oggetto della tabella;

... altri operatori sono presenti nel codice del modulo base; questa scelta viene fatta sulla base
    dell'information hiding in modo da evitare che un utente possa venire a conoscenza della
    struttura interna di tutto il codice...
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE HASH----------------------
1) destroyHash( hashtable ) -> void;
2) deleteHash( hashtable, char* ) -> int;
3) searchHash( hashtable, char* ) -> object;
4) insertHash( hashtable, hashmodule ) -> int;
5) newHashtable( int ) -> hashtable;
6) hash( char *, int ) ->int;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE HASH------------------------
1) destroyHash( table={} ) ->
                                  pre_condition:
                                  post_condition: table=NULL

2) deleteHash( table={}, info ) -> flag
                                  pre_condition: table != NULL, data != NULL
                                  post_condition: flag=1 se data_i=info di tree={data_1, data_2,..., data_n} eliminato, altrimenti flag=0

3) searchHash( table={}, info ) -> data={}
                                  pre_condition: table != NULL, data != NULL
                                  post_condition:  mod_i=info di tree={mod_1, mod_2,..., mod_n} riportato, altrimenti flag=0

4) insertHash( table={}, mod={} ) -> flag
                                  pre_condition: table != NULL, mod != NULL
                                  post_condition: flag=1 se mod viene aggiunto a tree={mod_1, mod_2,..., mod_n}, altrimenti flag=0

5) newHashtable( size ) -> table={}
                                  pre_condition: size>0
                                  post_condition: table={mod_1, mod_2,..., mod_n} dove n=size

6) hash( nome, size ) -> mod
                                  pre_condition:
                                  post_condition: mod=il modulo della somma del codice ASCII delle lettere del nome per la grandezza
------------------------------------------------------------------------------*/
