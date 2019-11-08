#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "item.h"

/* Le funzioni cmpChar, inputChar e outputChar prendono in input o restituiscono in output 
dei puntatori a char. Tramite le operazioni di assegnamento viene effettuato automaticamente 
il cast da puntatore a void a puntatore a char e viceversa */


int cmpChar(item it1, item it2) {
	char *p_c1 = it1,
		 *p_c2 = it2;
		 
	return strcmp(p_c1, p_c2);
}



item inputChar(void) {
	char *p_c;
	p_c = malloc(sizeof(char) * 20);
	
	scanf("%s", p_c);
	
	return p_c;
}


void outputChar(item it) {
	char *p_c = it;
	
	printf("%s ", p_c);
}



/* getCharFunc assegna ai tre puntatori a funzione cmpItem, inputItem e outputItem (campi della 
struct di tipo gen_func) gli indirizzi delle funzioni definite sopra (il nome della funzione 
corrisponde con il suo indirizzo) */



gen_func getCharFunc(void) {
	gen_func charFunc = {cmpChar, inputChar, outputChar};
	return charFunc;
}	
