/*
1- Dato in input un numero, calcolare la somma delle sue cifre;
2- In caso il numero sia reale, calcolare la somma anche della parte decimale
*/
#include <stdio.h>
#include <math.h>

double Get_Input(void);                                   //dichiarazione prototipi
int Do_Actions(void);

double n,n1;                                              //dichiarazione variabili globali
int k,iSumInt;

double Get_Input(void)
  {
    printf("Inserisci il numero di cui vuoi sommare le cifre:\t");      //funzione per l'immissione di input
    scanf("%lf", &n); printf("\n");
  }

int Do_Actions(void)                                     //funzione per l'inversione e la somma delle cifre
  {
    int x1,x2;                                          //dichiarazione variabili attuali

    x1=0;
    n1=n;

    while(n1==0)
      {
        for(k=0;k==n;k++)
          {
            x1=(int)n/10;
            if(x1!=0)
            x2=x1;

            if(x1==0)
              {
                iSumInt+=x2;
                break;
              }
          }

        x2*=(pow(10,k));
        n1-=x2;
      }
  }

int main(void)
  {

    Get_Input();
    Do_Actions();

    printf("Il numero delle cifre sommato, diviene:\t%d", iSumInt); printf("\n");
return(0);
  }

//Programma non funzionante
