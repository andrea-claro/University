/***************************************************************************************
*Scrivere un programma che controlli il bilanciamento delle parentesi '()'
***************************************************************************************/

/*--------------------LIBRERIE----------------------------------------------------------*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*----------------------PROTOTIPI-------------------------------------------------------*/
int controllo_file(FILE *);
void scrittura_file(FILE *);
int controllo_parentesi(FILE *);
void conta_parentesi(int *, int *, FILE *);
int ricerca_chiuse(FILE */*, int **/);
int ricerca_aperte(FILE */*, int **/);
/*---------------------MAIN-------------------------------------------------------------*/
int main(int argc, char *argv[]){

int flag, scritto=0; //variabile per il controllo del testo presente nel file
FILE *file_testo;

file_testo=fopen(argv[1], "w+");
scritto=controllo_file(file_testo);

if(!scritto)
	scrittura_file(file_testo);

flag=controllo_parentesi(file_testo);

if(!flag)
	printf("\nle parentesi all'interno del testo sono ben bilanciate\n");

else if(flag==(1)){
	printf("\nci sono parentesi aperte in piu' di quelle chiuse");
	
	//scritto=0;
	flag=ricerca_aperte(file_testo/*, &scritto*/);
	
	printf("\nil carattere di apertura '(' numero %d del file necessita chiusura\n"       			/*"al posto numero %d\n"*/, flag/*, scritto*/);
	}

else if(flag==(-1)){
	printf("\nci sono parentesi chiuse in piu' di quelle aperte");

	scritto=0;
	flag=ricerca_chiuse(file_testo/*, &scritto*/);

	printf("\n\nil carattere di chiusura ')' numero %d del file necessita apertura\n" 			/*"al posto numero %d\n"*/, flag/*, scritto*/);
	}

fclose(file_testo);
}
/*-------------------------CONTROLLO FILE-----------------------------------------------*/
int controllo_file(FILE *file){

char x;

if(file!=NULL){
	printf("\nIl file e' stato aperto correttamente");

	if(!(fscanf(file, "%c", &x)!=EOF))
		return x;
	
	else 
		return 0;
	}

else{
	printf("\nIl file non si apre\n");
	exit(1);
	}
}
/*-------------------------CASO DI SCRITTURA--------------------------------------------*/
void scrittura_file(FILE *file){

char testo;

printf("\n\n\ninserisci il testo:\n");


while(testo!='\n'){
	scanf("%c", &testo);
	fprintf(file, "%c", testo);
	}
}
/*------------------------CONTROLLO PARENTESI--------------------------------------------*/
int controllo_parentesi(FILE *file){

int num_parentesi_aperte=0, num_parentesi_chiuse=0;

conta_parentesi(&num_parentesi_aperte, &num_parentesi_chiuse, file);
printf("\n%d parentesi aperte \n%d parentesi chiuse\n", num_parentesi_aperte, num_parentesi_chiuse);

if(num_parentesi_aperte>num_parentesi_chiuse)
	return 1;

else if(num_parentesi_aperte<num_parentesi_chiuse)
	return -1;

else if(num_parentesi_aperte==num_parentesi_chiuse)
	return 0;
}
/*-------------------------CONTA PARENTESI-----------------------------------------------*/
void conta_parentesi(int *x, int *y, FILE *file){

char lettera;

rewind(file);
while(fscanf(file, "%c", &lettera)!=EOF){

	if(lettera=='(')
		(*x)++;

	else if(lettera==')')
		(*y)++;
	}
}
/*---------------------------RICERCA ERRORE APERTE--------------------------------------*/
int ricerca_aperte(FILE *file/*, int *conta_pos*/){

int par_a=0, par_c=0, diff/*, conta_err=0*/;
//char lettera;

conta_parentesi(&par_a, &par_c, file);

diff=par_a-par_c;
/*rewind(file);
while(fscanf(file, "%c", &lettera)!=EOF){
	(*conta_pos)++;
	if(lettera=='('){
		conta_err++;
		if(conta_err==par_c){
			return diff;
			}
		}
	}*/
return diff;
}
/*----------------------------RICERCA ERRORE CHIUSE------------------------------------*/
int ricerca_chiuse(FILE *file/*, int *conta_pos*/){

int par_a=0, par_c=0, diff/*, conta_err=0*/;
//char lettera;

conta_parentesi(&par_a, &par_c, file);

diff=par_c-par_a;
/*rewind(file);
while(fscanf(file, "%c", &lettera)!=EOF){
	(*conta_pos)++;
	if(lettera==')'){
		conta_err++;
		if(conta_err==par_a)
			return diff;
		}
	}*/
return diff;
}
