#Scrivere una funzione ricorsiva SommaRic(L, x), che somma gli elementi
#di una lista di numeri L a partire dalla testa e fino a che non incontra
# x(escluso dalla somma). Se x non e` nella lista, la funzione somma tutti
# i numeri della lista. La funzione deve restituire il valore della somma
# computata e deve smettere di effetturare chiamate ricorsive, non appena
#incontra x

def sommaRic(x, l=[]):
    c = 0
    if len(l) == 0:
        return c
    y, *w= l
    if y != x:
        c+= y
        c+= sommaRic(x, w)
    return c


print(sommaRic(5, [1,3,5,7]))
#Scrivere una funzione myGenerator(CL, CN), che prende in input una
#collezione CL (lista o tupla) di liste e una collezione CN (lista o tupla)
#di numeri e restituisce un iteratore dei valori
# sommaRic(L1, x1),
# sommaRic(L1, x1)*sommaRic(L2, x2),
# sommaRic(L1, x1)*sommaRic(L2, x2)*sommaRic(L3, x3),
# sommaRic(L1, x1)*sommaRic(L2, x2)*sommaRic(L3, x3)*sommaRic(L4, x4) e cosi` via.
#
#dove L1, L2, L3, L4 sono le liste all'interno di CL e x1, x2, x3, x4 sono i numeri
#all'interno di CN. Si puo` assumere che CL e CN abbiano uguale lunghezza


def myGenerator(CL=[], CN=[]):
    for x, y in zip(CL, CN):
        yield sommaRic(y, x)


for i in myGenerator([[1, 2, 4], [5, 6, 8], [9]], [1, 4, 6]):
    print(i)