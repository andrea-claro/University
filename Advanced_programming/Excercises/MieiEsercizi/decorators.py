# Creare un decoratore di classe per far si che la classe di partenza sia modificata in modo
# da creare un dizionario interno contenente tutti gli attributi e i valori della classe.

def decoratorDictionary(cls):
    def decorator(*args, **kwargs):
        diz= dict()
        for i in range(len(args)):
            diz[i] = args[i]
        setattr(cls, "diz", diz)
        return cls(*args, **kwargs)
    return decorator

@decoratorDictionary
class Test:

    def __init__(self, *args, **kwargs):
        self._a = args[0]
        self._b = args[1]
        self._c = args[2]

# Creare un decoratore di funzione che per ogni elemento passato come dizionario alla funzione stampa la 
# coppia chiave valore singolarmente

import functools 

def decoratorPrint(funz):
    @functools.wraps(funz)
    def wrapper(*args, **kwargs):
        for el in args:
            for key in el:
                print(key, el[key])
        funz(*args, **kwargs)
    return wrapper

@decoratorPrint
def func(diz = {}):
    print(f"stampa effettuata di {diz}")

print()
print("-------------------- Decoratore di classe: -----------------------")
a= Test(1, "ciao", [1, 2, "ciao", ["fanculo"]])
print(a.diz)
print("-------------------- Decoratore di funzione: ---------------------")
func(a.diz)