#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include "modulo_canzone.h"
#include "modulo_lista_3.h"
#include "modulo_playlist.h"

int main(int argc, char *argv[]){

  if( argc != 3 )
    exit(1);

  printf("\ncrea una playlist :\n");
  int n = atoi( argv[1] );

  play temp = insertPlaylist( n, argv[2] );
  
  printPlaylist( temp );

  int pos;
  printf("\naggiungi in posizione:\t");
  scanf("%d", &pos);
  if( !addingSong( temp, pos ) )
    printf("\n\nnon aggiunto\n\n");
  else
    printf("\n\naggiunto\n\n");

  printPlaylist( temp );

  if( !deleteSong( temp, pos ) )
    printf("\n\nnon eliminato\n\n");
  else
    printf("\n\neliminato\n\n");

  printPlaylist( temp );

  if( !searchSong( temp, insertObject() ) )
    printf("\n\nnon trovato\n\n");
  else
    printf("\n\ntrovato\n\n");

  if( !deletePlaylist( temp ) )
    printf("\n\nnon eliminata\n\n");
  else
    printf("\n\neliminata\n\n");

  printPlaylist( temp );

free(temp);
  return 0;
}
