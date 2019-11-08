/************************************************************************************
*Modulo funzioni su array di interi:
**- ricerca binaria in un array ordinato di un elemento;
**- eliminazione di una data posizione di un elemento dell'array;
**- inserimento di un dato elemento in una data posizione dell'array;
**- stampa di un array di interi;
**- algoritmo di ordinamento tramite selection sort;
**- inserimento dati in un array di interi;
**- allocamento dinamico della memoria per un array di interi;
**- riallocamento dinamico della memoria per un array di interi;
**- somma degli elementi di un array;
**- sommatoria del prodotto delle posizioni i-esime tra due array;
**- somma tra posizioni i-esime di un array.
************************************************************************************/

#include<stdio.h>
#include<stdlib.h>


/*--------------------------------PROTOTIPI---------------------------------------------------------------*/
int *scelta_input(  int *, int *  );
int *selection_sort_array_interi(  int *, int  );
void stampa_array_interi(  int *, int  );
int *inserimento_in_array_interi(  int *, int *  );
int *eliminazione_in_array_interi(  int *, int *  );
void scambio_tra_elementi(  int *, int *  );
void minimo_array_binario_interi(  int *, int  );
int *alloca_array_interi(  int *, int  );
int *rialloca_array_interi(  int *, int  );
int somma_totale_array_interi(  int *, int  );
int *vet_somma_array_interi(  int *, int *, int, int  );
int sommatoria_vettori_interi(  int *, int *, int, int  );

/*------------------------RICERCA DI UN ELEMENTO RICORSIVO------------------------------------------------*/
int searchElement( int *vet, int n, int el ){

  int flag = 0;

  if( vet[n] == el )
    flag = 1;

  else if( !n )
    return flag;

  else
    return ( flag = searchElement( vet, (n - 1), el ) );
}

/*---------------------------RICERCA DEL MINIMO RICORSIVO-------------------------------------------------*/
int minArray( int *vet, int n, int min ){

  if( vet[n] < min)
    min = vet[n];

  else if( !n )
    return  min;

  return ( min = minArray( vet, (n -1), min ) );
}

/*--------------------------------ALGORITMO BINARIO PER LA RICERCA DEL NUMERO X---------------------------*/
void minimo_array_binario_interi(  int *vettore, int dim  ){

	int el, 			//elemento da ricercare nell'array
	    sup = dim,			//elemento superiore dell'array
	    inf = 0,			//elmento inferiore dell'array
	    mezz = (dim/2);		//elemento per il dimezzamento della dimensione dell'array

	printf(  "\n\nInserisci il numero che vorresti ricercare nell'array ordinato:\t"  );
	scanf(  "%d", &el  );

	if(  el < vettore[inf]  ||  el > vettore[sup]  )
		printf(  "\nL'elemento non e' presente nell'intervallo dell'array"  );

	while(  sup > (inf+1)  ){
		if(  vettore[mezz] == el  )
			printf(  "Elemento trovato in posizione %d", (mezz+1)  );
		if(  vettore[mezz] > el  ){
      			sup = mezz;
      			mezz = sup-(sup-inf)/2;
		}
      		else{
      			inf = mezz;
      			mezz = inf+(sup-inf)/2;
		}
	}
}

/*-------------------------------ELIMINAZIONE ELEMENTO IN ARRAY-----------------------------------------*/
int *eliminazione_in_array_interi(  int *vettore, int *dim  ){

	int pos;	//posizione i-esima dell'elemento da annullare

	do{
	printf(  "\n\nInserisci la posizione di un elemento da eliminare:\t"  );
	scanf(  "%d", &pos  );
	}while(  pos > ((*dim)-1)  );

	system(  "clear"  );
	stampa_array_interi(  vettore, (*dim)  );

	for(  int k=0; k<(*dim); k++  ){
		if(  (pos-1) == k  )
			for(  int j=k; j<((*dim)-1); j++  )
				vettore[j] = vettore[j+1];
	}

	(*dim)--;

	vettore = rialloca_array_interi(  vettore, (*dim)  );
	if(  !vettore  )	//controllo per la riallocazione di memoria
		exit;

return vettore;
}

/*-----------------------------------INSERIMENTO ELEMENTO IN ARRAY--------------------------------------*/
int *inserimento_in_array_interi(  int *vettore, int *dim  ){

	int el,		//elemento da aggiungere all'array
	    pos,	//posizione nella quale aggiungere l'elemento scelto
	    temp;	//per la sostituzione delle variabili nelle posizioni successive

	do{
	printf(  "\n\nInserisci un elemento e la posizione in cui vuoi aggiungerlo:\t"  );
	scanf(  "%d%d", &el, &pos  );
	}while(  pos > (*dim)  );

	system(  "clear"  );
	stampa_array_interi(  vettore, (*dim)  );

	(*dim)++;	//incremento della dimensione per l'aggiunta dell'elemento

	vettore = rialloca_array_interi(  vettore, (*dim)  );
	if(  !vettore  )	//controllo per la riallocazione di memoria
		exit;

	for(  int k=0; k<((*dim)-1); k++  ){
		if(  (pos-1) == k  )
			for(  int j=(*dim); j>(pos-1); j--  ){
				vettore[j] = vettore[j-1];
			vettore[k] = el;
		}
	}

return vettore;
}

