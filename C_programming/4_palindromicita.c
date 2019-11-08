/********************************************************************************************************************************************
*Controllare se una funzione sia palindroma oppure meno:
* -Ricevere dall'utente una stringa;
* -Controllare se la stringa sia palindroma oppure no(confrontarla col suo inverso e decretare se siano uguali).
**********************************************************************************************************************************************/

#include <stdio.h>

#define SIZE 100



int PALINDROMA(char [], int);
void STAMPA(int);
int INPUT(char []);

void STAMPA(int flag)
  {
    if(flag)
      printf("La stringa controllata e' palindroma\n");

    else
      printf("La stringa controllata non e' palindroma\n");
  }



int INPUT(char stringa[])
  {
    int k, counter=0, i;

    printf("Inserisci carattere dopo carattere il pattern di codice\t {digitare [-] per terminare l'inserimento}\n");
    for(k=0, i=0; k<SIZE; k++, i++)
      {
        scanf("%s", &stringa[k]);
        if(stringa[k]=='-')
        break;
      }

return i;
  }



int PALINDROMA(char stringa[], int dim)
  {
    int k, i, /*counter=0,*/ flag;

    /*for(k=0, i=dim; k==dim && i==0; k++, i--)
      {
        if(stringa[k]==stringa[i])
          counter++;
      }

    if(counter==dim)
return flag=1;
    else
return flag=0;*/

    for(k=0;k<=dim/2;k++)
      {
        if(stringa[k]!=stringa[dim-k])
        break;
      }

    if(k>dim/2)
return flag=1;
    else
return flag=0;

  }



int main()
  {
    int flag, flaggo, array_size, pal;
    char array[SIZE]={'0'};

    printf("\nVuoi lavorare col programma?\t{[0] peruscire\t}");
    scanf("%d", &flag);
      while(flag!=0)
        {
          array_size=INPUT(array);
          pal=PALINDROMA(array, array_size);
          STAMPA(pal);

          printf("\nVuoi lavorare ancora col programma?\t{[0] peruscire\t}");
          scanf("%d", &flaggo);
          flag=flaggo;
        }
return 0;
  }
// Programma funzionante
