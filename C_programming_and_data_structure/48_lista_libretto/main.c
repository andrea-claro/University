/******************************************************************************************************
** Creating a file that in this case is going to work with a list ADT composed of structures
*******************************************************************************************************/

/*------------------------------LIBRERIE--------------------------------*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#include "item.h"
#include "list.h"
#include "libretto.h"

int main( int argc, char *argv[]){

  if( argc != 3 )
    exit(1);

  book libro;

  libro = newLibre();
  libro = insertLibre( argv, libro );
  printf("\nIl libretto risulta ora:\n");
  printLibre( libro );

  free(libro);
  return 0;
}
