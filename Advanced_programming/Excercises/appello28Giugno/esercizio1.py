#Scrivere nel file esercizio1.py una funzione generatrice
# myGenerator(n) che prende in input un intero n>=1 e
# restituisce un iteratore dei primi n fattoriali. In altre
# parole, la prima volta che viene invocato next viene restituito
# 1!, la seconda volta 2!, la terza volta 3!, e così via
# fino ad n!.
#All'esercizio verrà assegnato un bonus se la funzione generatrice
# sarà definita ricorsivamente. È possibile scrivere una funzione
# generatrice ricorsiva che prende in input più parametri e che
# poi viene opportunamente invocata da myGenerator

def fact(n):
    if n == 0:
        return 1
    else:
        return n * fact(n-1)

def myGenerator(n):
    if n >= 1:
        for k in range(1, n+1):
            yield fact(k)
    else:
        raise ValueError('Il valore passato è inferiore ad 1')

for k in myGenerator(3):
    print(k)

print()

# import functools
#
#
# def fattoriale(n):
#
#     result = []
#
#     def gen(n):
#         if n == 1:
#             result.append(1)
#             yield 1
#         else:
#             yield from gen(n-1)
#             x = result.pop()*n
#             result.append(x)
#             yield x
#
#     return gen(n)
#
#
# gen = fattoriale(5)
#
# print(next(gen))
# print(next(gen))
# print(next(gen))
# print(next(gen))
# print(next(gen))



def myGeneratorAux(n, c, p):
    if n == 1:
        yield p
    else:
        yield p
        c+= 1
        p*= c
        yield from myGeneratorAux(n-1, c, p)

def myGenerator(n):
    return myGeneratorAux(n, 1, 1)

if __name__ == '__main__':
    print("I primi 6 fattoriali sono: ")
    for x in myGenerator(6):
        print(x)