# Immaginiamo che un pacco venga inviato all'ufficio postale:
# il pacco può essere ordinato, poi spedito all'ufficio postale
# e quindi ricevuto dal destinatario.
# 
# Vogliamo scrivere il suo stato ogni volta che questo cambia:
# lo stato iniziale è ordinato. La classe Pacco ha il metodo
# _succ per passare allo stato successivo e _pred per passare
# a quello precedente. Lo stato ordinato non ha stati che lo
# precedono; lo stato ricevuto non ha stati che vengono dopo
# di esso.
# 
# L'approccio più semplice sarebbe di aggiungere del flag booleani
# e applicare dei semplici statement if/else all'interno di ciascun
# metodo. Ciò complicherebbe il nostro codice quando abbiamo più stati
# da considerare negli if/else.
# 
# Inoltre, la logica per tutti gli stati sarebbe disseminata tra tutti
# i metodi. Usiamo quindi l'approccio state-specific.

class Pacco:
    _states = ["ORDINATO", "SPEDITO", "RICEVUTO"]
    ORDINATO, SPEDITO, RICEVUTO =   [0, 1, 2]

    def __init__(self):
        self._state = 0
        self.state = Pacco.ORDINATO

    @property
    def state(self):
        return self._state


    @state.setter 
    def state(self, newState):
        self._state += newState
        if newState == Pacco.ORDINATO:
            self.succ = self._succ
            self.prec = lambda *args: print("Non vi sono stati precedenti")
            self.stampaStato = lambda *args: print("Il pacco e` stato ordinato ma non ancora spedito")
        
        elif newState == Pacco.SPEDITO:
            self.succ = self._succ
            self.prec = self._prec
            self.stampaStato = lambda *args: print("Il pacco e` stato spedito ma non ancora ricevuto")

        elif newState == Pacco.RICEVUTO:
            self.succ = lambda *args: print("Il pacco e` gia` stato ricevuto")
            self.prec = self._prec
            self.stampaStato = lambda *args: print("Il pacco e` stato ricevuto")


    def _succ(self):
        self.state += 1


    def _prec(self):
        self.state -= 1


def main():
    print("\nCreo il pacco")
    pacco=Pacco()
    pacco.stampaStato()
    print("\nInoltro il pacco all'ufficio postale")
    pacco.succ()
    pacco.stampaStato()
    print("\nConsegno il pacco al destinatario")
    pacco.succ()
    pacco.stampaStato()
    print("\nProvo a passare ad uno stato successivo")
    pacco.succ()
    pacco.stampaStato()

if __name__== "__main__":
	main()