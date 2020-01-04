# Scrivere una classe FW_factory che produce istanze di oggetti FW che condividono parte dello stato
# con altri oggetti
# 
# FW_factory ha un metodo che get_fw prende in input uno stato condiviso sotto forma di lista e 
# restituisce un oggetto FW per quello stato, se già esiste o ne crea uno nuovo, ed un metodo list_FWs
# che stampa prima il numero di oggetti FW creati fino a quel momento e poi stampa gli stati relativi 
# agli oggetti FW creati.
# 
# La classe FW ha un costruttore che prende in input lo stato condiviso e lo assegna ad una variabile
# di istanza shared_state dell'oggetto FW creato.
# Inoltre FW ha un metodo op(self, itsOwnState:list, tipo:type, file) che crea un'istanza di tipo con 
# stato formato dalla concatenazione delle liste shared_state e itsOwnState. Il metodo aggiunge al file
# una liste che contiene lo stato dell'oggetto creato e stampa il suddetto stato restituendolo poi in
# output.

class FW():
    """
    FW memorizza la parte comune dello stato in SharedState 
    
    """
    __slots__ = ("sharedState")

    def __init__(self, sharedState: list):
        self.sharedState = sharedState

    """op aggiunge un oggetto oggetto al file  prendendo tutta la parte condivisa dell'auto da sharedState e il resto dal
    parametro itsOwnState"""
    
    def op(self, itsOwnState: list,tipo: type, file):
        oggetto = tipo(self.sharedState + itsOwnState)
        with open(file,"a") as f:
            f.write("stato condiviso :"+str(self.sharedState))
            f.write("stato : "+f"t{tipo} {itsOwnState}\n")
        return oggetto



class FWFactory():
    """
    Questa classe crea oggetti FW: ne crea uno nuovo se non esiste, altrimenti resituisce uno preesistente
    
    """

    _obj = {}
    def __init__(self,states):
       for state in states:
           self._obj[self.get_key(state)] = FW(state)

    def get_key(self,state):
        return "_".join(sorted(state))



    def get_FW(self, shared_state: list) -> FW:
        """
        restituisce un FW con un certo stato o ne crea uno nuovo 
        """

        key = self.get_key(shared_state)

        if not self._obj.get(key):
            print("FWFactory:  uso un FW esistente.")
            self._obj[key] = FW(shared_state)
        else:
            print("FWFactory: non trovo un FW, ne creo uno nuovo.")
        
        return self._obj[key]



    def list_FWs(self):
        """ stampa numero oggetti FW's e gli stati degli FW's"""
        print(f" Numero oggetti {len(FWFactory._obj)} e lo stato e' : {FWFactory._obj}")



class automobile:
    def __init__(self,state:list):
        self._state=state
    def state(self): return self._state
        
def add_car(factory: FWFactory, targa: str, proprietario: str,marca: str, modello: str, colore: str) :
    print("\n\nClient: Aggiungo un automobile.")
    fw = factory.get_FW([marca, modello, colore])
    
    fw.op([targa, proprietario],automobile,"Excercises/Esercizi_9_10_dicembre/automobili.txt")


if __name__ == "__main__":
    """
    The client code usually creates a bunch of pre-populated flyweights in the
    initialization stage of the application.
    """

    factory = FWFactory([
        ["Chevrolet", "Camaro2018", "rosa"],
        ["Mercedes Benz", "C300", "nera"],
        ["Mercedes Benz", "C500", "rossa"],
        ["BMW", "M5", "rossa"],
        ["BMW", "X6", "bianca"],
    ])

    factory.list_FWs()

    add_car(
        factory, "DE123AT", "Bob Bab", "BMW", "M5", "rossa")

    add_car(
        factory, "AR324SD", "Mike Smith", "BMW", "X1", "rossa")

    print("\n")

    factory.list_FWs()

"""Il programma stampa :

FWFactory: ho  5 oggetti FW: 
Camaro2018_Chevrolet_rosa
C300_Mercedes Benz_nera
C500_Mercedes Benz_rossa
BMW_M5_rossa
BMW_X6_bianca


Client: Aggiungo un automobile.
FWFactory:  uso un FW esistente.
Il nuovo oggetto di tipo <class '__main__.automobile'> e` ['BMW', 'M5', 'rossa', 'DE123AT', 'Bob Bab']:


Client: Aggiungo un automobile.
FWFactory: non trovo un FW, ne creo uno nuovo.
Il nuovo oggetto di tipo <class '__main__.automobile'> e` ['BMW', 'X1', 'rossa', 'AR324SD', 'Mike Smith']:


FWFactory: ho  6 oggetti FW: 
Camaro2018_Chevrolet_rosa
C300_Mercedes Benz_nera
C500_Mercedes Benz_rossa
BMW_M5_rossa
BMW_X6_bianca
BMW_X1_rossa

"""