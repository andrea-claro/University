/*******************************************************************************************************
*Scrivere un programma che, considerata una matrice di dimensioni KxJ
***prenda in input la sottomatrice (K-1)x(J-1);
***stampi sull'ultima colonna la somma di ognuna delle righe;
***stampi sull'ultima riga la somma di ognuna delle colonne;
***stampi nella posizione {[K][J]} la somma tra la somma delle righe e la somma delle colonne.
********************************************************************************************************/
#include<stdio.h>
#include <stdlib.h>
#define SIZE 100

int righe=0, colonne=0;

void INPUT(int [][SIZE]);
void AGGIUNGI_SOMME(int [][SIZE]);
int SOMMA_RIGHE(int, int);
int SOMMA_COLONNE(int, int);
void STAMPA(int [][SIZE]);

int main()
{
  int matrix[SIZE][SIZE]={0}, rows_sum, columns_sum;
  /*int righe, colonne;
  righe=rand()%11;
  colonne=rand()%11;*/
  INPUT(matrix);
  printf("\nPrima della riduzione,");
  STAMPA(matrix);
  righe--;
  colonne--;
  printf("\nDopo la riduzione,");
  STAMPA(matrix);
  righe+=2;
  colonne+=2;
  AGGIUNGI_SOMME(matrix);
  printf("\nCon le somme,");
  STAMPA(matrix);
return 0;
}

void STAMPA(int tabella[][SIZE])
{
  printf("\nla matrice risulta:\n");
  for(int k=0;k<righe;k++)
  {
    for(int j=0;j<colonne;j++)
    {
      printf("{%d}  ", tabella[k][j]);
    }
    printf("\n");
  }
}

void AGGIUNGI_SOMME(int tabella [][SIZE])
{
  int sum_r, sum_c;
  for(int k=0;k<righe;k++)
  {
    sum_c=0;
    sum_r=0;
    for(int j=0;j<colonne;j++)
    {
      sum_r=SOMMA_RIGHE(tabella[k][j], sum_r);
      sum_c=SOMMA_COLONNE(tabella[j][k], sum_c);
      if(j==(colonne-1))
      {
        tabella[k][j]=sum_r;
        tabella[j][k]=sum_c;
      }
      if(k==(righe-1)&&j==(colonne-1))
        tabella[k][j]=(tabella[0][3]+tabella[1][3]+tabella[2][3])+(tabella[3][0]+tabella[3][1]+tabella[3][2]);
    }
  }
}

int  SOMMA_COLONNE(int number, int somma)
{
  somma+=number;
return somma;
}

int SOMMA_RIGHE(int number, int somma)
{
  somma+=number;
return somma;
}

void INPUT(int tabella[][SIZE])
{
  printf("\nInserisci il numero delle righe della matrice:\t"); scanf("%d", &righe);
  printf("Inserisci il numero delle colonne della matrice:\t"); scanf("%d", &colonne);
  printf("\nInserisci i dati all'interno della matrice:\n");
  for(int k=0;k<righe;k++)
  {
    for(int j=0;j<colonne;j++)
    {
      printf("[%d][%d]:", k, j); scanf("%d", &tabella[k][j]);
    }
    printf("\n");
  }
}
//Programma funzionante
