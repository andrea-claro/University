//Calcolo della differenza del massimo e del minimo fra tre numeri immessi dall'utente

#include<stdio.h>

float Get_Variables(void);          //dichiarazione prototipi del programma
float Max(void);
float Min(void);
float OutDif(void);

float a,b,c,min,max,dif;                //dichiarazione variabili globali

float Get_Variables(void)         //funzione per l'inizializzazione delle variabili
  {
    printf("Immetti i tre valori da cui procedere per il calcolo:\n1)");
  	scanf("%f", &a); printf("2)"); scanf("%f", &b); printf("3)"); scanf("%f", &c);printf("\n\n");
  }

float Max(void)                       //funzione per il calcolo del massimo dei numeri
  {
    if(max<=b)
  		max=b;
  	if(max<=c)
  		max=c;
  }

float Min(void)                           //funzione per il calcolo del minimo
  {
    if(min>=b)
  		min=b;
  	if(min>=c)
  		min=c;
  }

float OutDif(void)                        //funzione per il calcolo e la stampa della differenza
  {
    dif=max-min;
  	printf("La differenza tra massimo e minimo dei numeri immessi e':\t%f", dif);
  	printf("\n\n\n");
  }

int main(void)
	{

	min=0;
	max=0;
	dif=0;			 //inizializzazione variabili

  Get_Variables();

	min=a;
	max=a;			 //inizializzazione ottimata per una verifica rapida

  Max();
  Min();
  OutDif();

return(0);
	}

//Programma funzionante
