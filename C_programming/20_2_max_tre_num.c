//Scrivere un programma che calcoli il massimo tra tre numeri

#include <stdio.h>

float Get_Input(void);															//dichiarazione prototipi
float Max(void);

float a,b,c,max=0;																	//dichiarazione variabili globali

float Get_Input(void)																//funzione per l'inglesso variabili
	{
		printf("Immetti il primo valore di cui fare la verifica:\t");
		scanf("%f", &a);

		printf("\n");

		printf("Immetti il secondo valore di cui fare la verifica:\t");
		scanf("%f", &b);

		printf("\n");

		printf("Immetti il terzo valore di cui fare la verifica:\t");
		scanf("%f", &c); printf("\n\n");
	}

float Max(void)																							//funzione per il cacolo del massimo
	{
		if (max<=a)
			max=a;
		if(max<=b)
			max=b;
		if(max<=c)
			max=c;
	}

int main (void)
	{

		Get_Input();
		Max();

	printf("Il massimo tra i numeri dati e': \t%f", max);	printf("\n\n\n");								//stampa massimo

	return(0);
	}

//Programma funzionante
