#include <stdio.h>
#include <stdlib.h>

#include "modulo_object_struct.h"
#include "modulo_hash_1.h"
#include "modulo_libreria_canzoni.h"

struct libreria_canzoni{
  hashtable tab;
  char* nome;
};


int deleteSong( lib songs, char* nome ){

  if( !deleteHash(songs->tab, nome) )
      return (0);

  return (1);
}


int searchSong( lib songs, char* nome ){

  if( !searchHash(songs->tab, nome) )
      return (0);

  return (1);
}


int insertSong( lib songs, object data ){

  if( !insertHash(songs->tab, data) )
      return (0);

  return (1);
}


lib newLib( int size, char* nome ){

  lib new= malloc(sizeof(struct libreria_canzoni));
  new->nome= malloc(15*sizeof(char));
  new->tab= newHashtable( size );
  if(!new  ||  !new->nome  ||  !new->tab)
      return NULL;

  new->nome= nome;

  return new;
}
