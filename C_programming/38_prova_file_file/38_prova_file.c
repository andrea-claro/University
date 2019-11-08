/******************************************************************************************
*Esempio: Scrivere un programma in C che presi in input due file, denominati fileuno e filedue
*contenenti caratteri minuscoli, copi il contenuto di filedue in coda a fileuno, e successivamente *crei un nuovo file, il cui nome è inserito dall’utente, in cui sia copiato il contenuto di fileuno *invertendo le minuscole con le maiuscole.
*******************************************************************************************/

/*------------------------LIBRERIE--------------------------------------------------------*/
#include <stdio.h>
#include <stdlib.h>
/*------------------------PROTOTIPI-------------------------------------------------------*/
int controllo_input(int);
void controllo_file(FILE *, char *);
int append_file(FILE *, FILE *);
int converti_maiuscole(char *);

/*--------------------------MAIN---------------------------------------------------------*/
int main(int argc, char *argv[])
{

FILE *uno, *due;

controllo_input(argc);

uno=fopen(argv[1],"a");
controllo_file(uno,argv[1]);
due=fopen(argv[2],"r");
controllo_file(due,argv[2]);

if(append_file(uno,due))
	printf("La scrittura è OK\n");

else
	printf("La scrittura non è avvenuta\n");

if(converti_maiuscole(argv[1]));
	printf("La conversione è OK\n");

return 0;
}
/*----------------------------CONTROLLO---------------------------------------------------*/
void controllo_file(FILE *file, char *stringa)
{

if(file!=NULL)
	printf("%s è stato aperto correttamente\n", stringa);

else
	exit(1);

}
/*------------------------SCRITTURA--------------------------------------------------------*/
int append_file(FILE *f1, FILE *f2)
{

int c;

while((c=getc(f2))!=EOF)
	putc(c,f1);

fclose(f1);
fclose(f2);

return(1);
}
/*------------------------CONVERSIONE------------------------------------------------------*/
int converti_maiuscole (char *stringa)
{

char nome[10]; int c;
FILE *tre, *f1;

printf("Inserisci il nome file\n");
scanf("%s",nome);

tre=fopen(nome,"wb");
controllo_file(tre,nome);

f1=fopen(stringa,"r");
controllo_file(f1,stringa);

while((c=getc(f1))!=EOF)
	if(c!=' ')
		putc(c-32,tre);

	else
		putc(c,tre);

fclose(tre);
fclose(f1);

return (1);
}
/*-----------------------CONTROLLO PAROLA--------------------------------------------------*/
int controllo_input (int n){

if(n!=3){
	printf("Il programma apre due file denominati fileuno e filedue\n");
	printf("preceduti dal nome programma: il risultato sarà la concatenazione\n");
	printf("dei due file memorizzata in fileuno. Successivamente il contenuto\n");
	printf("di fileuno verrà copiato in un file nuovo, il cui nome verrà deciso\n");
	printf("dall'utente, convertendo le minuscole in maiuscole\n");

exit(1);
}
else
return 0;
}
