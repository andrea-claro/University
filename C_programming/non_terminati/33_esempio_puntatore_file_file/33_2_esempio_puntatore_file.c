#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct cittadino{
	int flag_donna;
	char cognome[20];
	char nome[20];
	char luogo[20];
	int anno;
}cittadino;

void controllo_input(int);
void new_aggiorna (cittadino *);
void controllo_file (FILE *, char *);
cittadino * new_rec(char *[]);
int conta_in_file (FILE *);
void append_file(FILE *, cittadino *);
void copia_da_file(FILE *, cittadino *);
void scrivi_in_file_donna(FILE *, cittadino *, int);
void stampa(cittadino *);

int main (int argc, char *argv[]){

FILE *uno, *due;
char *info[]={"Verde","Luisa","Napoli"};
cittadino *rec, *records;
int num_rec;

controllo_input(argc);

uno=fopen(argv[1], "r+");
controllo_file(uno, argv[1]);
due=fopen(argv[2], "w");
controllo_file(due, argv[2]);

rec=new_rec(info);
num_rec=conta_in_file(uno);

if(rec){
	num_rec++;
	append_file(uno,rec);
	records=calloc(num_rec,sizeof(cittadino));
	}
	
else
	records=calloc(num_rec,sizeof(cittadino));

rewind(uno);
copia_da_file(uno,records);
scrivi_in_file_donna(due,records,num_rec);

fclose(uno);
fclose(due);
free(records);

return 0;
}

cittadino *new_rec(char *data[]){

cittadino *new;
char risposta;

printf("Vuoi inserire il cittadino %s?\tSI=s\tNO=n\n", data[0]);
scanf("%s", &risposta);

if (risposta== 'n')
	return NULL;
	
new=malloc(sizeof(cittadino));
strcpy(new->cognome, data [0]);
strcpy(new->nome, data [1]);
strcpy(new->luogo, data[2]);

printf("Inserisci anno di nascita\n");
scanf("%d", &new->anno);
new->flag_donna=1;

return new;
}

int conta_in_file (FILE *in){

int num=0;
cittadino vect;

while(fscanf(in, "%d %s %s %s %d", &vect.flag_donna, vect.cognome, vect.nome, vect.luogo, 		&vect.anno)!=EOF)
	num ++;

	return num;
}

void append_file(FILE *in, cittadino *vect){

fflush(in);
fprintf(in,"%d %s %s %s %d\n", vect->flag_donna, vect->cognome, vect->nome, vect->luogo, vect->anno);
}

void copia_da_file(FILE *in, cittadino *vect){

int i=0;

while(fscanf(in, "%d %s %s %s %d", &vect[i].flag_donna, vect[i].cognome, vect[i].nome, vect[i].luogo, 		&vect[i].anno)!=EOF)

	i++;
}

void scrivi_in_file_donna(FILE *out, cittadino *vect, int size){

int i;

for(i=0; i<size; i++)
	if(vect[i].flag_donna)
		fprintf(out, "%s %s %s %d\n", vect[i].cognome, vect[i].nome, vect[i].luogo, 				vect[i].anno);
}

/*void stampa (cittadino *rec){
printf("%d\t%s\t\t%s\t\t%s\t\t");
}*/
