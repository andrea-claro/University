/********************************************************************************************************************************************
*Controllare che un pattern sia presente in una stringa oppure no:
* -Ricevere dall'utente una stringa;
* -Ricevere dall'utente il pattern da controllare nella stringa;
* -Controllare se il pattern sia presente nella stringa.
**********************************************************************************************************************************************/
#include <stdio.h>



#define MAX 100



int INPUT(char []);
int CONTROL(char [], char[], int, int);
void STAMPA(char [], char[], int, int, int);



int INPUT(char stringa[])
  {
    int k=0, i;

    printf("Inserisci carattere dopo carattere il pattern di codice\t {[-] per terminare l'inserimento}\n");
    for(k=0, i=0; k<MAX; k++)
      {
        scanf("%s", &stringa[k]);

        if(stringa[k]=='-')
          break;

        i++;
      }
return i;
  }



int CONTROLLO(char parola[], char rip[], int x, int y)
  {
    int k, j, conta, conta_controllo=0, i;

    for(k=0; k<x; k++)
      {
        if(parola[k]==rip[0])
          {
            conta=0;
            for(j=0, i=k; j<y;i++, j++)
              {
                if(parola[i]==rip[j])
                  conta++;
              }
            if(conta==y)
              conta_controllo++;
          }
      }
return conta_controllo;
  }



void STAMPA(char parola[], char rip[], int num, int x, int y)
  {
    int k;
    printf("Il pattern:\n");

    for(k=0;k<y;k++)
      printf("%s\t", rip[k]);

    printf("\nE' presente %d volte nella parola madre:\n", num);

    for(k=0;k<x;k++)
      printf("%s\t", parola[k]);

    printf("\n");
  }



int main()
  {
    int flag, flaggo, array_size, pattern_size, num;
    char array[MAX], pattern[MAX];

    printf("\nVuoi lavorare col programma?\t{[0] per uscire\t}");
    scanf("%d", &flag);
      while(flag!=0)
        {
          printf("Inserisci i caratteri della stringa madre\n");
          array_size=INPUT(array);
          printf("Inserisci i caratteri del pattern di controllo\n");
          pattern_size=INPUT(pattern);

          num=CONTROLLO(array, pattern, array_size, pattern_size);
          STAMPA(array, pattern, num, array_size, pattern_size);

          printf("\nVuoi lavorare ancora col programma?\t{[0] per uscire\t}");
          scanf("%d", &flaggo);
          flag=flaggo;
        }
return 0;
  }
//Programma funzionante
