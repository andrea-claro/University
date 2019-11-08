#include <stdio.h>
#include <stdlib.h>
#include "item.h"


/* poiché il tipo item è un puntatore a void le funzioni cmpInt, inputInt e outputInt devono
prendere in input o restituire in output dei puntatori a int.

Tramite le operazioni di assegnamento viene effettuato automaticamente il cast da puntatore 
a void a puntatore a int e viceversa */


int cmpInt(item it1, item it2){
	
	int *pt1 = it1;
	int *pt2 = it2;
	
	return *pt1 - *pt2;
}

item inputInt(void){
	int *pt ;
	pt = malloc(sizeof(int));
	
	scanf("%d",pt);
	return pt;
}

void outputInt(item it){
	int *pt = it;
	
	printf("%d ",*pt);
}





/* getIntFunc assegna ai tre puntatori a funzione cmpItem, inputItem e outputItem (campi della 
struct di tipo gen_func) gli indirizzi delle funzioni definite sopra (il nome della 
funzione corrisponde con il suo indirizzo) */


gen_func getIntFunc(void) {
	gen_func intFunc = {cmpInt, inputInt, outputInt};
	return intFunc;
}	
