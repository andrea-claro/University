/********************************************************************************
* Il seguente file di testo risulta essere un ADT hashtable contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di un hash di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object.h"
#include "modulo_hashtable.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct hash{ //struttura capo tabella raffigurante una legenda di quest'ultima
   int size; //oggetto di memoria per la quantità di modularizzazioni della tabella
   struct elem **table; //modularizzazione della tabella
};

struct elem{ //struttura punto della tabella
   object item; //oggetto della tabella
   struct elem *next; //puntatore al successivo elemento della data modularizzazione della tabella
};



/*-----------------------OPERATORI NASCOSTI UTILIZZATI------------------------*/
/* 1) */static void deleteList( struct elem* );
/*----------------------------------------------------------------------------*/



/*----------------------DESCRIZIONE OPERATORI NASCOSTI--------------------------
1) cancellazione di un elemento di un modulo della tabella;
------------------------------------------------------------------------------*/



/*-----------------SPECIFICA SINTATTICA OPERATORI NASCOSTI----------------------
1) deleteList( struct elem* ) -> void;
------------------------------------------------------------------------------*/



/*------------------SPECIFICA SEMANTICA OPERATORI NASCOSTI----------------------
1) deleteList( point ) ->
                                  pre_condition: (point != NULL)
                                  post_condition: (viene liberato lo spazio di memoria occupato da point)
------------------------------------------------------------------------------*/



/*-------------------------------OPERATORI------------------------------------*/
int insertHash( hashtable matrix, point data ){

  int idx= hash( getKey(data), matrix ->size );
  point
        head,
        curr;

  curr= head= matrix ->table[idx];

  while( curr ){    // controllo se esiste già un item
                    // con la stessa chiave di data
      if( !strcmp(getKey(curr), getKey(data)) )
          return (-1);
      curr= curr ->next;
   }
   // inserisce in testa alla lista
   matrix ->table[idx]= data;
   matrix ->table[idx]->next= head;
   return (0);
}



hashtable newHashtable( int n ){

  hashtable newhash= malloc(sizeof(struct hash));
  newhash ->size= size;
  newhash ->table= (struct elem **)malloc(size*struct elem*));

  for( int i=0; i < size; i++ )
     newhash ->table[i]= newObject();

  return newhash;
}



point searchElem( hashtable matrix, char* key ){

  int idx= hash( key, matrix ->size );
  point curr= matrix ->table[idx];

  while( curr ){    // controllo se esiste un item
                    // con la stessa chiave key
      if( !strcmp(getKey(curr), key) )
          return(curr);
      curr= curr ->next;
   }
   // elemento non trovato
   return NULLITEM;
}



int deleteElem( hashtable matrix, char *key ){

  int idx= hash( key, matrix ->size );
  point
       prec,
       curr,
       head;

  prev= curr= head= matrix ->hash[idx];

  while( curr ){

      if( !strcmp(getKey(curr), key) ){
          if(curr == head) // cancello in testa
              matrix ->hash[idx]= curr ->next;
              deleteObject( curr );
          else
              prec ->next= curr ->next;

          return (1);
        }

        prec= curr;
        curr= curr ->next;
  }
  return (0);
}



static void deleteList( struct elem* data ){

    if(data == NULL)
        return;

    deleteList( data ->next );
    deleteObject( data );
}



void destroyHash( hashtable matrix ){

  for( int k= 0; k < matrix ->size; k++ )
      deleteList( matrix ->table[k] );

  free( matrix ->table );
  free( matrix );
}



int hash( char *x, int size ){

  int
       len= strlen( x ),
       v= ( x[0] + x[len-1] + len );

  return (v % size);
}
