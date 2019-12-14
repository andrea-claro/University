#Scrivere nel file esercizio1.py una coroutine selezionatore(n,ricevitore)
# che prende in input un intero n e una coroutine ricevitore e si comporta
# come segue: ogni volta che riceve un testo, cerca al suo interno le stringhe
# di lunghezza maggiore di n e le invia al ricevitore. Scrivere inoltre una
# coroutine archivista(archivio) che ogni volta che riceve una stringa la
# inserisce nel file di nome archivio seguita da uno spazio. Il parametro
# ricevitore e` una coroutine archivista.
# Suggerimento: potete usare re.findall(r'\w+', testo) per estrarre parole da testo.
import functools
import re

def coroutine(function):
    @functools.wraps(function)
    def wrapper(*args, **kwargs):
        generator = function(*args, **kwargs)
        next(generator)
        return generator
    return wrapper


@coroutine
def selezionatore(n, ricevitore):
    while(True):
        testo = (yield)
        parole = re.findall(r'\w+', testo)
        for parola in parole:
            if len(parola) > n:
                ricevitore.send(parola)

@coroutine
def archivista(archivio):
    while (True):
        parola = (yield)
        with open(archivio, "a") as f:
            f.write(parola+" ")


x= selezionatore(4, archivista("testox"))
x.send("ciao sono Andrea e mi chiamo così perchè lo ha voluto mamma. In ogni caso sono bello ma spaccio e ho forse finito questo esercizio")
