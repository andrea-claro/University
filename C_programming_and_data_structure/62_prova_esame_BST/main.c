#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#include "modulo_object_struct.h"
#include "modulo_catalogo.h"

int main(){

  char* el= "chicchi";
  class new= createClass( el );

  int n;
  do{
      printf("\n\nn# elementi:\t");
      scanf("%d", &n);
  }while(n < 0  &&  n > 10);


  if( !insertClass(new, n) )
          printf("\n\nnon inserito");

  char* cacca= "cocco";
  if( !searchClass( cacca, new) )
      printf("\n\nelemento non trovato");
  else
      printf("\n\ntrovato");

  if( !updateClass(new, "cacca", "cocco", 4, 5) )
      printf("\n\naggiornamento non riuscito");
  else
      printf("\n\naggiornamento riuscito");

  printf("\n\n");
  printClass( new );
}
