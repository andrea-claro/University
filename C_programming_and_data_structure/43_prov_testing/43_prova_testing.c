/**************************************************************************************
*Creazione di un programma per la prova testing dei programmi tramite file di testo
**************************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#include "../moduli_programmi/modulo_array.h"
#include "../moduli_programmi/modulo_utilities.h"

/*-------------------------------PROTOTIPI--------------------------------------------------------------*/
int *recupera_dati(FILE *, int *, int *);
void confronto(int *, int *, int );
/*--------------------------------MAIN------------------------------------------------------------------*/
void main(){

	int *vettore, 		//array di elementi da confrontare
	    *vet,		//array di elementi dell'oracolo
	    dimensione_vettore=0,
	    dimensione_vet=0;

	FILE *documento,
	     *oracolo;

	documento=fopen("../file_di_testing/43_test_array", "r");
	if( !documento ){
		printf("\nIl file non e' stato aperto correttamente");
		exit;
	}

	oracolo=fopen("../file_di_testing/43_test_array_oracolo", "r");
	if( !oracolo ){
		printf("\nIl file non e' stato aperto correttamente");
		exit;
	}

	vettore=recupera_dati(documento, vettore, &dimensione_vettore);
	stampa_array_interi(vettore, dimensione_vettore);
	selection_sort_array_interi(vettore, dimensione_vettore);
	
	printf("\n\nDentro l'oracolo:");
	vet=recupera_dati(oracolo, vet, &dimensione_vet);
	stampa_array_interi(vet, dimensione_vet);

	if( dimensione_vettore==dimensione_vet )
		confronto(vet, vettore, dimensione_vet);
	else
		printf("\n\nFAIL\n");

	free(vettore);
	free(vet);
	fclose(documento);
	fclose(oracolo);
	printf("\n");
}
/*-------------------------------------CONFRONTO CON ORACOLO--------------------------------------------*/
void confronto(int *array1, int *array2, int dim){

	int flag=0;

	for( int k=0;k<dim;k++, flag++){
		if( array1[k]!=array2[k] )
			printf("\n\nFAIL\n");
	}
	
	if(flag==dim)
		printf("\n\nPASSED\n");
		
}
/*---------------------------------------RECUPERO DEI DATI----------------------------------------------*/
int *recupera_dati(FILE *test, int *array, int *dim){

	int k=0,
	    dep;		//variabile di appoggio per lo scorrimento e la ricerca della dimensione del file

	while( fscanf(test, "%d", &dep)!=EOF )
		k++;

	(*dim)=k;

	array=alloca_array_interi(  array, (*dim)  );
	
	rewind(test);
	k=0;
	while( fscanf(test, "%d", (array+k))!=EOF )
		k++;

return array;
}