/*--------------------------------------------STAMPA----------------------------------------------------*/
void stampa_array_interi(  int *vettore, int dim  ){

	printf(  "\nI valori risultano\n"  );
	for(  int k=0; k<dim; k++  )
	printf(  "%d   ", vettore[k]  );
}

/*---------------------------------------SELECTION SORT-------------------------------------------------*/
int *selection_sort_array_interi(  int *vettore, int dim  ){

	int min, 	//per la ricerca del valore minimo nell'array
	    temp,	//per la sostituzione tra il valore minimo e la posizione i-esima
	    pos;	//per la memorizzazione della posizione i-esima del valore minimo trovato

	for(  int k=0; k<(dim-1); k++  ){
		min = vettore[k];

		for(  int j=(k+1); j<dim; j++  ){
			if(  min > vettore[j]  ){
				min = vettore[j];
				pos = j;
			}
		}

		if(  min != vettore[k]  )
			scambio_tra_elementi(  &vettore[k], &vettore[pos]  );
	}

return vettore;
}

/*--------------------------------------------INSERIMENTO DATI NEL VETTORE------------------------------*/
int *scelta_input_array_interi(  int *vettore, int *dim  ){

	do{
	system(  "clear"  );
	printf(  "\nInserire il numero di elementi del vettore:\t"  );
	scanf(  "%d", dim  );
	}while(  (*dim) <= 0  );

	vettore = alloca_array_interi(  vettore, (*dim)  );

	printf(  "Inserire i valori all'interno del vettore\n"  );
	for(  int k=0; k<(*dim); k++  )
		scanf(  "%d", (vettore+k)  );

	stampa_array_interi(  vettore, (*dim)  );

return vettore;
}

/*-----------------------------------------ALLOCAMENTO DINAMICO DI UN VETTORE---------------------------*/
int *alloca_array_interi(  int *vettore, int dim  ){

	vettore = calloc(  dim, sizeof(int)  );

return vettore;
}

/*---------------------------------------RIALLOCAMENTO DINAMICO DI UN VETTORE---------------------------*/
int *rialloca_array_interi(  int *vettore, int dim  ){

	vettore = realloc(  vettore, (dim*sizeof(vettore))  );

return vettore;
}

/*----------------------------------------SOMMA ELEMENTI INTERNI DI UN ARRAY----------------------------*/
int somma_totale_array_interi(  int *vettore, int dim  ){

	int sum = 0;

	for(  int k=0; k<dim; k++  )
		sum += vettore[k];

return sum;
}

/*--------------------------------------SOMMA TRA POSIZIONI I-ESIME DI DUE ARRAY------------------------*/
int *vet_somma_array_interi( int *a, int *b, int dim_a, int dim_b ){

	int *vet,		//vettore di appoggio per la creazione del vettore somma tra posizioni i-esime di due vettori
	    max = dim_a;

	if(  max < dim_b  )
		max = dim_b;
	vet = alloca_array_interi(  vet, max  );
	if(  !vet  )
		exit;

	if(  dim_a == dim_b  )
		for(  int k=0; k<dim_a; k++  )
		*(vet+k) = (  *(b+k) + (*(a+k))  );
	if(  dim_a < dim_b  )
		for(  int k=0; k<dim_a; k++  )
			*(vet+k) = (  *(b+k) + (*(a+k))  );
	else
		for(  int k=0; k<dim_b; k++  )
			*(vet+k) = (  *(b+k) + (*(a+k))  );

return vet;
}

/*--------------------------------------SOMMATORIA DI PRODOTTI DI UN VETTORE----------------------------*/
int sommatoria_vettori_interi( int *a, int *b, int dim_a, int dim_b ){

	int sum = 0;

	if(  dim_a == dim_b  )
		for(  int k=0; k<dim_a; k++  )
			sum += (  a[k] * b[k]  );
	if(  dim_a < dim_b  ){

		for(  int k=0;k<dim_a;k++  )
			sum += (  a[k] * b[k]  );
		for(  int j=dim_a; j<dim_b;j++  )
			sum += b[j];
	}
	else if(  dim_a > dim_b  ){

		for(  int k=0; k<dim_b; k++  )
			sum += (  a[k] * b[k]  );
		for(  int j=dim_b; j<dim_a; j++  )
			sum += a[j];
	}

return sum;
}
/*-----------------------------------------SCAMBIO DI ELEMENTI TRA LORO---------------------------------*/
void scambio_tra_elementi(  int *a, int *b  ){

	int temp;

	temp = (*a);
	(*a) = (*b);
	(*b) = temp;
}
