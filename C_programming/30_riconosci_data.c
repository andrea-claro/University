#include<stdio.h>
#define YEAR 12

int INPUT(int [], int *, int *);
void STAMPA(int, int);

int main()
{
  int mese, giorno, data[12]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  INPUT(data, &mese, &giorno);
  STAMPA(mese, giorno);
}

void STAMPA(int month, int day)
{
  printf("Il giorno corrisponde a %d del %d mese\n", day, month);
}

int INPUT(int data[], int *indice, int *numero)
{
  int temp=0;
  printf("\nInserisci il il numero per il calcolo della data\t{[0]-[365]}:\n"); scanf("%d", numero);
  temp=*numero;
  for(int k=0;k<YEAR;k++)
  {
    if(temp>data[k])
    {
      temp-=data[k];
      continue;
    }
    else(temp<=data[k]);
    {
      *indice=k+1;
      *numero=temp;
      break;
    }
  }
}
