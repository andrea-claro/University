#include <stdio.h>
#define SIZE 10

void INPUT(char *);
int CONTROLLO(char *, char *);
void STAMPA(int);

int main()
{
  int flag;
  char string[SIZE], prefisso[]={'0','8','1'};
  INPUT(string);
  flag=CONTROLLO(string, prefisso);
  STAMPA(flag);
}

void STAMPA(int x)
{
  if(x)
    printf("\nSui caratteri digitati 081 risulta il prefisso della stringa\n");
  else
    printf("\nSui caratteri digitati 081 non risulta il prefisso della stringa\n");
}

void INPUT(char *string_pointer)
{
  printf("\nInserisci i caratteri da controllare:\n");
  for(int k=0; k<SIZE; k++)
    scanf("%c", (string_pointer+k));
}

int CONTROLLO(char *string_pointer, char *prefisso)
{
  if(*(string_pointer+0)==*(prefisso+0))
  {
    if(*(string_pointer+1)==*(prefisso+1))
    {
      if(*(string_pointer+2)==*(prefisso+2))
return 1;
    }
  }
  else
return 0;
}
