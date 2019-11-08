#Scrivere una funzione che prende in input un intero positivo
#ne restituisce e produce un generatore degli interi
#0, 1, 3, 6, 10, .. In altre parole, l’i-esimo elemento
#e`(0 + 1 + 2 + ... + i-1)

def gen(n):
    x= 0
    for k in range (0, n):
        x+= k
        yield x

for k in gen(5):
    print(k)