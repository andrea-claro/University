// L'utente inserisce un intero, letto come intero; invertire le cifre della variabile

#include <stdio.h>

int main()
  {
  int n,z[32],iSum,iDif,k,j;

  printf("Inserisci il numero di cui vuoi invertire le cifre;\t");
  scanf("%d", &n); printf("\n");

  iSum=0;
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
  printf("Il numero convertito e':\t%d", iSum); printf("\n\n");
return(0);
  }

//Programma non funzionante
