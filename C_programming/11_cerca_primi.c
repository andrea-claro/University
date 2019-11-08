/**********************************************************************************************************
*Sommare i numeri per ogni riga e per ogni colonna di una matrice quadrata e li si memorizzi in un vettore*
**********************************************************************************************************/
#include <stdio.h>
#include <math.h>
#define C 4
#define R 4

void INPUT(int [][C]);
void STAMPA(int [][C], int [], int);
int CERCA_PRIMI(int [][C], int []);
int OPERATIONS(int);

int main()
{
  int matrix[R][C], prime_numbers[R*C], x_primi;
  INPUT(matrix);
  x_primi=CERCA_PRIMI(matrix, prime_numbers);
  STAMPA(matrix, prime_numbers, x_primi);
return 0;
}

int OPERATIONS(int numero)
  {
    int resto, flag=0;

    for(int k=2;k<=sqrt(numero);k++)
      {
        resto=numero%k;
        if(!resto)
          flag++;
      }

    if(!flag)
      return 1;

    else
      return 0;
  }

void INPUT(int tabella[][C])
{
 printf("\nInserisci i dati all'interno della matrice:\n");
 for(int k=0;k<R;k++)
 {
   for(int j=0;j<C;j++)
   {
     printf("[%d][%d]:\t", k, j); scanf("%d", &tabella[k][j]);
   }
   printf("\n");
 }
}

void STAMPA(int tabella [][C], int primi [], int x)
{
  int k;
  printf("\nLa matrice risulta:\n");
  for(k=0;k<R;k++)
  {
    for(int j=0;j<C;j++)
    {
      printf("{%d}\t", tabella[k][j]);
    }
    printf("\n");
  }

  printf("\nI numeri primi ritrovati nella matrice risultano:\n");
  for(k=0;k<x;k++)
  {
    printf("{%d}\t", primi[k]);
  }
  printf("\n");
}

int CERCA_PRIMI(int tabella [][C], int primi [])
{
  int temp, w=0;
  for(int k=0;k<R;k++)
  {
    for(int j=0;j<C;j++)
    {
      temp=OPERATIONS(tabella[k][j]);
      if(temp)
      {
          primi[w]=tabella[k][j];
          w++;
      }
    }
  }
return w;
}

//Programma funzionante
