"""Scrivere un programma in cui vi e` una classe libro che puo` essere osservata da un numero arbitrario
    di osservatori e che oltre all’attributo titolo ha i seguenti attributi che ne determinano lo stato:

    a)riferimenti: dizionario dei riferimenti presenti al suo interno. Un riferimento e` un testo citato dal libro.
        Riferimenti e` quindi un dizionario di coppie (chiave, valore) dove chiave e` un intero e valore e` un libro.
    b)numero_copie: un intero che rappresenta il numero di copie vendute
    c)alta_progressione: flag che viene settato a True se e solo se il numero di copie aumenta almeno del doppio
        rispetto al valore precedente ed e` settato a False se il numero di copie aumenta meno della meta` del
        valore precedente (ad esempio da 10 va a 14). Se numero_copie viene aggiornato in modo diverso da quelli
        indicati, il flag non viene settato. Ogni volta che questo flag viene settato viene fatta la notifica
        agli osservatori anche se il nuovo valore del flag e` uguale a quello vecchio.

Gli attributi numero_copie e alta_progressione sono accessibili con il loro nome e modificabili con ‘=‘.
Il dizionario riferimenti viene creato e riempito dal metodo__init__di Libro.
Il metodo __init__ riceve in input il titolo del libro e la lista dei libri da inserire nel dizionario riferimenti.
L’i-esimo libro della lista avra` chiave i nel dizionario.
Attenzione: le entrate del dizionario riferimenti non devono essere modificabili con ‘=’ .
Se, ad esempio,si usa l’istruzione riferimento [k]=libro allora viene lanciata l’eccezione RuntimeError.

Scrivere inoltre gli osservatoriVistaIste VistaStorica.VistaIst deve stampare
    •"Cambio stato: nuove vendite del libro \"{}\" per un totale di copie vendite pari a {} \n"se il
        cambio stato e` dovuto ad un aggiornamento di numero_copie.
    •"Cambio stato: con l'ultimo acquisto, il libro \"{}\" ha piu` che raddoppiato le vendite\n" se
        il cambio stato e` dovuto al fatto che le vendite sono raddoppiate, cioe` al fatto che alta_progressione
        e` stato settato a True (anche se era gia` True)
    •"Cambio stato: con l'ultimo acquisto, le vendite di \"{}\" sono aumentate meno della meta`\n” se il
        cambio stato e` dovuto al fatto che le vendite sono aumentate meno della meta`, cioe` al fatto che
        alta_progressione e` stato settato a False (anche se era gia` False) .
VistaStoricacrea due liste storia_venditee andamento_vendite:
    •storia_vendite e` una lista di triple della forma [titolo,numerocopie,tempo] . Ogni volta che viene
        aggiornato l’attributo numero_copie di uno dei libri osservati,viene aggiunta una tripla della forma
        [titolo,numerocopie,tempo]  a storia_vendite, dove titolo e` il titolo del libro il cui numero di copie
        e` cambiato, numerocopie e` il nuovo numero totale di copie vendute del libro e tempo e` il tempo in cui
        avviene l’aggiornamento.
    •andamento_vendite e` una lista di coppie della forma [stringa,tempo]. Ogni volta che viene
        settato alta_progressione viene inserita una coppia [stringa,tempo] in andamento_vendite,
        dove tempo e` il tempo in cui avviene l’aggiornamento e stringa e`  "Raddoppio vendite di \"{}\""se
        alta_progressione e` settato a True (anche se  era gia` True) oppure e` "Incremento delle vendite
        di \"{}\" inferiore ad un mezzo del valore precedente"se se alta_progressione e` settato a
        False (anche se  era gia` False).
VistaStorica ha anche il metodo storia()che restituisce  una lista il cui primo elemento e` la
    lista storia_vendite e il cui secondo elemento e` la lista  andamento_vendite.
Nelle suddette stampe al posto delle parentesi graffe devono comparire il nome del
libro e/oil numero di copie, a seconda dei casi.Il codice relativo alla prima parte dell’esercizio
deve essere scritto nel file esercizio3_Iparte.py. Il codice presente in esercizio3_Iparte.py
non coinvolge VistaStorica. Il codice relativo alla seconda parte dell’esercizio deve essere scritto
nel file esercizio3_IIparte.py che contiene il codice per testare VistaStorica.
La classe Libro deve essere la stessa usata nella prima parte."""
import itertools


class fruitore:

    def __init__(self, nome):
        self.nome = nome

    def compra(self, libro, num=1):
        libro.numero_copie += num

class Biblioteca(fruitore):

    def compra(self, libro):
        super().compra(libro)

class Libreria(fruitore):
    pass


class Observed:

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


class Libro(Observed):

    def __init__(self, titolo, listaLibri=[]):
        super().__init__()
        self.titolo = titolo
        self._numero_copie = 0
        self.alta_progressione = bool()  # booleano usato come controllo per gli observer
        self._riferimenti = dict() #dizionario contenente i libri che fanno riferimento al libro [chiave, valore].
        # @Chiave = indice # libro
        # @valore = nome libro che fa il riferimento
        for i in range(0, len(listaLibri)):
            self._riferimenti[i] = listaLibri[i]

    @property
    def numero_copie(self):
        return self._numero_copie

    @numero_copie.setter
    def numero_copie(self, num):
        if num >= (2*self._numero_copie):
            self.alta_progressione = True
        else:
            self.alta_progressione = False
        self._numero_copie += num
        self.observers_notify(self)

    @property
    def riferimenti(self):
        return self._riferimenti


