/********************************************************************************
* Il seguente file di testo risulta essere un ADT oggetto, contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di un elemento di una lista
* concatenata di elementi.
*********************************************************************************/



/*----------------DESCRIZIONE TIPI DI DATO UTILIZZATI---------------------------
All'interno del file vengono utilizzati dati del tipo:
_ object;
_ int;
------------------------------------------------------------------------------*/



/*-----------------------------TIPI DI DATO CREATI----------------------------*/
typedef int object;
/*----------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA DEI DATI CREATI------------------
_ object:
        object è un alias del tipo int
            dove int è un intero
------------------------------------------------------------------------------*/



/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */object insertObject( void );
/* 2) */void printObject( object );
/* 3) */object getObject( object );
/* 4) */int compareObject( object, object );
/* 5) */object newObject( void );
/* 6) */void deleteObject( object );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) registrare un elemento di tipo object
2) stampare un elemento di tipo object
3) ricavare un elemento di tipo object
4) comparare due elementi di tipo object per sapere se uguali
5) creare un nuovo tipo object
6) cancellare un elemento object
------------------------------------------------------------------------------*/



/*--------------------------SPECIFICA SINTATTICA FILE OBJECT--------------------
1) insertObject( void ) -> object;
2) printObject( object ) -> void;
3) getObject( object ) -> object;
4) compareObject( object, object ) -> int;
5) object newObject( void ) -> object;
6) deleteObject( object ) -> void;
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SEMANTICA FILE OBJECT----------------------
1) insertObject( ) -> data
                                  pre_condition:
                                  post_condition: (data != NULL)

2) printObject( data ) ->
                                  pre_condition: (data != NULL)
                                  post_condition: stampa dell'elemento a video

3) getObject( data ) -> info
                                  pre_condition: (data != NULL)
                                  post_condition: (info != NULL)

4) compareObject( a, b ) -> flag
                                  pre_condition: (a != NULL) && (b != NULL)
                                  post_condition: (flag = 1 se gli elementi sono uguali) || (flag = 0
                                                  se gli elementi sono diversi)

5) object newObject( ) -> data
                                  pre_condition:
                                  post_condition: (data == NULL)

6) deleteObject( data ) ->
                                  pre_condition: (data != NULL)
                                  post_condition: (data == NULL)
------------------------------------------------------------------------------*/
