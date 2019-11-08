#include <stdio.h>
#include <string.h>
#define SIZE_ARCHIVE 7
#define CITY_SIZE 20

void stampa(char *, int, char *[]);
int input(char *);
int ricerca(char *[], char *, int);
void elimina(char *[], int );

int main()
{
  int dim;
  char *string_array[SIZE_ARCHIVE]={"napoli", "palermo", "salerno", "milano", "londra", "fisciano", "eboli"}, city[CITY_SIZE];
  dim=input(city);
  stampa(city, dim, string_array);
  ricerca(string_array, city, dim); printf("\n");
  stampa(city, dim, string_array);
return 0;
}

void stampa(char *paese, int dimensione, char *array[])
{
  printf("Con la dimensione di %d caratteri, la citta' scelta risulta:\t", dimensione);
  printf("%s\n", paese);
  for(int k=0;k<SIZE_ARCHIVE;k++)
    printf("\n%s", *(array+k));
  printf("\n");
  /*ricerca(array, paese, dimensione); printf("\n");
  for(int k=0;k<SIZE_ARCHIVE;k++)
    printf("\n%s", *(array+k));
  printf("\n");*/
}

int ricerca(char *array[], char *scelta, int dim)
{
  int temp, size;
  for(int k=0;k<SIZE_ARCHIVE;k++)
  {
    size=strlen(array[k]);
    if(dim==size)
      {
        for(int j=0;scelta[j]!=0;j++)
          {
            if(array[k][j]!=scelta[j])
              break;
            else if(j==size-1)
            {
              temp=k;
              elimina(array, temp);
            }
          }
      }
  }
  /*for (int i=0;i<7;i++)
    for(int k=0,temp=0;scelta[k]!=0;k++){
      if(array[i][k]==scelta[k])
        temp++;
      if(temp==dim )
        elimina(array,i);
    }*/
}

void elimina(char *array[], int x)
{
  array[x]=NULL;
}

int input(char *scelta)
{
  int size;
  printf("\nInserisci il nome della citta' su cui operare:\t");
  scanf("%s", scelta);
  size=strlen(scelta);
return size;
}
//Programma non funzionante poiche' elimina tutte le citta' con lo stesso numero di caratteri
