#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#include "modulo_canzone.h"
#include "modulo_lista_3.h"
#include "modulo_playlist.h"

struct playlist{
  char nome_lista[15];
  head canzone;
};

play createPlaylist( void ){

  play temp;

  temp = malloc( sizeof( struct playlist ) );
  if(  !temp )
    return NULL;

  //temp -> canzone = createHead();

  return temp;
}

play insertPlaylist( int n, char *name ){

  play temp = createPlaylist();

  temp ->canzone = insertList( n );

  strcpy( temp ->nome_lista, name);

  return temp;
}

int deletePlaylist( play info ){

  head temp = info ->canzone;

  if( !deleteList( temp ) )
    return 0;

  else
    return 1;
}

int addingSong( play info, int pos ){

  head temp = info ->canzone;

    if( !addingNode( pos, temp, insertObject() ) )
      return 0;

  else
    return 1;
}

int deleteSong( play info, int pos ){

  head temp = info ->canzone;

  if( !deletePos( pos, temp ) )
    return 0;

  else
    return 1;
}

int searchSong( play info, object song ){

  head temp = info ->canzone;

  if( !searchList( temp, song ) )
    return 0;

  else
    return 1;
}

void printPlaylist( play info ){
  printf("\nIl nome della playlist risulta:\t%s\ncanzoni:\n", info ->nome_lista);

  head temp = info ->canzone;
  printList( temp );
}
