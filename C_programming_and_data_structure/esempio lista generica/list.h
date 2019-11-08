// file list.h

typedef struct c_list *list;

// prototipi

/* il costruttore newList prende in ingresso un parametro di tipo gen_func contenente i puntatori
alle funzioni del tipo item specifico (es. item-int o item-char) su cui lavorare */


list newList(gen_func fn);

int emptyList(list l);

int sizeList (list l);

item getItem (list l, int pos);

int insertList (list l, int pos, item val);

int removeList (list l, int pos);


int posItem (list l, item val);

int outputList (list l);

/* input list invoca il costruttore della lista (newList) e quindi deve prendere in ingresso 
un parametro di tipo gen_func contenente i puntatori alle funzioni del tipo item specifico 
da passare al costruttore della lista */

list inputList (int n, gen_func fn); 

