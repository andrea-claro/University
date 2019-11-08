//Somma dei primi numeri n pari

#include <stdio.h>

int main(void)
	{
	int n,somma,k;			//dichiarazione variabili
	
	somma=0;
	k=0;				//inizializzazione variabili

	printf("Immetti la quantita' di numeri pari da sommare:\t");
	scanf("%d", &n); printf("\n\n"); //inizializzazione variabile input
	
	
	if((n!=0) && (n>=0))		//ciclo di controllo
		{
		do
			{
			somma+=(somma+2);  //ciclo operazionale	
			k++;	
			}
		while(k!=n);

		
		printf("La somma dei primi %d numeri pari e' %d", n, somma);
		printf("\n\n\n");
		}
	
	else
	printf("Non c'e' alcun valore da sommare");


return(0);
	}
