/*******************************************************************************************************
*Scrivere un programma che, data in input una matrice 2x2 stampi la matrice ed il relativo determinante
********************************************************************************************************/
#include<stdio.h>



#define SIZE 2



int INPUT(int [][SIZE]);
int DETERMINANTE(int [][SIZE]);
void STAMPA(int [][SIZE], int);



int main()
{
  int data, matrix[SIZE][SIZE];
  INPUT(matrix);
  data=DETERMINANTE(matrix);
  STAMPA(matrix, data);
return 0;
}



int INPUT(int tabella [][SIZE])
{
  printf("\nInserisci i dati all'interno della matrice:\n");
  for(int k=0;k<SIZE;k++)
  {
    for(int j=0;j<SIZE;j++)
    {
      printf("[%d][%d]:", k, j); scanf("%d", &tabella[k][j]);
    }
  }
}



void STAMPA(int tabella[][SIZE], int x)
{
  printf("\nLa matrice risulta:\n");
  for(int k=0;k<SIZE;k++)
  {
    for(int j=0;j<SIZE;j++)
    {
      printf("{%d}  ", tabella[k][j]);
    }
    printf("\n");
  }
  printf("\nIl determinante della funzione vale %d\n", x);
}



int DETERMINANTE(int tabella [][SIZE])
{
  int x;
  return x=((tabella[0][0]*tabella[1][1])-(tabella[0][1]*tabella[1][0]));
}
