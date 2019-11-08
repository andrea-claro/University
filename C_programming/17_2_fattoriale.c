//Calcolo del fattoriale di un numero utilizzando un ciclo di ripetizione

#include <stdio.h>
#include <ctype.h>
int main(void)
	{
	int n,k,z,r;				//dichiarazione delle variabili
	unsigned long int fact;


	printf("Vuoi calcolare un fattoriale?\t {['1'] se vuoi calcolare un fattoriale}\t");
	scanf("%d", &r); printf("\n");


		while (r==1)		//controllo sulla ripetizione del programma
			{
			fact=1;
			printf("\n\n");
			printf("Di quale numero vuoi ottenere il fattoriale?\t");
			scanf("%d", &n); printf("\n\n"); //inizializzazione delle variabili input

			if(n>=1)			//controllo sulla variabile input
				{
				for(k=n;k!=0;k--)			//ciclo operazionale
					fact*=k;

				printf("Il fattoriale calcolato corrisponde a:\t%lu", fact);
				printf("\n\n");
				}

			else if(n==0)
			printf("Il fattoriale vale:\t1");

			/*else(!(isdigit(n))||(n<0))
				printf("Il fattoriale del numero e' inesistente"); printf("\n\n");*/


			printf("\n\n\n");
			printf("Vuoi calcolare un altro fattoriale?\t {['1'] se vuoi calcolare un fattoriale}\t");
			scanf("%d", &z); printf("\n");

			r=z;
			}


		printf("Visto che non si desidera creare altri fattoriali, chiudere il programma"); printf("\n\n");
return(0);
	}

//Il programma va in crash se nell'esecuzione il numero da fattorizzare e' un carattere
