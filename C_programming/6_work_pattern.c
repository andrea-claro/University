/********************************************************************************************************************************************
*Controllare che un pattern presente in una stringa sia la piu' grande tra diverse stringhe:
* -Ricevere dall'utente una stringa;
* -Controllare quale sia il pattern piu' grande;;
* -Se il pattern e' il piu' grande, memorizzarlo in un array.
**********************************************************************************************************************************************/
#include <stdio.h>



#define SIZE 100



int INPUT(char []);
//int CONTROL(char[], char[], int);
void STAMPA(char [], int);
int MAX_CONTROL(int, char[], char[], int);
int BOiADE(char [], char[], char[]);



int INPUT(char stringa[]/*, char fine[]*/)
  {
    int k;

      printf("Inserisci carattere dopo carattere il pattern di codice\t{[-] per terminare l'inserimento}\n");
      for(k=0; k<SIZE; k++)
        {
          scanf("%s", &stringa[k]);

          if(stringa[k]=='-')
            break;

            /*if(stringa[0]==fine[0])
              {
                for(i=1;i<2;i++)
                  {
                    if(stringa[i]==fine[i])
                      flag=1;

                    else
                      flag=0;
                  }
                if(flag)
return j=0;
              }*/
        }
return k;
  }



/*int CONTROL(char stringa[], char controllo[], int dim)
  {
    int k, max=0;

    if(dim)
      {
        if(dim>max)
        {
          max=dim;
          for(k=0;k<dim;k++)
            {
              controllo[k]=stringa[k];
            }
        }
return max;
      }
  }*/



void STAMPA(char array[], int x)
  {
    int k;
    printf("La stringa col numero (%d) massimo di caratteri e':\n", x);
    for(k=0;k<x;k++)
      printf("%c", array[k]);

    printf("\n");
  }



int BOiADE(char vettore[], char biggest[], char done[])
  {
    int num, max=0;

    while(1)
      {
        printf("Inserisci i caratteri della stringa\n");
        num=INPUT(vettore);
        if((vettore[0]==done[0])&&(vettore[1]==done[1])&&(vettore[2]==done[2]))
return max;
        max=MAX_CONTROL(num, vettore, biggest, max);
      }
return max;
  }



int MAX_CONTROL(int x, char stringa[], char fine[], int max)
  {
    int k;

    if(max<x)
      {
        max=x;
        for(k=0;k<x;k++)
          fine[k]=stringa[k];
      }
return max;
  }



int main()
  {
    int flag, flaggo, num;
    char array[SIZE], duck[SIZE], end[]={'x', 'y', 'z'};

    printf("\nVuoi lavorare col programma?\t{[0] per uscire\t}");
    scanf("%d", &flag);
      while(flag!=0)
        {
          //printf("Inserisci i caratteri della stringa madre\n");

          num=BOiADE(array, duck, end);
          /*array_size=INPUT(array);

          num=CONTROL(array, bigger, array_size);*/

          STAMPA(duck, num);

          printf("\nVuoi lavorare ancora col programma?\t{[0] per uscire\t}");
          scanf("%d", &flaggo);
          flag=flaggo;
        }
return 0;
  }
//Programma funzionante
