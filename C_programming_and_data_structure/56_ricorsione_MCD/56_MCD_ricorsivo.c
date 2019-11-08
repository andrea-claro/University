#include<stdio.h>

int massiComDIv( int, int );

int main(){

  int mcd,
      a,
      b;


  printf("\nInserisci i due numeri:\n");
  scanf("%d%d", &a, &b);

  if( a > 0 && b > 0 )
    mcd = massiComDIv( a, b );
  else
    mcd = 0;

  printf("\n\nMCD:\t%d", mcd);
  printf("\n\nFINE\n\n");

  return 0;
}

int massiComDIv( int a, int b ){

  else if( a == b )
    return a;

  else if( a < b)
    return ( massiComDIv( b-a, a) );

  else
    return (massiComDIv( a-b, b ) );
}
