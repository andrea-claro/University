//Somma dei primi numeri n pari

#include <stdio.h>



int Get_Input(void);																					//dichiarazione prototipi
int Do_Operation(int);
void PRINT(int);



int Get_Input(void)																									//funzione per la dichiarazione variabile input
	{
		int x;
		printf("Immetti la quantita' di numeri pari da sommare:\t");
		scanf("%d", &x);
return x;
	}



int Do_Operation(int add)																							//funzione per l'operazione di scelta numeri primi piu' addizione
	{
		int k,somma;

		somma=0;
		k=0;				//inizializzazione variabili

		if((add!=0) && (add>=0))		//ciclo di controllo
			{
				do
					{
						somma+=(k*2);  //ciclo operazionale
						k++;
			  	}while(k<add);
return somma;
			}

		else
return 0;
	}



void PRINT(int x)
	{
		int sum;

		sum=Do_Operation(x);
		if(sum)
			printf("La somma dei primi %d numeri pari risulta:\t %d", x, sum);

		else
			printf("Non risulta alcun numero da calcolare");
	}



int main(void)
	{
		int n, flag, flaggo;

		printf("\nVuoi eseguire il programma?\t{[0] per uscire}\t");
		scanf("%d", &flag);
		while(flag!=0)
		{
			n=Get_Input();
			PRINT(n);
			printf("\n\nVuoi eseguire il programma?\t{[0] per uscire}\t");
			scanf("%d", &flaggo);
			flag=flaggo;
		}

return(0);
	}

//Programma funzionante
