/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ hashtable;
_ point;
_ char;
_ int;
_ struct hash;
_ struct elem;
------------------------------------------------------------------------------*/



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct hash* hashtable;
typedef struct elem* point;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ hashtable:
        hashtable è un insieme della doppia (**table, size)
            dove **table è un array di puntatori ad un tipo struct elem
            dove size è un dato di tipo int

_ point:
        point è un insieme della doppia (*next, item)
            dove *next è un puntatore ad un tipo struct elem
            dove item è un oggetto di tipo object
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */void destroyHash( hashtable );
/* 2) */int hash( char *, int );
/* 3) */int deleteElem( hashtable, char * );
/* 4) */point searchElem( hashtable, char * );
/* 5) */hashtable newHashtable( int );
/* 6) */int insertHash( hashtable, point );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) distrugge la tabella hash;
2) funzione hash per la modularizzazione dei dati all'interno della tabella;
3) distruzione dell'elemento con la chiave prescelta;
4) ritorno dei dati se presenti nella tabella relativi all'informazione richiesta;
5) creazione di una tabella hash;
6) inserimento di un informazione all'interno della tabella;

... altri operatori sono presenti nel codice del modulo base; questa scelta viene fatta sulla base
    dell'information hiding in modo da evitare che un utente possa venire a conoscenza della
    struttura interna di tutto il codice...
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE HASH----------------------
1) destroyHash( hashtable ) -> void;
2) hash( char *, int ) -> int;
3) deleteElem( hashtable, char * ) -> int;
4) searchElem( hashtable, char * ) -> point;
5) newHashtable( int ) -> hashtable;
6) insertHash( hashtable, point ) -> int;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE LIST------------------------
1) destroyHash( matrix ) ->
                                  pre_condition:
                                  post_condition: (matrix = NULL)

2) hash( key, n ) -> nhash
                                  pre_condition: (key != NULL)
                                  post_condition: (nhash != n)

3) deleteElem( matrix, key ) -> flag
                                  pre_condition: (matrix != NULL) && (key != NULL)
                                  post_condition: (flag = 1 se l'elemento è stato cancellato ) ||
                                                  (flag = 0 se l'elemento non è stato cancellato)

4) searchElem( matrix, key ) -> data
                                  pre_condition: (matrix != NULL) && (key != NULL)
                                  post_condition: (il data uscente avrà chiave uguale a quella prescelta)

5) newHashtable( n ) -> matrix={}
                                  pre_condition: (n > 0)
                                  post_condition: (matrix={} con grandezza in memoria pari a n)

6) insertHash( matrix, data ) -> flag
                                  pre_condition: (matrix={} != NULL) && (data={} != NULL)
                                  post_condition: (flag = 1 se l'elemento è stato aggiunto) ||
                                                  (flag = 0 se l'elemento non è stato aggiunto)

------------------------------------------------------------------------------*/
