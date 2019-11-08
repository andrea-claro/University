//Scrivere un programma che ordini gli array procedendo con scambi a due a due da sinistra verso destra

#include <stdio.h>



#define LIMIT 10                              //macro per limite di grandezza del vettore



void Get_array(int []);
void CONTROL(int []);                                  //dichiarazione prototipi
int SWAP(int, int []);
void PRINT(int [], int []);
void COPY(int [], int []);



void COPY(int array[], int ordinato[])
  {
    int k;

    for(k=0;k<LIMIT;k++)
      ordinato[k]=array[k];
  }



void Get_array(int array[])
  {
    int k;

    printf("Inserisci i valori da ordinare:\n");
    for(k=0;k<LIMIT;k++)                                    //funzione per il caricamento del vettore
      {
        scanf("%d", &array[k]);
      }
  }



void CONTROL(int array[])                                               //funzione per il controllo degli swap
  {
    int flag=1;                                           //variabile utilizzata per controllare che il vettore sia in ordine
    while(flag)
      {
        flag=0;
        flag=SWAP(flag, array);
      }
  }



int SWAP(int flag, int x[])                                                 //funzione per lo swap delle posizioni
  {
    int n,k,j;

    for(k=0;k<LIMIT;k++)
      {
        if(k==LIMIT)
          break;

        else
          {
            for(j=k;j<LIMIT;j++)
              {
                if(j==LIMIT)
                  break;

                else if(x[k]>x[j])
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
return flag;
  }



void PRINT(int array[], int ordinato[])                                   //funzione pper la stampa del vettore
  {
    int k;

    printf("\nIl vettore di partenza risulta:\t");
    for(k=0;k<LIMIT;k++)
      printf("%d   ", array[k]);
    printf("\nIl vettore riordinato diviene:\t");
    for(k=0;k<LIMIT;k++)
      printf("%d   ", ordinato[k]);
  }

int main(void)
  {
    int flag, flaggo, x[LIMIT], y[LIMIT], f;

    printf("\nVuoi eseguire il programma?\t{[0] per uscire}\t");
    scanf("%d", &flag);
    while(flag)
      {
        Get_array(x);
        COPY(x, y);
        CONTROL(y);
        PRINT(x, y);
        printf("\n\nVuoi eseguire il programma?\t{[0] per uscire}\t");
        scanf("%d", &flaggo);
        flag=flaggo;
      }

return (0);
  }
//Programma funzionante
