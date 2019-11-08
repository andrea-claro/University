#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include "modulo_object.h"
#include "modulo_set.h"

int main(){

  int n;

  printf("\n\nquanti elementi:\t");
  scanf("%d", &n);
  printf("\n\n");

  head new = newSet( n );
  printSet( new );

  return 0;
}
