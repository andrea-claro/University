//Dati due vettori di cinque elementi ognuno, stampare in un terzo vettore solo gli elementi pari presi dai primi due vettori

#include <stdio.h>



#define SIZE 5



int INPUT(int []);
int TRANSFER(int [], int [], int []);
void PRINT(int [], int [], int []);
int INIZIALIZZA(int []);



void PRINT(int primo[], int secondo[], int pari[])
  {
    int k;

    printf("\nIl primo vettore preso in considerazione risulta:\n");
    for(k=0;k<SIZE;k++)
      printf("%d   ", primo[k]);
    printf("\n");

    printf("Il secondo vettore preso in considerazione risulta:\n");
    for(k=0;k<SIZE;k++)
      printf("%d   ", secondo[k]);
    printf("\n");

    printf("Il vettore trasferito risulta:\n");
    for(k=0;k<SIZE*2;k++)
      printf("%d   ", pari[k]);
    printf("\n");
  }



int INPUT(int vettore[])
  {
    int k;

    printf("Inserisci i dati nell'array\n");
    for(k=0;k<SIZE;k++)
      scanf("%d", &vettore[k]);
  }



int TRANSFER(int vettore1[], int vettore2[], int pari[])
  {
    int k, i, j;

    k=-1;
    i=-1;
    for(j=0;j<SIZE*2;j++)
      {
        if(pari[j]==0)
          {
            k++;
            for(k;k<SIZE;k++)
              {
                if((vettore1[k]%2)==0)
                  {
                    pari[j]=vettore1[k];
                    break;
                  }
              }
            if(k>=SIZE)
              {
                i++;
                for(i;i<SIZE;i++)
                  {
                    if((vettore2[i]%2)==0)
                      {
                        pari[j]=vettore2[i];
                        break;
                      }
                  }
              }
          }
      }
  }


int INIZIALIZZA(int vettore[])
  {
    int k;

    for(k=0;k<SIZE*2;k++)
      vettore[k]=0;
  }



int main(void)
  {
    int uno[SIZE], due[SIZE], tre[SIZE*2]={0}, flag, flaggo;

    printf("\nVuoi eseguire il programma?\t {[0] per uscire}\t");
    scanf("%d", &flag);
    while(flag!=0)
      {
        INIZIALIZZA(tre);
        INPUT(uno);
        INPUT(due);
        TRANSFER(uno, due, tre);
        PRINT(uno, due, tre);

        printf("\nVuoi eseguire il programma?\t {[0] per uscire}\t");
        scanf("%d", &flaggo);
        flag=flaggo;
      }
return(0);
  }

//Programma funzionante
