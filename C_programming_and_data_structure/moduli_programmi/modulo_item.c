/*********************************************************************************************************************
** This file is part of the list ADT file construction, it serves to produce simple data items
*********************************************************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "modulo_item.h"

/*-----------------------------------------------INSERTING ELEMENTS---------------------------------------------------------*/
void input_item(item *data){

  scanf("%d",data);
}
/*-----------------------------------------------PRINTING ELEMENTS---------------------------------------------------------*/
void print_item(item data){

  printf("%d",data);
}
/*-----------------------------------------------COMPARING ELEMENTS---------------------------------------------------------*/
int compare_item(item a,item b){

  return a==b;
}
