/*
1- Dato in input un numero, calcolare la somma delle sue cifre;
2- In caso il numero sia reale, calcolare la somma anche della parte decimale
*/
#include <stdio.h>
#include <math.h>

int main()
  {
    double n,n1;
    int k,x1,x2,iSumInt;

    printf("Inserisci il numero di cui vuoi sommare le cifre:\t");
    scanf("%lf", &n); printf("\n");

    n1=n;
    x1=0;

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

    printf("Il numero delle cifre sommato, diviene:\t%d", iSumInt); printf("\n");
return(0);
  }
