#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 20

int num_province;

char *insert(char *[], char *);
void stampa_in(char *[], char *);
int controllo(char *[], char *);
void libera(char *[], char *);

int controllo(char *territorio[], char *citta)
{
  for(int k=0;k<num_province;k++)
    if(!strcmp(territorio[k], citta))
      return 1;

  return 0;
}

void stampa_in(char *territorio[], char *citta)
{
  printf("\nCitta scelta:\t%s\n", citta);

  for(int k=0;k<num_province;k++)
  {
    printf("Provincia della regione:\t%s\n", territorio[k]);
  }
}

char *insert(char *territorio[], char *citta)
{
  char *assimila;

  assimila=(char *)malloc(32*sizeof(char));
  printf("Inserisci citta:\t");
  scanf("%s", assimila);

  citta=(char *)malloc((strlen(assimila)+1)*sizeof(char));
  strcpy(citta, assimila);

  printf("Numero province della regione:\t");
  scanf("%d", &num_province);

  for(int k=0;k<MAX;k++)
  {
    if(k<num_province)
    {
      printf("Inserisci provinca n%d:\t", k+1);
      scanf("%s", assimila);
      territorio[k]=(char *)malloc(strlen(assimila)*sizeof(char));
      strcpy(territorio[k], assimila);
    }
    else
    {
      territorio[k]=(char *)calloc(1, sizeof(char));
    }
  }

  return citta;
}

void libera(char *territorio[], char *citta)
{
  for (int k=0;k<MAX;k++)
    free(territorio[k]);
  free(citta);
}

int main()
{
  char *regione[MAX],
       *provincia;

  //provincia=(char *)malloc(32*sizeof(char));

  provincia=insert(regione, provincia);
  stampa_in(regione, provincia);

  if(controllo(regione, provincia))
  {
    puts("La citta e' provincia della regione");
    libera(regione, provincia);
  }
  else
  {
    puts("Non c'e' coesistenza");
    libera(regione, provincia);
  }
  return 0;
}
