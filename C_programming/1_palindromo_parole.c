
/****************************************************************************************************************************************************************************
*Scrivere un programma che, dopo aver letto un messaggio, dica se esso e' palindromo (il messaggio e' lo stesso sia leggendo da sinistra a destra che da destra a sinistra).
*****************************************************************************************************************************************************************************/
#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define SIZE 50

int palindromicita(char *, int);
void stampa(int);
void input(char *);
int elimina_spazi(char *);

int main()
{
  char parola[SIZE];
  int flag, dim;
  input(parola);
  dim=elimina_spazi(parola);
  flag=palindromicita(parola, dim);
  stampa(flag);
}

int elimina_spazi(char *stringa)
{
  //int j=0;
  int temp, k=0, dim=strlen(stringa);
  while(*(stringa+k)!='\0')
  {
    if(*(stringa+k)==' ')
    {
      temp=k;
      for(int j=temp;j<dim-1;j++)
        *(stringa+j)=*(stringa+(j+1));
      dim--;
    }
    if(k==dim)
return dim;
    k++;
  }
//printf("\nLa frase da verificare risultava:\t%s", stringa);
  /*for(int k=0;*(stringa+k)!='\0';k++)
  {
    if(*(stringa+k)==' ')
    {
      *(stringa+(j++))=*(stringa+k);
    }
  }
return j;*/
}

void stampa(int x)
{
  //printf("\nLa frase da verificare risultava:\t%s", stringa);
    if(x)
      printf("\nLa stringa e' palindroma\n");
    else
      printf("\nLa stringa non e' palindroma\n");
}

void input(char *stringa)
{
  char ch;
  printf("\nInserisci la parola possibilmente palindroma:\t"); ch=getchar();
  //printf("%c\n", ch);
  for(int k=0;ch!='\n';k++)
    {
      *(stringa+k)=tolower(ch);
       ch=getchar();
    }
}

int palindromicita(char *stringa, int dimensione)
{
  int flag, k;
  for(k=0;k<dimensione-1;k++)
    if(*(stringa+k)!=(*(stringa+((dimensione-1)-k))))
      break;
  if(k>dimensione/2)
return flag=1;
  else
return flag=0;
}
