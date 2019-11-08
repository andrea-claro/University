//Scrivere un programma che ordini gli array procedendo con scambi a due a due da sinistra verso destra

#include <stdio.h>

int Get_array(void);
int Control(void);                                  //dichiarazione prototipi
int Swap();
int Print(void);

#define LIMIT 10                              //macro per limite di grandezza del vettore
int x[LIMIT],flag;

int Get_array(void)
  {
    int k;

    for(k=0;k<LIMIT;k++)                                    //funzione per il caricamento del vettore
      {
        printf("Inserisci i valori da ordinare:\t");
        scanf("%d", &x[k]);
      }
  }

int Control(void)                                               //funzione per il controllo degli swap
  {
    while(flag)
      {
        flag=0;
        Swap(flag, x[LIMIT]);
      }
  }

int Swap(int flag, int x[])                                                 //funzione per lo swap delle posizioni
  {
    int n,k,j;

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
                  n=x[k];
                  x[k]=x[k+1];
                  x[k+1]=n;
                }
          }
      }
  }

int Print(void)                                   //funzione pper la stampa del vettore
  {
    int k;

    printf("Il vettore riordinato diviene:\t");
    for(k=0;k<LIMIT;k++)
      printf("%d   ", x[k]);
  }

int main(void)
  {
    int k;

    Get_array();
    printf("\n");
    flag=1;                                           //variabile utilizzata per controllare che il vettore sia in ordine
    Control();
    Print();
    printf("\n\n");

return (0);
  }
