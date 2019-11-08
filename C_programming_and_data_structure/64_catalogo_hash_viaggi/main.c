#include <stdio.h>
#include <stdlib.h>

#include "modulo_object_struct.h"
#include "modulo_catalogo.h"

int main(){

  int n;
  char* cocco= malloc(15*sizeof(char));

  printf("\nnome catalogo:\t");
  scanf("%s", cocco);
  printf("n# moduli tabella:\t");
  scanf("%d", &n);

  cat new= newCat(n, cocco);
  if( !new )
      printf("\n\nnon creato\n\n");

  printf("\n");

  for( int k= 0; k < 3; k++ ){
      if( !insertTrip(new, insertObject()) )
          printf("\n\nnon inserito\n\n");
      printf("\n");
  }

  char* cacca= malloc(15*sizeof(char));
  printf("\ncodice delete:\t");
  scanf("%s", cacca);

  if( !deleteTrip(new, cacca) )
      printf("\n\nnon cancellato\n\n");

  char* culo= malloc(15*sizeof(char));
  printf("\ncodice search:\t");
  scanf("%s", culo);

  printObject( searchTrip(new, culo) );

  char* cane= malloc(15*sizeof(char));
  printf("\ncodice update:\t");
  scanf("%s", cane);

  updatePrice( searchTrip(new, cane), 5 );
  updateSeats( searchTrip(new, cane), 5 );
  printObject( searchTrip(new, cane) );

  printf("\n\ndone\n\n");
}
