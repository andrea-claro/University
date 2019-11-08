//Somma dei primi numeri n pari

#include <stdio.h>

int Get_Input(void);																					//dichiarazione prototipi
int Do_Operation(void);

int n;

int Get_Input(void)																									//funzione per la dichiarazione variabile input
	{
		printf("Immetti la quantita' di numeri pari da sommare:\t");
		scanf("%d", &n); printf("\n\n");
	}

int Do_Operation(void)																							//funzione per l'operazione di scelta numeri primi piu' addizione
	{
		int k,somma;

		somma=0;
		k=0;				//inizializzazione variabili

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
	}

int main(void)
	{

		Get_Input();
		Do_Operation();

return(0);
	}

//Programma non funzionante
