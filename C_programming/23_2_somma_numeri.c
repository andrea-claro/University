/* Scrivere un programma che abbia in input un valore da calcolare e stampare */

#include <stdio.h>

float Get_Input(void);													//dichiarazione prototipi
float Sum(void);

float x,y;  																			//dichiarazione delle variabili globali

float Get_Input(void)																			//funzione per l'immissione di input
	{
		printf("Dichiara il valore che vuoi assuma la prima variabile da cui partire per la somma" 			":\t");
		scanf("%f",&x);

		printf("\nDichiara il valore che vuoi assuma la seconda variabile da cui continuare per la somma:\t");
		scanf("%f", &y);
	}

float Sum(void)																						//funzione per il calcolo e la stampa
	{
		float sum;

		sum=x+y;

		printf("\n\nLa somma ottenuta dai due valori numerici assegnati risulta:" "\t%f",sum);
		printf("\n\n\n");
	}

int main (void)
	{

		Get_Input();
		Sum();

	return(0);
	}
