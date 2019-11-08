#include <stdio.h>
#include <stdlib.h>
#include "item.h"
#include "list.h"




/* la struct c_list contiene un campo di tipo gen_func in cui memorizza i puntatori 
alle funzioni del tipo item specifico (es. item-int o item-char) su cui lavorare 
Tale campo viene inizializzato dal costruttore newList con il valore del parametro di
ingresso del costruttore */



struct c_list {
     struct node *first;
     int size;
     gen_func gf;
};

struct node {
     item value;
     struct node *next;
};


list newList(gen_func fn) 
{
  struct c_list *l;
  
  l = malloc (sizeof(struct c_list));
  
  if (l != NULL) {
    l->first = NULL;
  	l->size = 0;
  	l->gf.cmpItem = fn.cmpItem;
  	l->gf.inputItem = fn.inputItem;
  	l->gf.outputItem = fn.outputItem;
  }
  return l;   
// il programma client dovrà controllare che il risultato non sia NULL  
}



/* la definizione degli operatori emptyList, sizeList, getItem, insertList e removeList
non cambia rispetto alla versione di lista non generica, perché non usano gli operatori
dell'item. Allo stesso modo, non cambiano eventuali implementazioni di reverseList, 
cloneList e deleteList */


int emptyList(list l)
{
  if(l == NULL)
    return -1;
  return (l->size == 0);
} 


int sizeList (list l)
{
  if(l == NULL)
    return -1;
  return l->size;
}


item getItem (list l, int pos)
{
  if(l == NULL)
    return NULLITEM;
  
  if (pos<0 || pos>=l->size)
        return NULLITEM;
        
  struct node *temp = l->first;
  int i =0;

  while (i < pos){
      i++;
      temp=temp->next;
  }
  
  return temp->value;
}



static struct node* makeNode(item val, struct node* n)
{
      struct node *nuovo = malloc (sizeof(struct node));
      
      if (nuovo != NULL) {
     	    nuovo->value = val;
        	nuovo->next = n;
	    }

      return nuovo;
}


static struct node* insertNode(struct node* n, int pos, item val)
{
     
	  if(pos == 0)          // inserimento in posizione 0
        return makeNode(val, n);

	  int i = 0;
	  struct node* prec = n;         
    while (i < pos-1) {   
        prec = prec->next;
        i++;
    }
    
    struct node* n1 = makeNode(val, prec->next);
    if(n1 == NULL) 
        return NULL;

    prec->next = n1;
    return n;  
}

int insertList (list l, int pos, item val)
{
  if(l == NULL)
     return 0;
  if (pos<0 || pos>l->size) 
     return 0;
    
  struct node* tmp= insertNode(l->first, pos, val);
  if(tmp==NULL) 
     return 0;
    
  l->first = tmp;
  l->size++;
  return 1;                            
}


static struct node* removeNode(struct node* n, int pos)
{     
    struct node* n1;    // puntatore al nodo da eliminare

    if(pos == 0) {       // eliminazione in posizione 0
        n1 = n;
        n = n->next;
        free(n1);
    }
    else {
        int i = 0;
        struct node* prec = n;         
        while (i < pos-1) {   
            prec = prec->next;
            i++;
        }
        n1 = prec->next;
        prec->next = n1->next;
        free(n1); 
      }

	  return n; 
}


int removeList (list l, int pos)
{   
  if(l == NULL)
     return 0;
    
  if (pos<0 || pos>=l->size)
     return 0; 
      
  l->first = removeNode(l->first,pos);
  l->size--;
  return 1;
}
  

/* la definizione di posItem cambia. Adesso per confrontare due item si usa il puntatore alla
funzione di confronto, in modo da rendere l'implementazione indipendente dall'effettivo tipo 
degli item (generica), stabilendo a run-time quale funzione usare */



int posItem (list l, item val)
{
  if(l == NULL)
    return -1;
  int pos = 0;
  int found = 0;
  struct node *temp = l->first;

  while (temp!=NULL && !found)
      {
      /* il test di confronto nell'if viene fatto usando il puntatore cmpItem alla funzione 
         di confronto, rendendo generica l'implementazione */
        
          if (l->gf.cmpItem(temp->value, val) == 0)  // modifica rispetto a versione non generica
              found = 1;
          else {
              temp=temp->next;
              pos++;
              }
      }
  if(!found)
      	 pos = -1;
  return pos;
}



int outputList (list l)
{
  if(l == NULL) return 0;

  int i =0;
  item val; 
  printf("Numero elementi: %d\n",l->size);
  struct node* n=l->first;
  while(n!=NULL) {
          val = n->value;
          printf("Elemento di posizione %d: ", i);  
          
        /* l'output dell'item fatto usando il puntatore outputItem alla funzione  
        di output, rendendo generica l'implementazione */

          l->gf.outputItem(val);  // modifica rispetto a versione non generica
          
          printf("\n");
          n = n->next;
          i++;
  } 
  return 1;
}


list inputList (int n, gen_func fn)
{
	 list l = newList(fn); 
	 
	 if(l == NULL) return l;

     if(n <= 0) return l;

     item val; 
     
     printf("Elemento di posizione 0: ");  
     
    /* l'input dell'item fatto usando il puntatore inputItem alla funzione  
    di input, rendendo generica l'implementazione */

     
     val = l->gf.inputItem();  // modifica rispetto a versione non generica
     
     if(val == NULLITEM) return l;
     
     l->first = makeNode(val, NULL); // inserimento primo elemento 

	 if(l->first == NULL) return l;

     struct node *temp = l->first;       // puntatore all’ultimo nodo di l      
     
     int i = 1;
     int ok = 1; 
	 
     while(i < n && ok) {
        printf("Elemento di posizione %d: ", i);  
        
        val = l->gf.inputItem();  // modifica rispetto a versione non generica
        if (val == NULLITEM) 
        	ok = 0;
        else {	
        	temp->next = makeNode(val, NULL);
        	if (temp->next == NULL)
        		ok = 0;      		
        	else {
        		temp = temp->next;
        		i++;
        		}
        	}
      }  

     l->size = n;
     return l;
}    




