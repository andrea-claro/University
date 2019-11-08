//Dato un input in intero, denotare se n e' primo o non

#include <stdio.h>
#include <math.h>

int main ()
  {
  int c,x[32],k,n;
  printf("Inserisci il numero di cui vuoi verificare se sia primo"); printf("\n");
  scanf("%d", &n);

  x[0]=sqrt(n);

  for(k=0;k<x[0];k++)
    {
    if(k==0)
      continue;

    x[k]=x[k-1]-1;
    }

  c=0;

  for(k=0;k<x[0];k++)
    {
    if((double)(n%x[k])==0)
      c++;
    }

  if(c>2)
    {
    printf("Il numero non e' primo"); printf("\n");
    }

  else
    printf("Il numero e' primo"); printf("\n");

return(0);
  }
// durante la compilazione aggiungere la libreria
