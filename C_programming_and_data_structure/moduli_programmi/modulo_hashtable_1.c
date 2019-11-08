#include<stdio.h>
#include<stdlib.h>



#include "modulo_object.h"
#include "modulo_hashtable.h"



struct hash{
   int size;
   struct elem **table;
};

struct elem{
   char *key; /* chiave */
   object item;
   struct elem *next;
};



static void deleteList( struct elem * );



/*
object HashSearch( struct hash *h, char *key ){

  int idx,
      start,
      i= 0;

  start= idx= hash1( key, h ->size );

  do{
      if(h ->hash[idx] == NULL)  //posto libero
          return (NULL);
      else if( !strcmp(h->hash[idx] ->key, key) )
          return(h ->hash[idx] ->item);
      else {
          i++;
          idx= hash_oa( key, i, h ->size );
      }
  }while(idx != start);

  return (NULL);
}



int HashInsert( struct hash *h, char *key, int intero1, int intero2 ){

  int idx,
      start,
      i= 0,
      len= h ->size;

  start= idx= hash1( key, i, h ->size);

  do{
      if(h ->hash[idx] == NULL){  //posto libero
          h ->hash[idx]= newItem( key, intero1, intero2);
          return(1);
      }
      else{ // prova successivo
          i++;
          idx= hash_oa( key, i, h ->size);
      }
  }while (idx != start);

  return (0);
}
*/


int hash1( char *k, int size ){

  int len= strlen( k )
  v= ( k[0] + k[len-1] + len );

  return(v % size);
}



int hash2( char *k, int size ){

  int sum= 0;

  while((*k) != '\0'){
      sum+= (*k);
      k++;
  }

  return(sum % size);
}



void DestroyHash( hashtable h ){

  for( int i=0; i < h ->size; i++ )
      deleteList(h->hash[i]);

  free(h->hash);
  return;
}



static void deleteList( struct elem *p ){

    if(p == NULL)
        return;
    deleteList( p ->next );
    free(p);
}



int DeleteHash( hashtable h, char *key ){

  int idx;
  struct elem *prev,
              *curr,
              *head;

  idx= hash( key, h ->size );
  prev= curr= head= h ->hash[idx];

  while( curr ){
      if( !strcmp(curr->key, key) ){
          if(curr == head) // cancello in testa
              h ->hash[idx]= curr ->next;
          else
              prev ->next= curr ->next;

          return(1);
        }

        prev= curr;
        curr= curr ->next;
  }
  return(0);
}



struct elem* SearchHash( hashtable h, char* key ){

  int idx;
  struct elem *curr;

  idx= hash( key, h ->size );
  curr= h ->table[idx];

  while( curr ){    // controllo se esiste un item
                    // con la stessa chiave key
      if( !strcmp(curr->key, key) )
          return(curr);
      curr= curr ->next;
   }
   // elemento non trovato
   return(NULLITEM);
}



hashtable newHashtable( int size ){

  hashtable h= malloc(sizeof(struct hash));
  h ->size= size;
  h ->table= (struct elem **)malloc(size*struct elem*));

  for( int i=0; i < size; i++ )
     h ->table[i]= NULL;

  return h;
}



int InsertHash( hashtable h, struct elem *e ){

  int idx;
  struct elem *head,
              *curr;

  idx= hash1( e ->key, h ->size );
  curr= head= h ->table[idx];

  while( curr ){    // controllo se esiste già un item
                    // con la stessa chiave di e
      if( !strcmp(curr->key, e->key) )
          return(-1);
      curr= curr ->next;
   }
   // inserisce in testa alla lista
   h ->table[idx]= e;
   h ->table[idx]->next= head;
   return(0);
}
