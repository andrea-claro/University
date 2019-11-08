#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int palindroma( char * );
int paliRicorsione( char *, int, int );

int main(){

char *string;

string = malloc( 20 * sizeof( char ) );

printf("\n\nInserisci la parola:\t");
scanf("%s", string);

int flag = palindroma( string );

if( flag )
  printf("\n\nE' palindroma\n\n");
else
  printf("\n\nNon e' palindroma\n\n");

  return 0;
}

int palindroma( char *word ){

  int n = strlen( word );

  return paliRicorsione( word, 0, n );
}

int paliRicorsione( char *word, int k, int j ){

  if( j <= k )
    return 1;

  else if( word[k] != word[j] )
    return 0;

  else
    return paliRicorsione( word, k+1, j-1 );
}
