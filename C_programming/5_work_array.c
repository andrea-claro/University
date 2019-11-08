/*********************************************************************************************************************************************
  * Programma sviluppato per del lavoro generale su array
  *********************************************************************************************************************************************/

#include <stdio.h>



#define SIZE 8



int INPUT(int []);
void PRINT(int [], int []/*, int*/);
int REVERSE(int [], int []);
int INIZIALIZZA(int []);
//int MCD(int []);
int MAX(int []);
int MIN(int []);



int INPUT(int vettore[])
  {
    int k;

    printf("Inserisci i valori da assegnare alle posizioni\n");
      for(k=0;k<SIZE;k++)
        scanf("%d", &vettore[k]);
  }



void PRINT(int vettore[], int reverse[]/*, int mcd*/)
  {
    int k;

    printf("Il vettore preso in considerazione risulta:\t");
    for(k=0;k<SIZE;k++)
      {
        printf("%d   ", vettore[k]);
      }

    printf("\nIl suo inverso risulta:\t");
    for(k=0;k<SIZE;k++)
      {
        printf("%d   ", reverse[k]);
      }

    printf("\nIl valore massimo dell'array risulta:\t%d", MAX(vettore));
    printf("\nIl valore minimo dell'array risulta:\t%d", MIN(vettore));
    //printf("\nIl massimo comune divisore nell'array risulta:\t%d", mcd);

  }



int REVERSE(int vettore[], int reverse[])
  {
    int k, temp;

    for(k=0;k<SIZE/2;k++)
      {
        reverse[k]=vettore[k];
        temp=reverse[k];
        reverse[k]=vettore[SIZE-1-k];
        reverse[SIZE-1-k]=temp;
      }
  }



int INIZIALIZZA(int vettore[])
  {
    int k;

    for(k=0;k<SIZE;k++)
      {
        vettore[k]=0;
      }
  }


/*int MCD(int vettore[])
  {
    int mas=0, k, c;

    while(vettore[0]==vettore[1]==vettore[2]==vettore[3]==vettore[4]==vettore[5]==vettore[6]==vettore[7])
      {
        mas=MAX(vettore);
        for(k=0;k<SIZE;k++)
          {
            if(mas==vettore[k])
              c=k;
          }

        for(k=0;SIZE;k++)
          {
            if(c==k)
              continue;
            vettore[c]-=vettore[k];
          }
      }
  }*/



int MAX(int array[])
  {
    int k, x;

    x=array[0];
    for(k=1;k<SIZE;k++)
      {
        if(x<array[k])
          x=array[k];
      }
return x;
  }



int MIN(int array[])
  {
    int k, x;

    x=array[0];
    for(k=0;k<SIZE;k++)
      {
        if(x>array[k])
          x=array[k];
      }
return x;
  }



int main()
  {
    int flag, flaggo, array[SIZE], invertito[SIZE]/*, f*/;

    printf("\nVuoi lavorare col programma?\t{[0] peruscire\t}");
    scanf("%d", &flag);
      while(flag!=0)
        {
          INPUT(array);
          INIZIALIZZA(invertito);
          REVERSE(array, invertito);
          //f=MCD(array);
          PRINT(array, invertito/*, f*/);

          printf("\nVuoi lavorare ancora col programma?\t{[0] peruscire\t}");
          scanf("%d", &flaggo);
          flag=flaggo;
        }
  }
//Programma funzionante
