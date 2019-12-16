"""Scrivere un programma che gestisce una camera di hotel; 
in particolare la camera ha due attributi; prenotabile 
(booleano settato a True se prenotabile e a False altrimenti); 
in particolare questo attributo dovrà essere gestito attraverso 
l'invocazione del metodo libera() e occupa() con un approccio 
state-specific; che stampa un messaggio di errore se si prova 
ad occupare una stanza già occupata; e prezzo (intero). 
Scrivere due observer, BookingObserver, che stampa un messaggio quando 
c'è cambiamento di stato dell'attributo prenotabile e PriceObserver 
che stampa un messaggio quando cambia il prezzo della camera."""
import itertools

class Observer:

    def __init__(self):
        self.__observers = set()

    def observers_add(self, observer, *observers):
        for observer in itertools.chain((observer,), observers):
            self.__observers.add(observer)
            observer.update(None)

    def observer_discard(self, observer):
        self.__observers.discard(observer)

    def observers_notify(self, ob):
        for observer in self.__observers:
            observer.update(ob)

class Camera(Observer):

    STATE = ["PRENOTABILE", "NPRENOTABILE"]
    PRENOTABILE, NPRENOTABILE = [0, 1] 

    def __init__(self, prezzo = 0):
        super().__init__()
        self._state = Camera.PRENOTABILE
        self._prezzo = prezzo

    @property
    def state(self):
        return self._state

    @state.setter
    def state(self, value):
        if value == 0:
            self.libera()
        elif value == 1:
            self.occupa()
        else:
            pass
        self.observers_notify(self)

    def libera(self):
        if self.state == Camera.NPRENOTABILE:
            self._state = Camera.PRENOTABILE

    def occupa(self):
        if self.state == Camera.PRENOTABILE:
            self._state = Camera.NPRENOTABILE
            
    @property
    def prezzo(self):
        return self._prezzo

    @prezzo.setter
    def prezzo(self, price):
        self._prezzo = price
        self.observers_notify(self)


class BookingObserver:

    def __init__(self):
        self._datiPrenotazione = []

    def update(self, obj):
        if obj is  not None:
            self._datiPrenotazione.append([Camera.STATE[obj.state], obj.prezzo])
            print(self._datiPrenotazione)

class PriceObserver:
    def __init__(self):
        self._datiPrezzo = []
        
    def update(self, obj):
        if obj is not None:
            self._datiPrezzo.append([Camera.STATE[obj.state], obj.prezzo])
            print(self._datiPrezzo)


x = Camera()
print(x.state)
print(x.prezzo)
print("######################################")
a = BookingObserver()
b = PriceObserver()
x.observers_add(a, b)
x.state = 1
x.prezzo = 10
