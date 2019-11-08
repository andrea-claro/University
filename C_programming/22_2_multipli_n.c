/*Scrivere un programma che dati in input 'n' ed 'm', stampi tutti i multipli di
'm' compresi tra '0' ed n. */

#include<stdio.h>

int Get_Input(void);                                          //dichiarazione prototipi
int Do_Actions(void);

int n, m;                                                       //dichiarazione variabili globali

int Get_Input(void)                                           //funzione per l'immissione dei dati in input
  {
    printf("Inserisci il numero di cui vuoi conoscere i multipli:\t");
    scanf("%d", &m); printf("\n");

    printf("Di quanti numeri vuoi calcolare i multipli di %d:\t", m);
    scanf("%d", &n); printf("\n\n");
  }

int Do_Actions(void)                                          //funzione per il cacolo e la stampa dei multipli
  {
    int k;                                                  //dichiarazione variabili attuali
    unsigned long int x=0;

    if((n>=0)&&(m>=0))
      {
        k=1;
        while(k!=n+1)
          {
            x=m*k;
            printf("Il numero %lu e' uno dei multipli del numero scelto %d", x, m);
            printf("\n");
            k++;
          }
      }

    else
    printf("Non hai inserito alcun numero di multipli da conoscere"); printf("\n\n");
  }

int main (void)
  {

    Get_Input();
    Do_Actions();

return(0);
  }

//Programma funzionante
