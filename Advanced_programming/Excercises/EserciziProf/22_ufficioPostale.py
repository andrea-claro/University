"""immaginiamo che un pacco venga inviato all'ufficio postale: il pacco può essere ordinato,poi spedito all'ufficio e quindi ricevuto dal destinatario
Vogliamo scrivere il suo stato ogni volta che questo cambia: lo stato iniziale è ordinato. La classe Pacco ha il metodo _succ per passare
allo stato successivo e _pred
# il pacco può essere odinato, spedito all'ufficio e quindi ricevuto
# vogliamo scrivere il suo stato ogni volta che esso cambia, lo stato iniziale è ordinato
# la classe Pacco ha il metodo _succ per passare allo stato successivo e _pred per passare a quello prcedente
# lo stato ordinato non ha stati che lo precedono, lo stato ricevuto non ha stati che vengono dopo"""

class Pacco:
    STATE = ["ORDINATO", "SPEDITO", "RICEVUTO"]
    ORDINATO, SPEDITO, RICEVUTO = [0, 1, 2]

    def __init__(self):
        self._state = 0
        self.state = Pacco.ORDINATO

    def _succ(self):
        if self._state == 2:
            print("Il pacco e` gia` stato ricevuto")
        else:
            self._state = self._state+1

    def _prec(self):
        if self._state == 0:
            print("Il pacco non ha stati predecessori")
        else:
            self._state = self._state-1

    def stampaStato(self):
        if self._state == Pacco.ORDINATO:
            print("Il pacco e` stato ordinato ma non ancora spedito")
        elif self._state == Pacco.SPEDITO:
            print("Il pacco e` stato spedito ma non ancora ricevuto")
        elif self._state == Pacco.RICEVUTO:
            print("Il pacco e` stato ricevuto ")
    @property
    def state(self):
        return self._state

    @state.setter
    def state(self, newState):
        if newState == Pacco.ORDINATO:
            self.succ = self._succ
            self.prec = self._prec
        elif newState == Pacco.SPEDITO:
            self.succ = self._succ
            self.prec = self._prec
        elif newState == Pacco.RICEVUTO:
            self.succ = self._succ
            self.prec = self._prec
        else:
            print("Il pacco ha uno strano stato")

    def next(self):
        self._succ()




def main():
    print("\nCreo il pacco")
    pacco = Pacco()
    pacco.stampaStato()
    print("\nInoltro il pacco all'ufficio postale")
    pacco.next()
    pacco.stampaStato()
    print("\nConsegno il pacco al destinatario")
    pacco.next()
    pacco.stampaStato()
    print("\nProvo a passare ad uno stato successivo")
    pacco.next()
    pacco.stampaStato()

if __name__== "__main__":
	main()


"""Il  programma deve stampare:
Creo il pacco
Il pacco e` stato ordinato ma non ancora spedito

Inoltro il pacco all'ufficio postale
Il pacco e` stato spedito ma non ancora ricevuto

Consegno il pacco al destinatario
Il pacco e` stato ricevuto 

Provo a passare ad uno stato successivo
Il pacco e` gia` stato ricevuto
Il pacco e` stato ricevuto 
"""
