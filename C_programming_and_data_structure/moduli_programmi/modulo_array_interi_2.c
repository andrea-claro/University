/********************************************************************************
* Il seguente file di testo risulta essere un ADT array adibito all'uso di un
* vettore di elementi.
*********************************************************************************/



/*--------------------------LIBRERIE UTILIZZATE-------------------------------*/
#include<stdio.h>
#include<stdlib.h>



/*--------------------------MODULI UTILIZZATI---------------------------------*/
#include "modulo_object.h"
#include "modulo_array_2.h"



/*-------------------------------OPERATORI------------------------------------*/
int searchElementRicor( int *vet, int n, object data ){

  int flag= 0;

  if( compareObject(vet[n], data) )
      flag= 1;

  else if( !n )
      return flag;

  else
      return ( flag= searchElementRicor(vet, (n-1), data) );
}

int minArrayRicor( int *vet, int n, int min ){

  if( vet[n]<min )
      min= vet[n];

  else if( !n )
      return  min;

  return ( min= minArrayRicor(vet, (n-1), min) );
}

int minArrayBin( int *vet, int size, object data ){

  if( !vet )
      return 0;

	int H= size, //elemento superiore dell'array
	    L= 0,	//elmento inferiore dell'array
	    mid= (size/2); //elemento per il dimezzamento della dimensione dell'array

	if( data<vet[L] || el>vet[H] )
		  return 0;

	while( H>(L+1) ){
		  if( compareObject(vet[mid], data) )
			     return 1;

	    if(  vet[mid] > el  ){
          H= mid;
          mid= H-(H-L)/2;
		  }
      else{
          L= mid;
      		mid= L+(H-L)/2;
		  }
	}
  return 0;
}

int *deleteArrayPos( int *vet, int *size, int pos ){

  if( !vet || pos>(*size) || pos<0 )
      return NULL;

	for( int k= 0; k<(*size); k++ ){
		  if( k==(pos-1) )
			     for( int j= k; j<((*size)-1); j++ )
				        vet[j]= vet[j+1];
	}

	(*size)--;

	vet= reallocArray( vet, (*size) );

return vet;
}

int *reallocArray( int *vet, int size ){

	vet= realloc( vet, (size*sizeof(vet)) );
  if( !vet )
      return NULL;

return vet;
}

int *addElement( int *vet, int *size, object data, int pos ){

  if( !data || pos<0 || pos>(*size) )
      return NULL;

	(*size)++;	//incremento della dimensione per l'aggiunta dell'elemento

	vet= reallocArray( vet, (*size) );
  if( !vet )
      return NULL;

	for( int k= 0; k<((*size)-1); k++ ){
		  if( k==(pos-1) ){
			     for( int j=(*size); j>(pos-1); j-- ){
				          vet[j]= vet[j-1];
		       }
           vet[k]= data;
      }
	}

return vet;
}

void printArray( int *vet, int size ){

  if( !vet )
      printf("\n\nIl vettore e' vuoto\n");

	printf("\n\nI valori risultano:\n");
	for( int k= 0; k<size; k++ ){
	     printObject(vet[k]);
       printf("   ");
  }
}

int *selectionSort( int *vet, int size ){

	int min, //per la ricerca del valore minimo nell'array
	    pos= 0; //per la memorizzazione della posizione i-esima del valore minimo trovato

  if( !vet || !size )
      return NULL;

	for( int k= 0; k<size; k++ ){
		  min= vet[k];
      for( int j= (k+1); j<size; j++ ){
			       if( min>vet[j] ){
				            min= vet[j];
				            pos= j;
			       }
		  }
		if( !compareObject(min, vet[k]) )
	     elementExchange( &vet[k], &vet[pos] );
	}

return vet;
}

void elementExchange( int *a, int *b ){

	int temp;

	temp= (*a);
	(*a)= (*b);
	(*b)= temp;
}

int *insertArray( int *vet, int n ){

  if( !n )
      return vet;

	vet= allocArray( vet, n );
  if( !vet )
      return NULL;

	printf(  "\n\nInserire valori:\n"  );
	for( int k= 0; k<(*size); k++ )
	   vet[k]= insertObject();

return vet;
}

