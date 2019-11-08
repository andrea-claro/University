/************************************************************************************************
*Creazione di un programma che include librerie e funzioni di un altro file precedentemente creato
************************************************************************************************/

#include<stdio.h>
#include<stdlib.h>
#include "../moduli_programmi/modulo_array.h"

/*-------------------------------PROTOTIPI--------------------------------------*/

/*--------------------------------MAIN------------------------------------------*/
void main(){
	
	int *vettore,
	    dimensione=0;

	vettore=scelta_input_array_interi(vettore, &dimensione);
	stampa_array_interi(vettore, dimensione);

	free(vettore);
	printf("\n");
}

