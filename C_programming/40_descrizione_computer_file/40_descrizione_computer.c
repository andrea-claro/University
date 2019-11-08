/*************************************************************************************************
*Programma che dato in ingresso il nome del file nel quale riporre le caratteristiche del computer,
*crea il suddetto documento.
***************************************************************************************************/

/*----------------------------LIBRERIE------------------------------------------------------------*/
#include<stdio.h>
#include<stdlib.h>
/*----------------------------MACRO DI COLORAZIONE-----------------------------------------------*/
#define RED "\e[3;31m" 
#define END_COLOR "\e[00m" 
/*----------------------------STRUTTURA----------------------------------------------------------*/
typedef struct computer{
	char *modello,
		*casa_madre;
	int anno_produzione,
		prezzo;
	}computer;
/*----------------------------PROTOTIPI----------------------------------------------------------*/
void controllo_nome(int);
FILE *controllo_esistenza_file(FILE *, char *, int*);

computer *alloca_struttura(computer *, int);

void inserimento_dati_struttura(computer *, int);
void stampa_dati(computer *, int);
void copia_dati_file(computer *, int, FILE *, int);

void chiusura_memorie(computer *, FILE *, int);
/*----------------------------MAIN----------------------------------------------------------------*/
int main(int argc, char *argv[]){

computer *macchina;
int numero_pc,
	flag;
FILE *testo;

controllo_nome(argc);
testo=controllo_esistenza_file(testo, argv[1], &flag);

printf("quanti elaboratori devi registrare?\t");
scanf("%d", &numero_pc);

macchina=alloca_struttura(macchina, numero_pc);

inserimento_dati_struttura(macchina, numero_pc);
copia_dati_file(macchina, numero_pc, testo, flag);

chiusura_memorie(macchina, testo, numero_pc);
return 0;
}
/*----------------------------CONTROLLO INSERIMENTO NOME FILE------------------------------------*/
void controllo_nome(int numero){

if(numero!=2){
	printf(RED"\n\nnumero di argomenti inseriti errato; programma terminato\n\n"END_COLOR);
	exit(EXIT_FAILURE);
	}
}
/*----------------------------CONTROLLO DELL'APERTURA DEL FILE---------------------------------*/
FILE *controllo_esistenza_file(FILE *dati, char *nome, int *verifica){

if(fopen(nome, "r")==NULL){

	printf("\n\nil file non esiste ancora");
	dati=fopen(nome, "w");

	if(dati==NULL){
		printf("\n\nil file non riesce a crearsi; programma terminato");
		exit(EXIT_FAILURE);
		}	
	else{
		printf("\nil file e' stato appena creato\n\n");
		*verifica=0;
		return dati;		
		}
	}

else{
	dati=fopen(nome, "r+");
	*verifica=1;
	return dati;
	}

}
/*----------------------------ALLOCAZIONE MEMORIA STRUTTURA-------------------------------------*/
computer *alloca_struttura(computer *struttura, int n){

struttura=calloc(n, sizeof(computer));

for(int k=0;k<n;k++){

	struttura[k].modello=calloc(32, sizeof(char));
	struttura[k].casa_madre=calloc(32, sizeof(char));
	}

return struttura;
}
/*--------------------------INSERIMENTO DEI DATI NELLA STRUTTURA-------------------------------*/
void inserimento_dati_struttura(computer *struttura, int n){

for(int k=0;k<n;k++){
	printf("\ninserire modello del pc:\t");
	scanf("%s", struttura[k].modello);
	printf("inserire casa produttrice del pc:\t");
	scanf("%s", struttura[k].casa_madre);
	printf("inserire anno produzione del pc:\t");
	scanf("%d", &struttura[k].anno_produzione);
	printf("inserire prezzo del pc:\t");
	scanf("%d", &struttura[k].prezzo);
	}
system("clear");
stampa_dati(struttura, n);
}
/*------------------------INSERIMENTO DEI DATI NEL FILE--------------------------------------*/
void copia_dati_file(computer *struttura, int n, FILE * dati, int verifica){

if(!verifica){
	
	fprintf(dati,"Dati riguardanti l'archivio computer:\n\n");
	fprintf(dati, "\nMODELLO_PC:\tCASA_PRODUTTRICE:\tANNO_PRODUZIONE:\tPREZZO:\n");

	for(int k=0;k<n;k++){
		fprintf(dati,"\n%s\t%s\t%d\t%d\n", struttura[k].modello, struttura[k].casa_madre,
					struttura[k].anno_produzione, struttura[k].prezzo);
		}
	}

else if(verifica){

	fseek(dati, 0, SEEK_END);

	for(int k=0;k<n;k++){
		fprintf(dati,"\n%s\t%s\t%d\t%d\n", struttura[k].modello, struttura[k].casa_madre,
					struttura[k].anno_produzione, struttura[k].prezzo);
		}
	}
}
/*------------------------STAMPA DEI DATI INSERITI-------------------------------------------*/
void stampa_dati(computer *struttura, int n){

for(int k=0;k<n;k++){
	printf("\nmodello:\t%s\n", struttura[k].modello);
	printf("casa produttrice:\t%s\n", struttura[k].casa_madre);
	printf("anno_produzione:\t%d\n", struttura[k].anno_produzione);
	printf("prezzo:\t%d\n", struttura[k].prezzo);
	}
}
/*-----------------------TERMINAZIONE DELLA MEMORIA ALLOCATA---------------------------------*/
void chiusura_memorie(computer *struttura, FILE *dati, int n){

fclose(dati);

for(int k=0;k<n;k++){
	free(struttura[k].modello);
	free(struttura[k].casa_madre);
	}
free(struttura);
}

