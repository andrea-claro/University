#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include"modulo_object.h"
#include"modulo_lista_3.h"

int main( void ){
  head primo;
  int n =0;

  primo = createHead();
  if( addingNode( 0, primo, 5 ) )
    n=1;

  printf("\ne' uscito %d nodo\n", n);
  printList( primo );

  printf("\nelementi lista:\t");
  scanf("%d", &n);
  primo = insertList( n );
  printList( primo );

  system( "clear" );

  head clone = cloneList( primo );
  printf("\n\nla lista clone:\n");
  printList( clone );

  printf("\nin questo momento la lista ha una grandezza di %d\n", sizeList( primo ) );

  object search = 5;

  printf("\n l'elemento %d e' in posizione %d\n", search, (posList( search, primo ) + 1) );

  int pos;
  printf("\ninserisci posizione cancellazione:\t");
  scanf("%d", &pos);

  if( deletePos( pos, primo ) )
    printList( primo );

  deleteList( clone );
  printf("\nelemento clone ora con %d elementi", sizeList( clone ) );
  printList( clone );
  return 0;
}
