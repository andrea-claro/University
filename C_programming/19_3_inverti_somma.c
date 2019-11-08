/***********************************************************************************************
 *1- Dato in input un numero, calcolare la somma delle sue cifre;
 *2- In caso il numero sia reale, calcolare la somma anche della parte decimale
************************************************************************************************/
#include <stdio.h>
#include <math.h>



double INPUT(void);
void PRINT(double);
int SUMdec(double);
int SUMint(double);



double INPUT(void)
  {
    double x;

    printf("Inserisci il numero che vuoi analizzare cifra per cifra:\t");
    scanf("%lf", &x);
return x;
  }



void PRINT(double x)
  {
    printf("\nIl numero preso in considerazione durante l'esecuzione risulta:\t%lf", x);
    printf("\nLa somma delle cifre decimali del numero risulta:\t%d", SUMdec(x));
    printf("\nLa somma delle cifre intere del numero risulta:\t%d", SUMint(x));
  }



int SUMdec(double x)
  {
    double dec, inter;
    int sum, k;

    dec=modf(x, &inter);
    sum=0;
    for(k=0;k<6;k++)
      {
        sum+=((int)dec%10);
        dec*=10;
      }
return sum;
  }



int SUMint(double x)
  {
    double dec, inter;
    int sum;

    dec=modf(x, &inter);
    sum=0;
    while((int)inter%10)
      {
        sum+=((int)inter%10);
        inter/=10;
      }
return sum;
  }



int main()
  {
    int flag, flaggo;
    double n;

    printf("\nVuoi eseguire il programma?\t{[0] per uscire}\t");
    scanf("%d", &flag);
    while(flag)
      {
        n=INPUT();
        PRINT(n);

        printf("\n\nVuoi eseguire ancora il programma?\t{[0] per uscire}\t");
        scanf("%d", &flaggo);
        flag=flaggo;
      }
return(0);
  }
//Programma funzionante
