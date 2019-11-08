#include<stdio.h>
#include<string.h>
#include<stdlib.h>


typedef struct cittadino{
	char cognome[20];
	char nome[20];
	char luogo [20];
	int anno;
}cittadino;


void new_aggiorna(cittadino *);
cittadino aggiorna_second(cittadino);
cittadino *aggiorna(char *[]);
void stampa(cittadino *);
void copia_in_vect(cittadino *, cittadino, cittadino, cittadino *);
void stampa_vect(cittadino *);


int main(){

char *info[]={"Nappi","Michele"};
cittadino *third, second, first, *records;
int num_rec;

	printf("\nQuanti sono i record da creare:\t"); scanf("%d", &num_rec);

	records=malloc(num_rec*sizeof(cittadino));

	new_aggiorna(&first);
	second=aggiorna_second(first);
	third=aggiorna(info);
	stampa(&first);
	stampa(&second);
	stampa(third);

	copia_in_vect(records, first, second, third);
	stampa_vect(records);
return 0;
}


void stampa_vect(cittadino *franco){
		printf("\n\nI dati in archivio risultano:");
		
		for(int k=0;k<3;k++){
		printf("\n[%d]------------------------------------------------[%d]", (k+1), (k+1));
		printf("\nnome:\t%s", (franco+k)->nome);
		printf("\ncognome:\t%s", (franco+k)->cognome);
		printf("\nluogo nascita:\t%s", (franco+k)->luogo);
		printf("\nanno nascita:\t%d", (franco+k)->anno); printf("\n");
	}
}


void stampa(cittadino *pippo){
	printf("\n\nUn cittadino:");
	printf("\nHa nome risultante:\t%s", pippo->nome);
	printf("\nHa cognome risultante\t%s", pippo->cognome);
	printf("\nRisulta nato a:\t%s", pippo->luogo);
	printf("\nNell'anno:\t%d", pippo->anno); printf("\n");
}


void copia_in_vect(cittadino *array, cittadino uno, cittadino due, cittadino *tre){
	array[0]=uno;
	array[1]=due;
	array[2]=*tre;
}


cittadino *aggiorna(char *dati[]){
char ch;
cittadino *assimila;
	printf("\nVuoi inserire altri dati?[y/n]\t"); ch=getchar();
		if(ch=='n') return NULL;
	
		else{
		assimila=malloc(1*sizeof(cittadino));
		strcpy(assimila->nome, dati[0]);
		strcpy(assimila->cognome, dati[1]);
	
		printf("\nInserisci il luogo di nascita:\t"); scanf("%s", assimila->luogo);
		printf("Inserisci l'anno di nascita:\t"); scanf("%d", &assimila->anno);

		return assimila;
		}
}


cittadino aggiorna_second(cittadino pippo){
return pippo;
}


void new_aggiorna(cittadino *pippo){
	printf("\nInserisci il cognome:\t"); scanf("%s", pippo->cognome);
	printf("Inserisci il nome:\t"); scanf("%s", pippo->nome);
	printf("Inserisci il luogo di nascita:\t"); scanf("%s", pippo->luogo);
	printf("Inserisci l'anno di nascita:\t"); scanf("%d", &pippo->anno);
}


