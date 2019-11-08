//Dato un input in intero, denotare se n e' primo o non

#include <stdio.h>
#include <math.h>

int Get_Input(void);                                            //dichiarazione prototipi
int Operations(void);

int n,c,x[32];                                                    //dichiarazione variabili globali

int Get_Input(void)                                               //funzione per l'immissione input
  {
    printf("Inserisci il numero di cui vuoi verificare se sia primo"); printf("\n");
    scanf("%d", &n);
  }

int Operations(void)                                              //funzione per le operazioni e la stampa
  {
    int k;

    x[0]=sqrt(n);

    for(k=0;k<x[0];k++)
      {
      if(k==0)
        continue;

      x[k]=x[k-1]-1;
      }

    c=0;

    for(k=0;k<x[0];k++)
      {
      if((double)(n%x[k])==0)
        c++;
      }

    if(c>2)
      {
      printf("Il numero non e' primo"); printf("\n");
      }

    else
      printf("Il numero e' primo"); printf("\n");

  }

int main (void)
  {

  Get_Input();
  Operations();

return(0);
  }

// durante la compilazione aggiungere la libreria
//Programma non funzionante
