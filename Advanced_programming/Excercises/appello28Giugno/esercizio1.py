"""Scrivere nel file esercizio1.py una funzione che prende in  input una sequenza di
richieste (liste di due interi) e passa ciascuna richiesta  ad una catena di  gestori ciascuno dei quali e` una coroutine.
    •Se il primo intero della lista e` nell’intervallo [0,4] allora la richiesta viene gestita dal gestore Handler_04che
        stampa “Richiesta {} gestita da Handler_04“.
    •Se il primo intero della listae` nell’intervallo [5,9] allora la richiesta viene gestita dal gestore Handler_59che
        stampa “Richiesta {} gestita da Handler_59“.
    •Se il primo intero della lista e` maggioredi 9 allora la richiesta viene gestita dal gestore Handler_gt9 che
        stampa “Messaggio daHandler_gt9: non e` stato possibile gestire la richiesta{}. Richiesta modificata".
        Dopo aver effettuato la stampa Handler_gt9 sottrae al primo intero della lista il secondo intero della lista e
        lo invia nuovamente ad una nuova catena di gestori.
    •Se il primo intero della lista e` minore di 0 la richiesta viene gestita da Default_Handler che
        stampa semplicemente “Richiesta {} gestita da Default_Handler: non e` stato possibile gestire la
        richiesta{}”.
Nelle suddette stampe  la lista nella  richiesta deve comparire al posto delle parentesi graffe."""
import functools


# class Null_Handler:
#
#     def __init__(self, successor=None):
#         self._successor = successor
#
#     def handling(self, event):
#         if self._successor is not None:
#             self._successor.handling(event)
#
#
# class Handler_04(Null_Handler):
#
#     def handling(self, request):
#         if request[0] in range(0, 4):
#             print("Richiesta {} gestita dal gestore Handler_04".format(request))
#         else:
#             super().handling(request)
#
#
# class Handler_59(Null_Handler):
#
#     def handling(self, request):
#         if request[0] in range(5, 9):
#             print("Richiesta {} gestita dal gestore Handler_59".format(request))
#         else:
#             super().handling(request)
#
#
# class Handler_gt9(Null_Handler):
#     def handling(self, request):
#         if request[0] > 9:
#             print("Messaggio daHandler_gt9: non e` stato possibile gestire la richiesta {}. Richiesta modificata".format(request))
#         else:
#             super().handling(request)
#
#
# class Default_Handler(Null_Handler):
#
#     def handling(self, request):
#         if request[0] < 0:
#             print("Richiesta {} gestita da Default_Handler: non e` stato possibile gestire la richiesta {}".format(request))
#         else:
#             super().handling(request)


def coroutine(function):
    @functools.wraps(function)
    def wrapper(*args, **kwargs):
        generator = function(*args, **kwargs)
        next(generator)
        return generator
    return wrapper

@coroutine
def Null_handler(successor=None):
    while(True):
        event = (yield)
        successor.send(event)

@coroutine
def Default_Handler(successor=None):
    while(True):
        event = (yield)
        if event[0] < 0:
            print("Richiesta {} gestita da Default_Handler: non e` stato possibile gestire la richiesta {}".format(event))
        else:
            successor.send(event)

@coroutine
def Handler_04(successor=None):
    while(True):
        event = (yield)
        if event[0] in range(0, 4):
            print("Richiesta {} gestita dal gestore Handler_04".format(event))
        else:
            successor.send(event)

@coroutine
def Handler_59(successor=None):
    while (True):
        event = (yield)
        if event[0] in range(5, 9):
            print("Richiesta {} gestita dal gestore Handler_59".format(event))
        else:
            successor.send(event)

@coroutine
def Handler_gt9(successor=None):
    while (True):
        event = (yield)
        if event[0] > 9:
            print("Messaggio da Handler_gt9: non e` stato possibile gestire la richiesta {}. Richiesta modificata".format(event))
        else:
            successor.send(event)

def reciever(richieste=[]):
    pipeline = Default_Handler(Handler_04(Handler_59(Handler_gt9(Null_handler))))
    for request in richieste:
        print(request)
        pipeline.send(request)

reciever([[5, 9], [10, 6], [3, 7]])