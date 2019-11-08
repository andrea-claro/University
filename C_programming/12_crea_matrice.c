/********************************************************************************************
*Creare un array bidimensionale
*********************************************************************************************/
#include<stdio.h>



#define SIZE 100



int rows=0, columns=0;



int INPUT(int tabella[][SIZE])
{
printf("\nDi quante righe e colonne vuoi che sia grande la tabella?\n");
scanf("%d%d", &rows, &columns);
printf("Inserisci i valori nella tabella [righe][colonne]\n");
  for(int k=0;k<rows;k++)
  {
    for(int j=0;j<columns;j++)
    {
    printf("[%d][%d]\t", k, j);
    scanf("%d", &tabella[k][j]);
    }
  }
}



void STAMPA(int tabella[][SIZE])
{
int k, j;
printf("\nla tabella risulta:\n");
  for(k=0;k<rows;k++)
  {
    for(j=0;j<columns;j++)
    printf("%d   ", tabella[k][j]);
  printf("\n");
  }
}



int main()
{
int Matrice[SIZE][SIZE];
INPUT(Matrice);
STAMPA(Matrice);
}
//Programma mezzo funzionante
