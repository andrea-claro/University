/*-------------------------LIBRERIE--------------------------------------------------------------*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
/*-------------------------STRUTTURA-------------------------------------------------------------*/
typedef struct camera{
	int is_booked,
	    cesso;
	char *nome_prenotazione,
	     *codice_camera;
	float prezzo;
}camera;
/*-------------------------MAIN------------------------------------------------------------------*/
int main(){
camera **hotel;
int quantita_camere;
char nome[32];

printf("\ninserisci quantita camere dell'hotel:\t");
scanf("%d", &quantita_camere);

hotel=calloc(quantita_camere, sizeof(camera *));
//*hotel=calloc(quantita_camere, sizeof(camera));

for(int k=0;k<quantita_camere;k++){
	*(hotel+k)=calloc(1, sizeof(camera));
	
	printf("la camera e' prenotata?\t [0]=no [1]=si");
	scanf("%d", &(*(hotel+k))->is_booked);

	printf("la camera ha un bagno?\t [0]=no [1]=si");
	scanf("%d", &(*(hotel+k))->cesso);
	
	hotel[k]->codice_camera=calloc(32, sizeof(char));
	printf("inserire codice camera:\t");
	scanf("%s", hotel[k]->codice_camera);

	printf("inserisci prezzo camera:\t");
	scanf("%f", &(*(hotel+k))->prezzo);
	if(hotel[k]->is_booked){
		printf("Come si chiama chi ha prenotato?\t");
		scanf("%s", nome);
		
		hotel[k]->nome_prenotazione=calloc((strlen(nome)), sizeof(char));
		strcpy((hotel[k]->nome_prenotazione), nome);
		}
	}
for(int k=0;k<quantita_camere;k++){
	printf("\nla camera risulta con prenotazione:\t%d", hotel[k]->is_booked);
	printf("\nla camera risulta con bagno:\t%d", hotel[k]->cesso);
	printf("\nil codice camera risulta:\t%s", hotel[k]->codice_camera);
	printf("\nil prezzo risulta:\t%f", hotel[k]->prezzo);
	printf("\nil nome di chi ha prenotato risulta:\t%s", hotel[k]->nome_prenotazione);
	printf("\n\n");
	}
}


