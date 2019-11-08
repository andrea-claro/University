/************************************************************************************
*Creare una struttura per le frazioni ed adoperarla per ogni operazione tra esse
************************************************************************************/

/*--------------------------LIBRERIE----------------------------------------------*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
/*--------------------------STRUTTURA---------------------------------------------*/
typedef struct frazione{
	int numeratore,
	    denominatore;
	}frazione;
/*-------------------------PROTOTIPI---------------------------------------------*/
void massimo_minimo(int *, int *, int *);
int minimo_comune_multiplo(int *);
int prodotto_massimo_minimo(int *);
int massimo_comune_divisore(int, int);
int *ricerca_denominatori(int *, frazione *);

void scelta_operazione(void);

frazione *inserimento(frazione *);

frazione addizione(frazione *, int);
frazione sottrazione(frazione *, int);
frazione moltiplicazione(frazione *);
frazione divisione(frazione *);

void stampa(frazione);

void libera(int *marco, frazione *giacomo);
/*--------------------------MAIN--------------------------------------------------*/
int main(void){

scelta_operazione();

return 0;
}
/*----------------------SCEGLI OPERAZIONE--------------------------------------*/
void scelta_operazione(){

int *denominatori, 
     mcm,
     scelta=1;

frazione *dati, 
	 risultato;

while(scelta){
	printf("\n[-1] per terminare il programma");
	printf("\n\n[1] per inserire dati");
	printf("\n\n[2] per elaborare un'addizione");
	printf("\n[3] per elaborare una sottrazione");
	printf("\n[4] per elaborare una moltiplicazione");
	printf("\n[5] per elaborare una divisione");
	printf("\n\n[6] per stampare dati\n\nscelta:\t");
	scanf("%d", &scelta);
	
	switch(scelta){
		case 1:
		denominatori=calloc(2, sizeof(frazione));
		dati=calloc(2, sizeof(frazione));

		dati=inserimento(dati);
		denominatori=ricerca_denominatori(denominatori, dati);

		mcm=minimo_comune_multiplo(denominatori);
		break;

		case 2:
		risultato=addizione(dati, mcm);
		break;
	
		case 3:
		risultato=sottrazione(dati, mcm);
		break;

		case 4:
		risultato=moltiplicazione(dati);
		break;

		case 5:
		risultato=divisione(dati);
		break;

		case 6:
		stampa(risultato);
		break;
	
		case -1:
		printf("\n\nprogramma terminato\n");
		libera(denominatori, dati);
		exit(1);
		break;

		default:
		printf("\n\ndigitazione sbagliata");
		break;
		}
	}
}
/*-----------------------LIBERA MEMORIA----------------------------------------*/
void libera(int *marco, frazione *giacomo){
free(marco);
free(giacomo);
}
/*-----------------------STAMPA RISULTATI---------------------------------------*/
void stampa(frazione operazione){

printf("\n\n\n\n\n\n\n\nil risultato dell'operazione risulta:\t%d/%d\n\n\n", operazione.numeratore, 			operazione.denominatore);
}
/*-----------------------DIVISIONE---------------------------------------------*/
frazione divisione(frazione *operatori){

frazione temp;
int risultato;

risultato=( (operatori[0].numeratore) * (operatori[1].denominatore) );
temp.numeratore=risultato;

risultato=( (operatori[0].denominatore) * (operatori[1].numeratore) );
temp.denominatore=risultato;

return temp;
}
/*-----------------------MOLTIPLICAZIONE---------------------------------------*/
frazione moltiplicazione(frazione *operatori){

frazione temp;
int risultato;


risultato=( (operatori[0].numeratore) * (operatori[1].numeratore) );
temp.numeratore=risultato;

risultato=( (operatori[0].denominatore) * (operatori[1].denominatore) );
temp.denominatore=risultato;

return temp;
}
/*-----------------------SOTTRAZIONE--------------------------------------------*/
frazione sottrazione(frazione *operatore, int mcm){

frazione temp;
int risultato;

risultato=( ((mcm/operatore[0].denominatore)*(operatore[0].numeratore)) - 				((mcm/operatore[1].denominatore)*(operatore[1].numeratore)) );

temp.denominatore=mcm;
temp.numeratore=risultato;

return temp;
}
/*-----------------------ADDIZIONE----------------------------------------------*/
frazione addizione(frazione *operatore, int mcm){

frazione temp;
int risultato;

risultato=( ((mcm/operatore[0].denominatore)*(operatore[0].numeratore)) +	 			((mcm/operatore[1].denominatore)*(operatore[1].numeratore)) );

temp.denominatore=mcm;
temp.numeratore=risultato;

return temp;
}
/*-----------------------RICERCA DEL MASSIMO E DEL MINIMO------------------------*/
void massimo_minimo(int *denom, int *max, int *min){

*max=*min=denom[0];

for(int k=0;k<2;k++){

	if(*max<denom[k]) *max=denom[k];
	
	if(*min>denom[k]) *min=denom[k];
	}
}
/*------------------------MINIMO COMUNE MULTIPLO---------------------------------*/
int minimo_comune_multiplo(int *denom){

int mcd, prodotto, massimo, minimo;
	
massimo_minimo(denom, &massimo, &minimo);
prodotto=prodotto_massimo_minimo(denom);

mcd=massimo_comune_divisore(massimo, minimo);

return (mcd*prodotto);
}
/*------------------------PRODOTTO MASSIMO-MINIMO--------------------------------*/
int prodotto_massimo_minimo(int *denom){
return(denom[0]*denom[1]);
}
/*------------------------MASSIMO COMUNE DIVISORE--------------------------------*/
int massimo_comune_divisore(int mas, int min){

while(min!=mas)                         
      {                                     
        if(min>mas)                        
          min-=mas;                         
                                           
        else                                
          mas-=min;                         
      }                                     
                                            
return min;          
}
/*------------------------RICERCA DENOMINATORI----------------------------------------------*/
int *ricerca_denominatori(int *denom, frazione *operatore){

for(int k=0;k<2;k++){
	denom[k]=operatore[k].denominatore;
	}

return denom;
}

/*-------------------------INSERIMENTO--------------------------------------------*/
frazione *inserimento(frazione *operatore){

for(int k=0;k<2;k++){
	printf("inserire numeratore del %d operatore:\t", k+1);
	scanf("%d", &operatore[k].numeratore);

	printf("inserire denominatore del %d operatore:\t", k+1);
	scanf("%d", &operatore[k].denominatore);

	printf("\n");
	}

return operatore;
}

