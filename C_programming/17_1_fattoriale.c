//Calcolo del fattoriale di un numero utilizzando un ciclo di ripetizione

#include <stdio.h>

int main(void)
	{
	int n,k;				//dichiarazione delle variabili
	long int fact;

	fact=1;				//inizializzazione delle variabili

	printf("Di quale numero vuoi ottenere il fattoriale?\t");
	scanf("%d", &n); printf("\n\n");	//inizializzazione delle variabili input

		for(k=n;k>1;k--)			//ciclo operazionale
				fact*=k;


	printf("Il fattoriale calcolato corrisponde a:\t%ld", fact);
	printf("\n\n\n");

return(0);
	}
