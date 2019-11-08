//Calcolo della differenza del massimo e del minimo fra tre numeri immessi dall'utente

#include<stdio.h>

int main(void)
	{
	float a,b,c,min,max,dif; //dichiarazione variabili

	min=0;
	max=0;
	dif=0;			 //inizializzazione variabili

	printf("Immetti i tre valori da cui procedere per il calcolo:\n1)");
	scanf("%f", &a); printf("2)"); scanf("%f", &b); printf("3)"); scanf("%f", &c);

	printf("\n\n");
	min=a;
	max=a;			 //inizializzazione ottimata per una verifica rapida


	if(max<=b)
		max=b;
	if(max<=c)
		max=c;

	if(min>=b)
		min=b;
	if(min>=c)
		min=c;		  //condizioni di verifica


	dif=max-min;		  //operazione del calcolo di stampa
	printf("La differenza tra massimo e minimo dei numeri immessi e':\t%f", dif);
	printf("\n\n\n");

return(0);
	}

//Programma funzionante
