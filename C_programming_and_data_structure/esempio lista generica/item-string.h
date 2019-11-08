
/* Le funzioni inputChar, outputChar e cmpChar sono specializzazioni per le stringhe delle funzioni
per confrontare, fare l'input e l'output degli item contenuti in una struttura dati.

I parametri di queste tre funzioni corrispondono a quelli dei puntatori a funzione dichiarati
all'interno della struct di tipo gen_func.

La funzione getCharFunc restituisce una struct di tipo gen_func, dove ai tre puntatori 
a funzione sono assegnati gli indirizzi di queste tre funzioni  */


item inputChar(void);

void outputChar(item it);

int cmpChar(item it1, item it2);

gen_func getCharFunc(void);