/****************************************************************************************************************************************
*Scrivere un array di SIZE numeri interi,
***assegnare un valore a due variabili puntatore che puntano rispettivamente all'elemento dell'array contenente il minimo ed il massimo.
*****************************************************************************************************************************************/
#include <stdio.h>
#define SIZE 100

void input(int [], int *);
int max_search(int [], int);
int min_search(int [], int);
void stampa(int *, int *);

int max_search(int array [], int num)
{
  int max;
  max=array[0];
  for(int k=0;k<num;k++)
  {
    if(max<array[k])
      max=k;
  }
return (&array[max]);
}

int min_search(int array [], int num)
{
  int min;
  min=array[0];
  for(int k=0;k<num;k++)
  {
    if(min>array[k])
      min=k;
  }
return (&array[min]);
}

void input(int array[], int *num_puntatore)
{
  int k;
  printf("\nInserisci i dati:\t{[-1] per terminare inserimento}\n");
    for(k=0;k<*num_puntatore;k++)
    {
      scanf("%d\t", &array[k]);
      if(array[k]==-1)
        break;
    }
*num_puntatore=k;
}

int main()
{
  int const num=100;
  int *max_pointer, *min_pointer, box[num];
  input(box, &num);
  max_pointer=max_search(box, num);
  min_pointer=min_search(box, num);
  stampa(max_pointer, min_pointer);
}

void stampa(int *max, int *min)
{
  printf("L'indirizzo del massimo risulta %p mentre quello del minimo %p", max, min);
}
