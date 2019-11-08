#include <stdio.h>
#include <stdlib.h>

#include "modulo_object_struct.h"
#include "modulo_hash_1.h"
#include "modulo_catalogo.h"

struct catalogo{
  hashtable tab;
  char* nome;
};



int deleteTrip( cat songs, char* nome ){

  if( !deleteHash(songs->tab, nome) )
      return (0);

  return (1);
}



object searchTrip( cat songs, char* nome ){

  return (searchHash(songs->tab, nome));
}



int insertTrip( cat songs, object data ){

  if( !insertHash(songs->tab, data) )
      return (0);

  return (1);
}



cat newCat( int size, char* nome ){

  cat new= malloc(sizeof(struct catalogo));
  new->nome= malloc(15*sizeof(char));
  new->tab= newHashtable( size );
  if(!new  ||  !new->nome  ||  !new->tab)
      return NULL;

  new->nome= nome;

  return new;
}
