//Esempio della scanf di una char

#include <stdio.h>

int main (void)
	{
	char x[64];			/*inizializzazione variabile carattere con array di 						inclusione posto a 64 */

	printf("\n\nInserisci il tuo nome:\t");	//inizializzazione della variabile input
	scanf("%s", x); printf("\n\n"); //dichiarazione della variabile input
	

	printf("Oh, cia' %s", x); printf("\n\n\n");
return(0);
	}
