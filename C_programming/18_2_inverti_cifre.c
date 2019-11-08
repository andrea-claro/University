// L'utente inserisce un intero, letto come intero; invertire le cifre della variabile

#include <stdio.h>

int Get_Variable(void);     //dichiarazione prototipi
int Do_Inversion(void);

int n,z[32],iSum;                  //dichiarazioni globali

int Get_Variable(void)      //Funzione per l'immissione del numero da invertire
  {
    printf("Inserisci il numero di cui vuoi invertire le cifre;\t");
    scanf("%d", &n); printf("\n");
  }

int Do_Inversion(void)       //Funzione per le operazioni di inversione
  {
    int k,j,iDif;             //dichiarazione variabili attuali

    iDif=n;

    while(iDif==0)
      {
        z[0]=iDif;

        for(k=0;k==n;k++)
          {
            if(z[k]/10==0)
            break;
            z[k]/=10;
          }

          for(j=0;j==k;j++)
            iSum+=z[k]*10;

          iDif=n-iSum;
        }
  }

int main(void)
  {
    Get_Variable();

    iSum=0;                           //Inizializzazione della somma tra cifre

    Do_Inversion();

  printf("Il numero convertito e':\t%d", iSum); printf("\n\n");

return(0);
  }

//Programma non funzionante
