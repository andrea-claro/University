/************************************************************************************
*Modulo con funzioni di utilita' generale:
**- scambio elementi con variabile temporanea.
*************************************************************************************/

#include<stdio.h>
#include<stdlib.h>

/*--------------------------------PROTOTIPI---------------------------------------------------------------*/
void scambio_tra_elementi(  int *, int *  );

/*-----------------------------------------SCAMBIO DI ELEMENTI TRA LORO---------------------------------*/
void scambio_tra_elementi(  int *a, int *b  ){

	int temp;
	
	temp = (*a);
	(*a) = (*b);
	(*b) = temp;
}
