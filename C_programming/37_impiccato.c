/*******************************************************************************************
*Il programma dell'impiccato deve essere in grado di prendere una stringa dall'utente e utilizzarla *per lo sviluppo del gioco.
*******************************************************************************************/

/*---------------------LIBRERIE------------------------------------------------------------*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
/*---------------------PROTOTIPI-----------------------------------------------------------*/
void controllo_input(int, char *[]);
void prima_stampa(char *);
int indovina(char *parola);
int controllo_lettera(char *, char);
char *stampa_lettere(char *, char *, char);
void stampa(int, char *);
/*---------------------MAIN-----------------------------------------------------------------*/
int main(int argc, char *argv[]){

int tentativi=0;

controllo_input(argc, argv);
prima_stampa(argv[1]);
tentativi=indovina(argv[1]);

if(tentativi)
	stampa(tentativi, argv[1]);
return 0;
}
/*----------------------STAMPA VITTORIA----------------------------------------------------*/
void stampa(int numero, char *parola){
printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
printf("hai vinto con %d tentativi, la parola era proprio:\t%s\n", numero, parola);
}
/*---------------------CONTROLLO DI ENTRATA-------------------------------------------------*/
void controllo_input(int numero_arg, char *argomento[]){

if(numero_arg!=2){
	printf("\nnumero argomenti non valido, programma terminato\n");
	exit(1);
	}

if((argomento+1)==NULL){
	printf("\nnon e' stata allocata alcuna parola, programma terminato\n");
	exit(1);
	}
}
/*---------------------STAMPA INIZIALE------------------------------------------------------*/
void prima_stampa(char *parola){

int dim_parola=strlen(parola);

printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
printf("la parola risulta di %d caratteri\t\t", dim_parola);

for(int k=0;k<dim_parola;k++)
	printf("*");
printf("\n");
}
/*---------------------INDOVINA----------------------------------------------------------*/
int indovina(char *parola){

int dim_parola=strlen(parola), 
	tentativi=dim_parola+3,
	conta_lettere=0; 
char scelta,
	*fake;

fake=calloc(dim_parola, sizeof(char));
for(int k=0;k<dim_parola;k++)
	*(fake+k)='*';

printf("il numero di tentativi per indovinare la parola \nequivale al numero delle lettere della parola +3\n");

printf("\nil gioco inizia\n");

for(int k=0;k<tentativi;k++){
	printf("\n\nscegli una lettera:\t");
	scanf("%s", &scelta);

	conta_lettere+=controllo_lettera(parola, scelta);
	printf("hai indovinato %d lettere su %d della parola\t", conta_lettere, dim_parola);
	fake=stampa_lettere(fake, parola, scelta);
	
	if(!strcmp(parola, fake))
		return (k+1);
	}

printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
printf("hai perso, la parola era:\t%s\n", parola);
exit(1);
}
/*-----------------------STAMPA FAKE----------------------------------------------------*/
char *stampa_lettere(char *parola_falsa, char *parola, char lettera){

for(int k=0;k<strlen(parola);k++){
	if(parola[k]==lettera)
		if(parola_falsa[k]=='*')
			parola_falsa[k]=lettera;
	}

printf("%s\n", parola_falsa);

return parola_falsa;
}
/*------------------------CONTROLLO LETTERA----------------------------------------------*/
int controllo_lettera(char *parola, char lettera){

int dim_parola=strlen(parola),
	conta=0;

for(int k=0;k<dim_parola;k++)
	if(parola[k]==lettera) 
		conta++;

return conta;
}
