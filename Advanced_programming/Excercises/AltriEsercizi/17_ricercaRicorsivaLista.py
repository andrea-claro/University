#Scrivere una funzione ricorsiva che prende in input una lista e un elemento x.
# La funzione restituisce True non appena trova x nella lista. Se x non e`nella
# lista, la funzione restituisce False


def ricercaRicorsiva(x, l=[]):
    bool= False
    if len(l) == 0:
        return bool
    y, *w= l
    if(y != x):
        return ricercaRicorsiva(x, w)
    else:
        bool= True
    return bool


print(ricercaRicorsiva(6, [1, 2, 4, 6]))