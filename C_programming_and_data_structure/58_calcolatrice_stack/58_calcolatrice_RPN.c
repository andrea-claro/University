#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include "58_modulo_stack.h"

int main( void ){

  FILE *doc = fopen( "dati", "r" );
  if( !doc ){
    printf("\n\n il file non esiste\n\n");
    exit(0);
  }

  object word = malloc( 20* sizeof( char ) );
  int k = 0;

  while( fscanf( doc, "%s", word ) != EOF )
    k++;

  if( k == 1 || !k || !(k%2) ){
    printf("\n\nil file non risulta idoneo\n\n");
    exit(0);
    }
  rewind( doc );

  head count_num = createHead();
  int j = 0;
  fscanf( doc, "%s", word );
  while( strcmp(word, "+") && strcmp(word, "-") && strcmp(word, "*") && strcmp(word, "/") ){
    int data = atoi( word );
    int flag = pushStack( count_num, data );
    if( !flag ){
      printf("\n\n");
      exit(0);
    }
    j++;
    fscanf( doc, "%s", word );
  }

  if( ((k - j)+1) != j ){
    printf("\n\nil file non risulta idoneo\n\n");
    exit(0);
    }

  int ris = 0;
  while( !feof(doc) ){
    int flag = 0;

    if( !strcmp( word, "/") ){
      ris = pop( count_num ) / pop( count_num );
      flag = pushStack( count_num, ris );
      if( !flag ){
        printf("\n\n");
        exit(0);
      }
    }

    else if( !strcmp( word, "+") ){
      ris = pop( count_num ) + pop( count_num );
      flag = pushStack( count_num, ris );
      if( !flag ){
        printf("\n\n");
        exit(0);
      }
    }

    else if( !strcmp( word, "-") ){
      ris = pop( count_num ) - pop( count_num );
      flag = pushStack( count_num, ris );
      if( !flag ){
        printf("\n\n");
        exit(0);
      }
    }

    else if( !strcmp( word, "*") ){
      ris = pop( count_num ) * pop( count_num );
      flag = pushStack( count_num, ris );
      if( !flag ){
        printf("\n\n");
        exit(0);
      }
    }

    else
      fscanf(doc, "%s", word);

    fscanf(doc, "%s", word);
    }

  printf("\n\nil risultato e':\t%d\n\n", ris);

  return 0;
}
