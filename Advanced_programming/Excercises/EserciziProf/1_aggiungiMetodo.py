# Scrivere la classe "classe" il cui metodo statico "aggiungiMetodo"
# prende in input un parametro "funzione" e se e` diverso da "None"
# inserisce in "classe" un metodo "f" uguale a "funzione"

class Classe:

    @classmethod
    def aggiungiMetodo(cls, method=None):
        if (method is not None):
            setattr(cls, "f", method)
        else:
            print("No f")


def funzione():
    print("f**")


funzione()
print("****************")
Classe.aggiungiMetodo()
Classe.aggiungiMetodo(funzione)
Classe.f()





