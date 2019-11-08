/*Scrivere un programma che dati in input 'n' ed 'm', stampi tutti i multipli di
'm' compresi tra '0' ed n. */

#include<stdio.h>
int main (void)
  {
  int n, m, k;
  unsigned long int x=0;
    printf("\n\n");
    printf("Inserisci il numero di cui vuoi conoscere i multipli:\t");
    scanf("%d", &m); printf("\n");

    printf("Fino a che numero vuoi calcolare i multipli di %d:\t", m);
    scanf("%d", &n); printf("\n\n");

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
return(0);
  }
