//Esempio della scanf di una char

#include <stdio.h>

int Input(void);																			//dichiarazione prototipi
int Stampa(void);

char x[64];																				//dichiarazione variabile globale

int Input(void)																				//Funzione per l'inserimento della variabile
	{
		printf("Inserisci il tuo nome:\t");
		scanf("%s", x); printf("\n\n");
	}

int Stampa(void)																			//Funzione per la stampa
	{
		printf("Oh, cia' %s", x); printf("\n\n\n");
	}

int main (void)
	{

		Input();
		Stampa();

return(0);
	}

//Programma funzionante