int *allocArray( int *vet, int size ){

	vet= calloc( size, sizeof(int) );
  if( !vet )
      return NULL;

return vet;
}

int sumArray( int *vet, int size ){

  int sum= 0;

  if( !vet )
      return sum;

	for( int k= 0; k<size; k++ )
		  sum+= vet[k];

return sum;
}

int *sumPosArray( int *a, int *b, int size_a, int size_b ){

  if( !a || !size_a )
      return b;
  if( !b || !size_b )
      return a;

	int *vet,		//vettore di appoggio per la creazione del vettore somma tra posizioni i-esime di due vettori
	    max= max2N( int size_a, int size_b );

	vet= allocArray( vet, max );
  if( !vet )
      return NULL;

	if( size_a==size_b )
		  for( int k= 0; k<size_a; k++ )
		      vet[k]= b[k]+a[k];

	else if( size_a<size_b ){
      int k;
	    for( k= 0; k<size_a; k++ )
		      vet[k]= b[k]+a[k] ;
      for( int j= k; j<size_b; j++ )
          vet[j]= b[j];
  }

	else{
      int k;
		  for( k= 0; k<size_b; k++ )
			     vet[k]= b[k]+a[k];
      for( int j= k; j<size_a; j++ )
           vet[j]= b[j];
  }

return vet;
}

int *productPosArray( int *a, int *b, int size_a, int size_b ){

  if( !a || !size_a )
      return b;
  if( !b || !size_b )
      return a;

	int *vet,		//vettore di appoggio per la creazione del vettore somma tra posizioni i-esime di due vettori
	    max= max2N( int size_a, int size_b );

	vet= allocArray( vet, max );
  if( !vet )
      return NULL;

	if( size_a==size_b )
		  for( int k= 0; k<size_a; k++ )
		      vet[k]= b[k]*a[k];

	else if( size_a<size_b ){
      int k;
	    for( k= 0; k<size_a; k++ )
		      vet[k]= b[k]*a[k] ;
      for( int j= k; j<size_b; j++ )
          vet[j]= b[j];
  }

	else{
      int k;
		  for( k= 0; k<size_b; k++ )
			     vet[k]= b[k]*a[k];
      for( int j= k; j<size_a; j++ )
           vet[j]= b[j];
  }

return vet;
}

int sumProductPosArray( int *a, int *b, int size_a, int size_b ){

	int sum= 0,
      *vet= productPosArray( a, b, size_a, size_b );
  if( !vet )
      return sum;

	for( int k= 0; k<max; k++ )
      sum+= vet[k];

return sum;
}

int max2N( int a, int b ){

  int max= a;

  if( max<b )
      return b;
  else
      return a;
}

void mergeSortRicor( int *vet, int p, int r) {

   int q;

   if( p<r){
     q= (p+r)/2;
     mergeSortRicor( vet, p, q );
     mergeSortRicor( vet, (q+1), r );
     merge( vet, p, q, r );
   }
return;
}

void merge( int *vet, int p, int q, int r){

   int temp[MAX], i, j, k;

   for( i= p, j= (q+1), k= p; i<=q && j<=r; ){
      if ( vet[i]<vet[j] )
          temp[k++]= vet[i++];
      else temp[k++]= vet[j++];
    }

   for ( ; i<=q; )
      temp[k++] = vet[i++];
   for ( ; j<=r; )
      temp[k++] = vet[j++];
   for ( k= p; k<=r; k++ )
      vet[k]= temp[k];
   return;
}

int partition ( int vet[], int p, int r ){

  int x,
      i= p-1,
      j= r+1,
      temp;

  x= (vet[p]);              // pivot

  while ( i<j ){
      while( vet[--j]>x );  // esce se vet[j]<=x
      while( vet[++i]<x );  // esce se vet[i]>=x

      if( i<j )            // scambia vet[i] <-> vet[j]
          elementExchange( &vet[i], &vet[j] );
  }
return j;
}

void quickSortRicor( int vet[], int p, int r ){

  int q;

  if( p<r ){
    q= partition(vet, p, r);
    quicksort(vet, p, q);
    quicksort(vet, (q+1), r);
  }
}
