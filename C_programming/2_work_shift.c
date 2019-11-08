/****************************************************************************************************************************
*Shift dei valori di un vettore
*****************************************************************************************************************************/
#include<stdio.h>



#define SIZE 50



int INPUT(int []);
void STAMPA(int [], int);
int SHIFT_SX(int [], int, int);
int SHIFT_DX(int [], int, int);
int SCEGLI();
int SCEGLI_OPZIONE(char, int[]);



int INPUT(int array[])
{
int k;
printf("\nInserisci gli elementi nel vettore\t{[-1]per terminare inserimento}\n");
  for(k=0;k<SIZE;k++)
  {
  scanf("%d", &array[k]);
    if(array[k]==-1)
    break;
  }
return k;
}



void STAMPA(int array[], int x)
{
int k;
printf("\nLa dimensione del vettore risulta di:\t%d", x);
printf("\ncon i seguenti caratteri:\n");
  for(k=0;k<x;k++)
  printf("%d\t", array[k]);
printf("\n");
}



int SHIFT_SX(int array[], int dim, int pos)
{
int k, j;
  for(k=pos;k<dim-1;k++)
  {
    array[k]=array[k+1];
  }
return dim-1;
}



int SHIFT_DX(int array[], int dim, int pos)
{
  int k;
  printf("\n\nla posizione scelta e' %d\n\n", pos);
  for(k=dim+1;k>pos;k--)
  {
  array[k]=array[k-1];
  //STAMPA(array, dim+1);
  }
  array[k]=0;
return dim+1;/*
  }*/
}



int SCEGLI()
{
int pos;
printf("\nDa quale posizione vuoi partire:\t");
scanf("%d", &pos);
return pos;
}



int SCEGLI_OPZIONE(char choice, int vettore[])
{
int dimensione, posizione;
char scelta;
//printf("\n%d", posizione);
  while(choice!='-')
  {
    //printf("\n%d", posizione);
    switch(choice)
    {
    case '1':
    dimensione=INPUT(vettore);
    posizione=SCEGLI();
    //printf("\n%d\n", posizione);
    break;

    case '2':
    STAMPA(vettore, dimensione);
    //printf("\n%d\n", posizione);
    break;

    case '3':
    printf("\nvettore modificato\n");
    //printf("%d", posizione);
    dimensione=SHIFT_DX(vettore, dimensione, posizione);
    break;

    case '4':
    printf("\n vettore modificato\n");
    dimensione=SHIFT_SX(vettore, dimensione, posizione);
    break;

    default:
    printf("[-]per terminare il programma:\t");
    //scanf("%s", &choice);
    break;
    }
  /*printf("\n[1]\tMemorizza la stringa di caratteri e la posizione con cui fare lo shift");
  printf("\n[2]\tStampa i dati");
  printf("\n[3]\tUsa la funzione shift a destra");
  printf("\n[4]\tUsa la funzione shift a sinistra");*/
  printf("\nScegli cosa vuoi fare col programma:\t");
  scanf("%c", &scelta);
  choice=scelta;
  }
}



int main()
{
int vettore[SIZE];
char scelta;
printf("\n[1]\tMemorizza la stringa di caratteri e la posizione con cui fare lo shift");
printf("\n[2]\tStampa i dati");
printf("\n[3]\tUsa la funzione shift a destra");
printf("\n[4]\tUsa la funzione shift a sinistra");
printf("\nScegli cosa vuoi fare col programma:\t");
scanf("%s", &scelta);
SCEGLI_OPZIONE(scelta, vettore);
return 0;
}
//Programma non funzionante
