# include <stdio.h>
# include <stdlib.h>
# include "item.h"
# include "item-int.h"
# include "item-string.h"
# include "list.h"


/* funzioni usate per semplificare e rendere più leggibile il codice del main 
Ogni funzione corrisponde ad una delle operazioni del menu del main */


/* carica_lista ha bisogno del parametro di tipo gen_func da passare a input_list */

list carica_lista(gen_func gf)
{ 
	int tipo, n;
	list l = NULL;
			
	printf("Inserisci il numero di elementi della lista: ");  
    scanf("%d", &n);    

	if(n <= 0) 
		printf("Il numero di elementi deve essere positivo \n");
	else l = inputList(n, gf);  // il parametro gf contiene i puntatori alle funzioni dell'item specifico
	   	
   	return l;
}
 


void visualizza_lista(list l)
{   	
	int n;
	
	if(l == NULL) 
		printf("\n lista NULL \n");
	else {		
   		n = sizeList(l);
   	
   		printf("\n");
   		printf("Elementi della lista di dimensione: %d \n", n);
		outputList(l);
	}
}



/* ricerca_lista ha bisogno di un parametro di tipo gen_func contenente il puntatore inputItem
alla  funzione di input dell'item specifico */

void ricerca_lista(list l, gen_func gf)
{   	
	if(l == NULL) return;

	printf("Dammi l'elemento da cercare: ");

    /* facciamo l'input dell'elemento da cercare usando il puntatore inputItem contenuto nella struct gf
    Attraverso inputItem accediamo alla funzione di input specifica per gli elementi della lista */
	
	item x = gf.inputItem();  
	
	int m = posItem (l, x);
	printf("Posizione dell'elemento cercato: %d \n", m);
}	


/* visualizza_item ha bisogno di un parametro di tipo gen_func contenente il puntatore outputItem
alla  funzione di output dell'item specifico */


void visualizza_item(list l, gen_func gf)
{   	
	if(l == NULL) return;
	
	int m;
	printf("Dammi la posizione di un elemento: "); 
    scanf("%d", &m);        

	if(m < 0 || m > sizeList(l)-1) 
		printf("Posizione non corretta \n");
	else {
	       item x = getItem(l, m);
	       printf("Elemento di posizione %d: ", m);

    /* facciamo l'output dell'elemento usando il puntatore outputItem contenuto nella struct gf
    Attraverso outputItem accediamo alla funzione di output specifica per gli elementi della lista */
	       
	       gf.outputItem(x);
	       
	       printf("\n");
	     }
}	


/* inserisci_lista ha bisogno di un parametro di tipo gen_func contenente il puntatore inputItem
alla  funzione di input dell'item specifico */


void inserisci_lista(list l, gen_func gf)
{   	
	if(l == NULL) return;
	
	int m;

	printf("Inserisci la posizione di un nuovo elemento: ");  
    scanf("%d", &m); 
    
    if(m < 0 || m > sizeList(l))   
    	printf("Posizione non corretta \n");
    else {
    	printf("Nuovo elemento: ");
    	
    /* facciamo l'input dell'elemento da inserire usando il puntatore inputItem contenuto nella struct gf
    Attraverso inputItem accediamo alla funzione di input specifica per gli elementi della lista */
    	
		item x = gf.inputItem();
		
    	insertList(l, m, x);   
    	printf("Elemento inserito \n");   
	}
}


  
void elimina_lista(list l)
{   	
	if(l == NULL) return;
	
	int m;

	printf("Posizione elemento da eliminare: ");  
    scanf("%d", &m);    
    if(m < 0 || m > sizeList(l)-1)   
    	printf("Posizione non corretta \n");   
    else {
    	removeList(l, m); 
    	printf("Elemento eliminato \n");       
	}	
}
  


int main() 
{ 
	list l;
    int tipo, scelta;
    gen_func gf;

  
	printf("Scegli il tipo di lista \n");
	printf("Lista di interi:   0  \n");
	printf("Lista di stringhe: 1  \n \n");
	printf("Scelta: ");
	scanf("%d", &tipo);
	
	if (tipo == 0)
		gf = getIntFunc();
	else gf = getCharFunc();

	l = carica_lista(gf);
	

	do { 
		printf("Scegli una operazione \n \n");
		printf("Visualizzazione Lista:                   1 \n");
		printf("Ricerca posizione elemento:              2 \n");
		printf("Visualizza elemento in base a posizione: 3 \n");
		printf("Inserimento elemento in posizione:       4 \n");
		printf("Cancellazione elemento data posizione:   5 \n");		
		printf("Termina e esci dal programma: 			 0 \n\n");
		
		printf("Scelta: ");
		scanf("%d", &scelta);
		
		switch(scelta) {
			case 1: visualizza_lista(l);
					break;
			case 2: ricerca_lista(l, gf);
					break;
			case 3: visualizza_item(l, gf);
					break;
			case 4: inserisci_lista(l, gf);
					break;
			case 5:	elimina_lista(l);
			}	
		printf("\n \n");
		}		
	while(scelta != 0);
	

		

/*	printf("Reverse della lista \n");
	reverseList2(l);
	outputList(l); 
*/

}