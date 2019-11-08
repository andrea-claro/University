/* Scrivere programma per:
   * Calcolo massimo;
   * Calcolo minimo;
   * Calcolo Massimo Comune Divisore tra massimo e minimo;
di un array precedentemente inizializzato. */

#include <stdio.h>



#define SIZE 8



int INPUT(int []);                          //* dichiarazione prototipi
int MIN(int []);                            //*
int MAX(int []);                            //*
int MCD(int, int);                          //*
int PROD(int, int);                         //*
int MCM(int, int);                          //*
void PRINT(int [], int, int, int, int);     //*



int MIN(int x[])                            //* funzione per il cacolo del minimo
  {                                         //*
    int k, w;                               //*
                                            //*
    w=x[0];                                 //*
                                            //*
    for (k=1;k<SIZE;k++)                    //*
      {                                     //*
        if (w>x[k])                         //* controllo sul minimo del vettore
          w=x[k];                           //*
      }                                     //*
return w;                                   //* ritorno del minimo calcolato
  }                                         //*



int MAX(int x[])                            //* funzione per il cacolo del massimo
  {                                         //*
    int k, w;                               //*
                                            //*
    w=x[0];                                 //*
                                            //*
    for (k=1;k<SIZE;k++)                    //*
      {                                     //*
        if (w<x[k])                         //* controllo sul massimo del vettore
          w=x[k];                           //*
      }                                     //*
return w;                                   //* ritorno del massimo calcolato
  }                                         //*



int MCD(int min, int mas)                   //* funzione per il cacolo del massimo comune divisore
  {                                         //*
    while(min!=mas)                         //* controllo di uscita per il calcolo
      {                                     //*
        if(min>mas)                         //*
          min-=mas;                         //*
                                            //*
        else                                //*
          mas-=min;                         //*
      }                                     //*
                                            //*
return min;                                 //* ritorno del massimo comune divisore calcolato
  }                                         //*



int PROD(int x, int y)                      //* funzione per il cacolo del prodotto tra massimo e minimo del vettore
  {                                         //*
return (x*y);                               //* ritorno valore
  }                                         //*



int MCM(int min, int mas)                   //* funzione per il cacolo del minimo comune multiplo tra massimo e minimo
  {                                         //*
    int x, y;                               //*
                                            //*
    x=PROD(min, mas);                       //*
    y=MCD(min, mas);                        //*
                                            //*
return (x/y);                               //* ritorno valore
  }                                         //*



void PRINT(int vettore[], int w, int y, int z, int f)                           //* funzione per la stampa dei valori
  {                                                                             //*
    int k;                                                                      //*
                                                                                //*
   printf("\nSul vettore predisposto:\n");                                      //*
   for (k=0;k<SIZE;k++)                                                         //*
      printf("%d   ", vettore[k]);                                              //*
    printf("\n");                                                               //*
    printf("Il massimo calcolato risulta:\t%d", y);                             //*
    printf("\n");                                                               //*
    printf("Il minimo calcolato risulta:\t%d", w);                              //*
    printf("\n");                                                               //*
    printf("Il Massimo Comune Divisore calcolato risulta:\t%d", z);             //*
    printf("\n");                                                               //*
    printf("Il Minimo Comune Multiplo calcolato risulta:\t%d", f);              //*
    printf("\n\n");                                                             //*
  }                                                                             //*



/*int PAINT(int vettore[])
  {
    int b, h, p;

        b=vettore[0];
        h=vettore[7];
        p=PERIMETRO(b, h);
  }



int PERIMETRO(int x, int y)
  {
return ((x*2)+(y*2))
  }*/



int INPUT(int vettore[])                                                        //* funzione per l'immissione dei dati nel vettore
  {                                                                             //*
    int k;                                                                      //*
                                                                                //*
    printf("Inserisci i valori da inserire all'interno del vettore\n");         //*
    for (k=0;k<SIZE;k++)                                                        //*
      {                                                                         //*
        scanf("%d", &vettore[k]);                                               //*
                                                                                //*
/*        if(k==0)                                                                //*
          printf("Il valore sara' preso come base del quadrilatero");           //*
                                                                                //*
        if(k==7)                                                                //*
          printf("Il valore sara' preso come altezza del quadrilatero");       */ //*
      }                                                                         //*
  }                                                                             //*



int main(void)
  {
    int x[SIZE]={0}, a, b, c, d, flag, flaggo;                    //dichiarazione+inizializzazione del vettore su cui compiere calcoli; dichiarazione parametri di assegnazione di ritorno funzione;

    printf("Vuoi mandare in esecuzione il programma? {[0] per uscire}\t");
    scanf("%d", &flag);
    while(flag!=0)
      {
        INPUT(x);
        a=MIN(x);
        b=MAX(x);
        c=MCD(a, b);
        d=MCM(a, b);
        PRINT(x, a, b, c, d);
        printf("Vuoi mandare in esecuzione il programma? {[0] per uscire}\t");
        scanf("%d", &flaggo);
        flag=flaggo;
      }
return (0);
  }

//Programma funzionante
