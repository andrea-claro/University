#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define RIG 4
#define COL 20

void copia(char *[], char *[], char [][COL]);
void stampa_copia(char [][COL]);
void *allocare(char [][COL], char *[], int);
void ordinare(char **);
void swappare(char *, char *);
void stampa_ordinato(char *[]);

int main(void)
{
	char *archivio1[RIG]={"ago","uccello","castello","ultraleggero"},
	     *archivio2[RIG]={"sole","marmo","ottica","martello"},
			 archivio[2*RIG][COL],
			 *archivio_ordinato[2*RIG];

	copia(archivio1, archivio2, archivio);
	stampa_copia(archivio);

	for(int k=0; k<2*RIG; k++)
		archivio_ordinato[k]=allocare(archivio, archivio_ordinato, k);

	ordinare(archivio_ordinato);
	stampa_ordinato(archivio_ordinato);

	return 0;
}

void ordinare(char **composto)
{
	int i;

	for(i=0;i<(2*RIG)-1;i++)
		for(int j=i+1;j<2*RIG;j++)
			if(strlen(composto[j])>strlen(composto[i]))
				swappare(composto[i],composto[j]);
}

void swappare(char *a, char *b)
{
	char *temp=(char *)malloc(25*sizeof(char));
	strcpy(temp, a);
	strcpy(a, b);
	strcpy(b, temp);

}

void *allocare(char deposito[][COL], char *composto[], int k)
{
	while(k<2*RIG)
	{
		composto[k]=(char *)malloc(25*sizeof(char));
		strcpy(composto[k], deposito[k]);

		return composto[k];
	}
}

void copia(char *lista1[], char *lista2[], char deposito[][COL])
{
	int k;
	for(k=0;k<RIG;k++)
		strcpy(deposito[k], lista1[k]);
	for(int j=0;j<RIG;j++,k++)
		strcpy(deposito[k], lista2[j]);
}

void stampa_ordinato(char *composto[])
{
	for(int k=0;k<2*RIG;k++)
		printf("\n%s", composto[k]);
	printf("\n");
}
void stampa_copia(char deposito[][COL])
{
	for(int k=0;k<2*RIG;k++)
		printf("\n%s", deposito[k]);
	printf("\n");
}
