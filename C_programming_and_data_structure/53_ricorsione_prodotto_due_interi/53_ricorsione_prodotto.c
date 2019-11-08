#include<stdio.h>

int product( int, int );

int main(){

  int b,
      a,
      ris;

  printf("\nInserisci il primo numero:\t");
  scanf("%d", &a);
  printf("\nInserisci il secondo numero:\t");
  scanf("%d", &b);

  ris = product( a, b );

  printf("\nIl risultato e':\t%d\n\n", ris);

  return 0;
}

int product(int a, int b) {

   int ris;

   if (b == 1)
     ris = a;
   else
    ris = (a + product( a , (b - 1) ) );

    return ris;
   //return ris;
}
