//Scrivere un programma che ordini gli array procedendo con scambi a due a due da sinistra verso destra

#include <stdio.h>

#define LIMIT 10                              //macro per limite di grandezza del vettore

int main(void)
  {
    int n,x[LIMIT],flag,k,j;

    for(k=0;k<LIMIT;k++)
      {
      printf("Inserisci i valori da ordinare:\t");                        //caricamento del vettore
      scanf("%d", &x[k]);
      }

    printf("\n");

    flag=1;                                           //variabile utilizzata per controllare che il vettore sia in ordine

    while(flag)
      {
        flag=0;

        for(k=0;k<LIMIT;k++)
          {
            if(k==LIMIT)
              break;

            else
              {
                for(j=k+1;j<LIMIT;j++)
                  {
                    if(j==LIMIT)
                      break;

                    else if(x[j-1]>x[j])
                      flag=1;
                  }

                  if(x[k]>x[k+1])
                    {
                      n=x[k];                       //swap delle posizioni
                      x[k]=x[k+1];
                      x[k+1]=n;
                    }
              }
          }
      }

    printf("Il vettore riordinato diviene:\t");                     //stampa del vettore
    for(k=0;k<LIMIT;k++)
      printf("%d   ", x[k]);

    printf("\n\n");
return (0);
  }

//Programma funzionante
