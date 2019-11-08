/********************************************************************************
* Il seguente file di testo risulta essere un ADT hash contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di un hashtable di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include <stdio.h>
#include <stdlib.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object_struct.h"



/*--------------------------TIPI DI DATO CREATI-------------------------------*/
struct hash{ //struttura capo tabella raffigurante una legenda della struttura dati
   int size; //elemento di riferimento per la quantità di moduli della tabella dati
   struct elem **table; //array di puntatori per i moduli della tabella dati
};

struct elem{ //struttura modulo della tabella di dati
   object item; //oggetto dato della tabella
   struct elem *next; //puntatore al successivo elemento della tabella dati appartenente allo stesso modulo
};



/*-----------------------OPERATORI NASCOSTI UTILIZZATI------------------------*/
/* 1) */static void deleteList(struct elem *);
/*----------------------------------------------------------------------------*/



/*----------------------DESCRIZIONE OPERATORI NASCOSTI--------------------------
1) cancellazione dell'elemento del modulo della tabella dati;
------------------------------------------------------------------------------*/



/*-----------------SPECIFICA SINTATTICA OPERATORI NASCOSTI----------------------
1) deleteList(struct elem *) -> void;
------------------------------------------------------------------------------*/



/*------------------SPECIFICA SEMANTICA OPERATORI NASCOSTI----------------------
1) deleteList( el={} ) ->
                                  pre_condition:
                                  post_condition: el=NULL
------------------------------------------------------------------------------*/



/*-------------------------------OPERATORI------------------------------------*/
static void deleteList( struct elem *p ) {
    if (p  ==  NULL)
        return;
    deleteList( p->next );
    free( p );
}



/*
int hash( char *k, int size ){

  int
      len= strlen( k );
      v= (k[0]  +  k[len-1]  +  len);
  return (v  %  size);
}



int hash( char *k, int size ){

  int sum= 0;

  while((*k)  !=  '\0'){
      sum+= (*k);
      k++;
  }
return (sum  %  size);
}



int hash( char *v, int m ){

  int
      h= 0,
      a= 128;

  for( ; *v  !=  '\0'; v++ )
      h= ((a*h) + (*v)) % m;

  return h;
}



int hash( char *k, int m ){

 int
    len= strlen( k ),
    val= k[0] + k[len-1] + len;

 return (val % m);
}
*/



void destroyHash( hashtable h ){

    for( int i= 0; i  <  h->size; i++ ){
        deleteList( h->hash[i] );
    }
    free( h->hash );
}



int deleteHash( hashtable h, char *key ){

  int idx= hash(key, h->size);
  hashmodule
            prev,
            curr,
            head;

  prev= curr= head= h->hash[idx];

  while( curr ){
        if( !strcmp(curr->key, key) ){
             if(curr  ==  head) // cancello in testa
                h->hash[idx]= curr->next;
             else
                prev->next= curr->next;
             return (1);
        }
        prev= curr;
        curr= curr->next;
  }
return (0);
}



hashmodule searchHash( hashtable h, char* key ){

  int idx= hash(key, h->size);
  hashmodule curr;

  curr= h->table[idx];

  while( curr ){    // controllo se esiste un item
                    // con la stessa chiave key
     if( !strcmp(curr->key, key) )
        return curr;
     curr= curr->next;
   }
   // elemento non trovato
  return NULLITEM;
}



/*
item HashSearch( hashtable h, char *key ){

  int
      idx,
      start
      i= 0;

  start= idx= hash( key, i, h->size );

  do{
      if(h->hash[idx]  ==  NULL){ /* posto libero
      return NULL;
      }

      hashmodule temp= h->hash[idx];
      else if( !strcmp(temp->key, key) )
          return h->hash[idx];

      else {
          i++;
          idx= hash( key, i, h->size );
      }
  }while(idx  !=  start);

  return NULL;
}



int hashInsert( hashtable h, char *key, int a, int b ){

  int
      idx,
      start,
      i = 0,
      len= h->size;

  start= id = hash( key, i, h->size );

  do{
      if(h->hash[idx]  ==  NULL){ /* posto libero
          h->hash[idx]= newItem(key,a,b);
          return (1);
      }
      else { /* prova successivo
          i++;
          idx= hash( key, i, h->size );
      }
  }while(idx  !=  start);
return (0);
}
*/


int insertHash( hashtable h, hashmodule el ){

  int idx= hash(el->key, h->size);
  hashmodule
            head,
            curr;

   curr= head= h->table[idx];

   while( curr ){    // controllo se esiste già un item
                    // con la stessa chiave di el
      if( !strcmp(curr->key, el->key) )
         return (-1);
      curr= curr->next;
   }
   // inserisce in testa alla lista
   h->table[idx]= el;
   hashmodule temp= h->table[idx];
   temp->nex = head;

   return (0);
}



hashtable newHashtable( int size ){

  hashtable h= malloc(sizeof(struct hash));

  h->size= size;
  h->table= (struct elem **)malloc(size*sizeof(struct elem*));

  for(int i= 0; i  <  size; i++ ){
      h->table[i]= NULL;
  }

return h;
}
