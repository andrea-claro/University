/**********************************************************************************************************
*Sommare i numeri per ogni riga e per ogni colonna di una matrice quadrata e li si memorizzi in un vettore*
**********************************************************************************************************/
#include <stdio.h>
#define RxC 4

void INPUT(int [][RxC]);
void STAMPA(int [][RxC], int [], int []);
void SOMMA_COLONNE(int [][RxC], int []);
void SOMMA_RIGHE(int [][RxC], int []);
int main()
{
  int matrix[RxC][RxC], rows_sum[RxC], columns_sum[RxC];
  INPUT(matrix);
  SOMMA_RIGHE(matrix, rows_sum);
  SOMMA_COLONNE(matrix, columns_sum);
  STAMPA(matrix, rows_sum, columns_sum);
return 0;
}

void INPUT(int tabella[][RxC])
{
 printf("\nInserisci i dati all'interno della matrice:\n");
 for(int k=0;k<RxC;k++)
 {
   for(int j=0;j<RxC;j++)
   {
     printf("[%d][%d]:\t", k, j); scanf("%d", &tabella[k][j]);
   }
   printf("\n");
 }
}

void STAMPA(int tabella [][RxC], int sr [], int sc [])
{
  int k, j;
  printf("\nLa matrice risulta:\n");
  for(k=0;k<RxC;k++)
  {
    for(j=0;j<RxC;j++)
    {
      printf("{%d}\t", tabella[k][j]);
    }
    printf("\n");
  }

  printf("\nLa somma delle righe risulta:\n");
  for(k=0;k<RxC;k++)
  {
    printf("{%d}\n", sr[k]);
  }

  printf("\nLa somma delle colonne risulta:\n");
  for(k=0;k<RxC;k++)
  {
    printf("{%d}\t", sc[k]);
  }
  printf("\n");
}

void SOMMA_COLONNE(int tabella[][RxC], int somma[])
{
  int temp;
  for(int k=0;k<RxC;k++)
  {
    temp=0;
    for(int j=0;j<RxC;j++)
    {
      temp+=tabella[j][k];
    }
  somma[k]=temp;
  }
}

void SOMMA_RIGHE(int tabella[][RxC], int somma[])
{
  int temp;
  for(int k=0;k<RxC;k++)
  {
    temp=0;
    for(int j=0;j<RxC;j++)
    {
      temp+=tabella[k][j];
    }
    somma[k]=temp;
  }
}
//Programma funzionante
