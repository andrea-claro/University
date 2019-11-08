#include <stdio.h>
#define SIZE 10

void COPIA_ESEMPIO_ARRAY(char [], char []);
void COPIA_ESEMPIO_PUNTATORE(char *, char *);

int main()
{
  char string1[SIZE], *string2="Hello", string3[SIZE], *string4="Good Bye";
  COPIA_ESEMPIO_ARRAY(string1, string2);
  printf("%s", string1);
  COPIA_ESEMPIO_PUNTATORE(string3, string4);
  printf("\n%s\n", string3);
return 0;
}

void COPIA_ESEMPIO_ARRAY(char array [], char puntatore [])
{
  for(int k=0; k<SIZE; k++)
    array[k]=puntatore[k];
}

void COPIA_ESEMPIO_PUNTATORE(char *array, char *puntatore)
{
  for(int k=0; k<SIZE; k++)
    *(array+k)=*(puntatore+k);
}
