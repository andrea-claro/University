#include <stdio.h>



#define SIZE 26



int INPUT(char []);
int CONTROLLO(int, int, char [], char []);
int STAMPA(char [], char [], int, int);



int INPUT(char stringa[])
  {
    int k;
      printf("Inserisci carattere dopo carattere il pattern di codice\t{[-] per terminare l'inserimento}\n");
      for(k=0; k<SIZE; k++)
        {
          scanf("%s", &stringa[k]);
          if(stringa[k]=='-')
            break;
        }
return k;
  }



int CONTROLLO(int x, int y, char stringa[], char anagramma[])
  {
    int k, j, flag=1, counter_stringa, counter_anagramma;
    if(x==y)
      {
        for(k=0;k<x;k++)
          {
            counter_stringa=counter_anagramma=0;
            for(j=0;j<x;j++)
              {
                if(stringa[k]==anagramma[j])
                  counter_stringa++;
                if(anagramma[k]==stringa[j])
                  counter_anagramma++;
              }
            if(counter_anagramma!=counter_stringa)
return flag=0;
          }
return flag;
      }
    else
return flag=0;
  }



int STAMPA(char vettore[], char anagramma[], int x, int y)
  {
    int k;
    if(!y)
      {
        printf("la stringa madre e il secondo pattern non sono anagrammabili\n");
return 0;
      }

    else
      {
        printf("\nLe due stringhe sono anagrammi\n");
        printf("La stringa madre risulta:\n");
        for(k=0;k<x;k++)
          printf("%c\t", vettore[k]);
        printf("\nIl vettore anagrammato risulta\n");
        for(k=0;k<x;k++)
          printf("%c\t", anagramma[k]);
        printf("\n");
    }
  }



int main()
  {
    int flag, flaggo, num1, num2, nun, fox;
    char array[SIZE], anagramma[SIZE];
    printf("\nVuoi lavorare col programma?\t{[0] per uscire\t}");
    scanf("%d", &flag);
      while(flag!=0)
        {
          num1=INPUT(array);
          num2=INPUT(anagramma);
          nun=CONTROLLO(num1, num2, array, anagramma);
          fox=STAMPA(array, anagramma, num1, nun);
          printf("\nVuoi lavorare ancora col programma?\t{[0] per uscire\t}");
          scanf("%d", &flaggo);
          flag=flaggo;
        }
return 0;
  }
