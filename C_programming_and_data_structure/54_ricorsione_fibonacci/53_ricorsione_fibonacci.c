#include<stdio.h>

unsigned fibonacci( unsigned int );

int main(){

  unsigned int a,
               ris;

  printf("\nInserisci il primo numero:\t");
  scanf("%d", &a);

  ris = fibonacci( a );

  printf("\nIl risultato e':\t%d\n\n", ris);

  return 0;
}

unsigned fibonacci( unsigned int n ) {

   if( n < 2 )
    return n;
   else
    return ( fibonacci( n - 1 ) + fibonacci( n - 2 ) );
}
