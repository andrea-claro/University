/********************************************************************************
* Il seguente file di testo risulta essere un ADT hash contenente operatori
* capaci di svolgere funzioni generali, adibite all'uso di un hashtable di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object_struct.h"
#include "modulo_hash_1.h"



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
/* 2) */static struct elem* newMod( void );
/*----------------------------------------------------------------------------*/



/*----------------------DESCRIZIONE OPERATORI NASCOSTI--------------------------
1) cancellazione dell'elemento del modulo della tabella dati;
2) creazione di un modulo tabella;
------------------------------------------------------------------------------*/



/*-----------------SPECIFICA SINTATTICA OPERATORI NASCOSTI----------------------
1) deleteList(struct elem *) -> void;
2) newMod( void ) -> struct elem*;
------------------------------------------------------------------------------*/



/*------------------SPECIFICA SEMANTICA OPERATORI NASCOSTI----------------------
1) deleteList( el={} ) ->
                                  pre_condition:
                                  post_condition: el=NULL

2) newMod( ) -> mod={}
                                  pre_condition:
                                  post_condition: mod != NULL

------------------------------------------------------------------------------*/



/*-------------------------------OPERATORI------------------------------------*/
static struct elem* newMod( void ){

  hashmodule new= malloc(sizeof(struct elem));
  if( !new )
      return NULL;

  new->item= NULL;
  new->next= NULL;

  return new;
}



static void deleteList( struct elem *p ) {
    if (p  ==  NULL)
        return;
    deleteList( p->next );
    free( p );
}




int hash( char *k, int size ){

  int
      len= strlen( k ),
      v= (k[0]  +  k[len-1]  +  len);
  return (v  %  size);
}

/*
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
      tab= 0,
      a= 128;

  for( ; *v  !=  '\0'; v++ )
      tab= ((a*tab) + (*v)) % m;

  return tab;
}



int hash( char *k, int m ){

 int
    len= strlen( k ),
    val= k[0] + k[len-1] + len;

 return (val % m);
}
*/



void destroyHash( hashtable tab ){

    for( int i= 0; i  <  tab->size; i++ ){
        deleteList( tab->table[i] );
    }
    free( tab->table );
}



int deleteHash( hashtable tab, char *key ){

  int idx= hash(key, tab->size);
  hashmodule
            prev,
            curr,
            head;

  prev= curr= head= tab->table[idx];

  while( curr ){
        if( !strcmp(getKey(curr->item), key) ){
             if(curr  ==  head) // cancello in testa
                tab->table[idx]= curr->next;
             else
                prev->next= curr->next;
             return (1);
        }
        prev= curr;
        curr= curr->next;
  }
return (0);
}



object searchHash( hashtable tab, char* key ){

  int idx= hash(key, tab->size);
  hashmodule curr;

  curr= tab->table[idx];

  while( curr ){    // controllo se esiste un item
                    // con la stessa chiave key
     if( !strcmp(getKey(curr->item), key) )
        return curr->item;
     curr= curr->next;
   }
   // elemento non trovato
  return NULLITEM;
}



/*
item HashSearch( hashtable tab, char *key ){

  int
      idx,
      start
      i= 0;

  start= idx= hash( key, i, tab->size );

  do{
      if(tab->hash[idx]  ==  NULL){ posto libero
      return NULL;
      }

      hashmodule temp= tab->hash[idx];
      else if( !strcmp(temp->key, key) )
          return tab->hash[idx];

      else {
          i++;
          idx= hash( key, i, tab->size );
      }
  }while(idx  !=  start);

  return NULL;
}



int hashInsert( hashtable tab, char *key, int a, int b ){

  int
      idx,
      start,
      i = 0,
      len= tab->size;

  start= id = hash( key, i, tab->size );

  do{
      if(tab->hash[idx]  ==  NULL){ posto libero
          tab->hash[idx]= newItem(key,a,b);
          return (1);
      }
      else { prova successivo
          i++;
          idx= hash( key, i, tab->size );
      }
  }while(idx  !=  start);
return (0);
}
*/



int insertHash( hashtable tab, object data ){

  int idx= hash(getKey(data), tab->size);
  hashmodule
            head,
            curr;

   curr= head= tab->table[idx];

   while( curr ){    // controllo se esiste già un item
                    // con la stessa chiave di data
      if( !strcmp(getKey(curr->item), getKey(data)) )
         return (0);
      curr= curr->next;
   }
   // inserisce in testa alla lista
   hashmodule temp= newMod();
   temp->item= data;
   temp->next= head;
   tab->table[idx]= temp;

   return (1);
}



hashtable newHashtable( int size ){

  hashtable tab= malloc(sizeof(struct hash));
  if( !tab )
      return NULL;

  tab->size= size;
  tab->table= malloc(size*sizeof(struct elem*));

  for(int i= 0; i  <  size; i++ ){
      tab->table[i]= NULL;
  }

return tab;
}
