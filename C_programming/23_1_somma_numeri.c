/* Scrivere un programma che abbia in input un valore da calcolare e stampare */


#include <stdio.h> 

int main (void)  
	{  
	float x,y,sum=0;  //dichiarazione delle variabili, x|y di input, sum di output


	printf("Dichiara il valore che vuoi assuma la prima variabile da cui partire per la somma" 			":\t");
	scanf("%f",&x);
	
	printf("\nDichiara il valore che vuoi assuma la seconda variabile da cui continuare per la somma:\t");
	scanf("%f", &y);


	sum=x+y;


	printf("\n\nLa somma ottenuta dai due valori numerici assegnati risulta:" "\t%f",sum);
	printf("\n\n\n");


	return(0);
	}
	
