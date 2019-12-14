"""Scrivere nel file esercizio2.py il decoratore di funzione decoratore che trasforma in interi gli argomenti
non keyword della funzione decorata utilizzando int(); se un argomento non e`trasformabile in intero con int()
allora la funzione stampa "L'argomento {} non puo` essere convertito"e lo fa per ogni argomento non convertibile.
Nel caso in cui la conversione di tutti gli argomenti non keyword vada a buon fine, il  decoratore
deve stampare il risultato della funzione invocata con gli argomenti non keyword convertiti in interi.
Le docstring delle funzioni decorate non devono essere modificate dal decoratore."""
import functools


def decoratore(function):
    @functools.wraps(function)

    def wrapper(args=[], kwargs={}):

        def stampa(argomento):
            print("L'argomento {} non puo` essere convertito".format(argomento))

        interi = []
        convert = False
        for i in range(0, len(args)):

            try:
                interi.append(int(args[i]))
            except:
                interi.append(args[i])

            if not isinstance(interi[i], int):
                stampa(interi[i])
                convert = True
        else:
            if not convert:
                function(args, kwargs)

    return wrapper


@decoratore
def funzione(*args, **kwargs):
    print("Ho convertito tutti gli argomenti {}".format(args, kwargs))


funzione([1, 2, 3, "4", "5", 6])