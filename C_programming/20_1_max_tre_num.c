//Scrivere un programma che calcoli il massimo tra tre numeri

#include <stdio.h>

int main (void)
	{
	float a,b,c,max=0;

	printf("Immetti il primo valore di cui fare la verifica:\t");
	scanf("%f", &a);

	printf("\n");

	printf("Immetti il secondo valore di cui fare la verifica:\t");
	scanf("%f", &b);	

	printf("\n");

	printf("Immetti il terzo valore di cui fare la verifica:\t");
	scanf("%f", &c);


	if (max<=a)
		max=a;
	if(max<=b)
		max=b;
	if(max<=c)
		max=c;

	printf("\n\n");

	printf("Il massimo tra i numeri dati e': \t%f", max);


	printf("\n\n\n");

	return(0);
	}
