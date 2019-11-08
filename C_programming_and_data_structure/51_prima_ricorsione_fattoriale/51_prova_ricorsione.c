#include<stdio.h>

int fact(int n);

int main(){

  int num,
      fatt = 0;

  printf("\nInserisci il numero che vuoi fattorizzare:\t");
  scanf("%d", &num);

  fatt = fact( num );

  printf("\nIl risultato e':\t%d\n\n", fatt);

  return 0;
}

int fact(int n){

  if(!n)
    return 1;
  else
    return n*fact(n-1);
}
