#include <stdio.h>
#include <stdlib.h>

#include "modulo_object_struct.h"
#include "modulo_libreria_canzoni.h"

int main(){

  int n;
  char* cocco= malloc(15*sizeof(char));

  printf("\nnome libreria:\t");
  scanf("%s", cocco);
  printf("n# moduli tabella:\t");
  scanf("%d", &n);

  lib new= newLib(n, cocco);
  if( !new )
      printf("\n\nnon creato\n\n");

  printf("\n");
  if( !insertSong(new, insertObject()) )
      printf("\n\nnon inserito\n\n");

  char* cacca= malloc(15*sizeof(char));
  printf("\nnome search:\t");
  scanf("%s", cacca);
  if( !searchSong(new, cacca) )
      printf("\n\nnon trovato\n\n");

  if( !deleteSong(new, cacca) )
      printf("\n\nnon cancellato\n\n");

  printf("\n\ndone\n\n");
}
