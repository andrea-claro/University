//Dato un input in intero, denotare se n e' primo o non

#include <stdio.h>
#include <math.h>



int Get_Input(void);                                            //dichiarazione prototipi
int OPERATIONS(int);
void PRINT(int);


int Get_Input(void)                                               //funzione per l'immissione input
  {
    int x;
    printf("Inserisci il numero di cui vuoi verificare se sia primo\n");
    scanf("%d", &x);
return x;
  }



void PRINT(int verif)
  {
    if(OPERATIONS(verif))
      printf("Il numero risulta primo\n");

    else
      printf("Il numero risulta non primo\n");
  }



int OPERATIONS(int x)
  {
    int k, c, flag=0;

    for(k=1;k<sqrt(x);k++)
      {
        c=x%k;
        if(!c)
          flag++;
      }

    if(flag==1)
      return 1;

    else
      return 0;
  }



int main (void)
  {
    int n, flag, flaggo;

    printf("\nVuoi eseguire il programma?\t{[0] per uscire}\t");
    scanf ("%d", &flag);
    while(flag!=0)
      {
        n=Get_Input();
        PRINT(n);

        printf("\nVuoi eseguire il programma?\t{[0] per uscire}\t");
        scanf ("%d", &flaggo);
        flag=flaggo;
      }
return(0);
  }

//durante la compilazione aggiungere la libreria
//Programma funzionante