class VistaIst:

    def __init__(self):
        pass

    def update(self, obj):
        if obj is None:
            pass
        else:
            print("Cambio stato: nuove vendite del libro {} per un totale di copie vendite pari a {} \n".format(obj.titolo, obj.numero_copie))
            if obj.alta_progressione:
                print("Cambio stato: con l'ultimo acquisto, il libro {} ha piu` che raddoppiato le vendite\n".format(obj.titolo))
            else:
                print("Cambio stato: con l'ultimo acquisto, le vendite di {} sono aumentate meno della meta \n".format(obj.titolo))


def main():
    # stessa vista per i due libri osservati
    IV = VistaIst()
    # se il vostro codice non funziona con un'univa vista di tipo VisitIst allora togliete il commento alla linea qui sotto
    # e sostituite IVbis al posto di IV nella linea 25
    # IVbis = VistaIst()
    bibliotecaCentrale = Biblioteca("Biblioteca Centrale")
    libreriaMandetori = Libreria("Libreria Mandetori")
    libreriaFaltranella = Libreria("Libreria Faltranella")
    libroCPiuPiu = Libro("C++", {})
    libroJava = Libro("Java per tutti", [libroCPiuPiu])
    libroJava.observers_add(IV)
    libroPython = Libro("Python versus Java", [libroJava, libroCPiuPiu])
    libroOOP = Libro("OOP fundamentals", [libroJava, libroPython, libroCPiuPiu])
    libroOOP.observers_add(IV)
    print("La biblioteca centrale acquisisce \"Java per tutti\"\n")
    bibliotecaCentrale.compra(libroJava)
    print(libroJava.riferimenti.items())
    print("I riferimenti di \"{}\" sono {}\n".format(libroJava.titolo, [(x, y.titolo) for x, y in libroJava.riferimenti.items()]))
    print("La libreria Faltrenella compra 199 copie di \"{}\"\n".format(libroJava.titolo))
    libreriaFaltranella.compra(libroJava, 199)
    print("La biblioteca centrale acquisisce \"{}\"\n".format(libroOOP.titolo))
    print("I riferimenti di \"{}\" sono {}\n".format(libroOOP.titolo, [(x, y.titolo) for x, y in libroOOP.riferimenti.items()]))
    print("La libreria Faltrenella compra 100 copie di \"{}\"\n".format(libroOOP.titolo))
    libreriaFaltranella.compra(libroOOP, 100)
    print("La {} compra 48 copie di  \"{}\"\n".format(libreriaMandetori.nome, libroOOP.titolo))
    libreriaMandetori.compra(libroOOP, 48)
    print("Proviamo a modificare i riferimenti di libroCPiuPiu")
    try:
        libroCPiuPiu.riferimenti[1] = libroPython
    except RuntimeError:
        print("Errore: non e` possibile modificare i riferimenti del libro\n")
    print("I riferimenti di \"{}\" sono {}\n".format(libroCPiuPiu.titolo, [(x, y.titolo) for x, y in libroCPiuPiu.riferimenti.items()]))


if __name__ == "__main__":
    main()

"""Il programma deve effettuare le segueenti stampe :

La biblioteca centrale acquisisce "Java per tutti"

Cambio stato: nuove vendite del libro "Java per tutti" per un totale di copie vendite pari a 1 

Cambio stato: con l'ultimo acquisto, il libro "Java per tutti" ha piu` che raddoppiato le vendite

I riferimenti di "Java per tutti" sono [(0, 'C++')]

La libreria Faltrenella compra 199 copie di "Java per tutti"

Cambio stato: nuove vendite del libro "Java per tutti" per un totale di copie vendite pari a 200 

Cambio stato: con l'ultimo acquisto, il libro "Java per tutti" ha piu` che raddoppiato le vendite

La biblioteca centrale acquisisce "OOP fundamentals"

I riferimenti di "OOP fundamentals" sono [(0, 'Java per tutti'), (1, 'Python versus Java'), (2, 'C++')]

La libreria Faltrenella compra 100 copie di "OOP fundamentals"

Cambio stato: nuove vendite del libro "OOP fundamentals" per un totale di copie vendite pari a 100 

Cambio stato: con l'ultimo acquisto, il libro "OOP fundamentals" ha piu` che raddoppiato le vendite

La Libreria Mandetori compra 48 copie di  "OOP fundamentals"

Cambio stato: nuove vendite del libro "OOP fundamentals" per un totale di copie vendite pari a 148 

Cambio stato: con l'ultimo acquisto, le vendite di "OOP fundamentals" sono aumentate meno della meta`

Proviamo a modificare i riferimenti di libroCPiuPiu
Errore: non e` possibile modificare i riferimenti del libro

I riferimenti di "C++" sono []
"""
