/********************************************************************************
* Il seguente file di testo risulta essere un ADT oggetto, contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di un elemento generico.
*********************************************************************************/



/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ int;
_ char;
------------------------------------------------------------------------------*/


/*------------------------------------MACRO-----------------------------------*/
#define NULLITEM NULL
/*----------------------------------------------------------------------------*/



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef struct item* object;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ object:
        object è un oggetto insieme di(*nome, gameplay, points, goal_w, goal_f)
            dove *nome è un elemento del tipo char*;
            dove gameplay è un elemento del tipo int;
            dove points è un elemento del tipo int;
            dove goal_w è un elemento del tipo int;
            dove goal_f è un elemento del tipo int;
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */object insertObject( void );
/* 2) */void printObject( object );
/* 3) */char* getObject( object );
/* 4) */int compareObject( object, object );
/* 5) */object newObject( void );
/* 6) */void deleteObject( object );
/* 7) */char* getKey( object );
/* 8) */void updateSeats( object, int );
/* 9) */void updatePrice( object, int );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) registrare un elemento di tipo object;
2) stampare un elemento di tipo object;
3) ricavare un elemento di object;
4) comparare due elementi di tipo object;
5) creare un nuovo tipo object;
6) cancellare un elemento object;
7) ricavare l'elemento chiave di object;
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE OBJECT--------------------
1) insertObject( void ) -> object;
2) printObject( object ) -> void;
3) getObject( object ) -> int;
4) compareObject( object, object ) -> int;
5) object newObject( void ) -> object;
6) deleteObject( object ) -> void;
7) getKey( object data ) -> char*;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE OBJECT----------------------
1) insertObject( ) -> data
                                  pre_condition:
                                  post_condition: (data={data_1, data_2, data_3, data_4, data_5})

2) printObject( data={} ) ->
                                  pre_condition: (data={data_1, data_2, data_3, data_4, data_5} != NULL)
                                  post_condition: (stampa a video di data_i per ogni i da 1 a n, dove n
                                                  è il numero degli elementi presenti in data={})

3) getObject( data={} ) -> info
                                  pre_condition: (data={} != NULL)
                                  post_condition: (info che appartiene a data={} viene ritornato)

4) compareObject( a={}, b={} ) -> flag
                                  pre_condition: (a={} != NULL con info elemento che appartiene ad a={}) &&
                                                  (b={} != NULL con info' elemento che appartiene a b={})
                                  post_condition: (flag = 0 se info = info') || (flag = -1 se info < info')
                                                  || (flag = 1 se info > info')

5) newObject( ) -> data={}
                                  pre_condition:
                                  post_condition: (data={} viene ritornato)

6) deleteObject( data={} ) ->
                                  pre_condition:
                                  post_condition: (data={} = NULL)

7) getKey( data={} ) -> info
                                  pre_condition: (data={} != NULL)
                                  post_condition: (info che appartiene a data={} viene ritornato)
------------------------------------------------------------------------------*/
