#include<stdio.h>
#include <stdlib.h>

void printString( char );

int main(){

  char c;

    printf("\n\nInserisci carattere per carattere la parola:\n");
    scanf("%c", &c);

    printString(c);
    printf("\n\nFINE\n\n");

  return 0;
  }

  void printString( char car ){

    char l;

    if( car != '.' ){
      scanf("%c", &l);
      printString(l);
      printf("%c", car);
    }

    else
      return;
  }
