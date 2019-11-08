// file item.h 

// item è il tipo generico ed è definito come puntatore a void

typedef void *item;

#define NULLITEM NULL


/* le variabili di tipo gen_func sono struct contenenti tre puntatori a funzione
per confrontare due item (cmpItem), per fare l'input di un item e per fare l'output di un item.

A tali puntatori vanno assegnati gli indirizzi delle funzioni degli item specifici che saranno 
usati a run-time da altre funzioni, come gli operatori della lista 

I parametri di queste funzioni dovranno essere corrispondenti ai parametri della dichiarazione 
dei puntatori a funzione */


typedef struct item_func {
     int (*cmpItem)(item x, item y);
     item (*inputItem)(void);
     void (*outputItem)(item x);
} gen_func;

