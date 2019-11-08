#include<stdio.h>

int sumPrimiN(int n);

int main(){

  int num = 1,
      sum = 0;

  printf("\nInserisci la somma di quanti numeri vuoi:\t");
  scanf("%d", &num);

  sum = sumPrimiN( num );

  printf("\nIl risultato e':\t%d\n\n", sum);

  return 0;
}

int sumPrimiN(int n){

  if( n == 1)
    return 1;
  else
    return (sumPrimiN(n-1)+n);
}
