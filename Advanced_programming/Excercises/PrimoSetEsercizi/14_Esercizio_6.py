# Avete a disposizione la seguente classe
# classAdapter:

# def__init__(self, obj, adapted_methods):
# self.obj= obj
# self.__dict__.update(adapted_methods)
#
# def__str__(self):
# return str(self.obj)

# e le classi Lavoratore, Commesso, Cuoco, Musicista.
# La classe Lavoratore e`stata implementata da voi mentre
# le restanti sono in una libreria esterna il cui codice
# sorgente non puo`essere modificato.

#Scrivere un programma che stampa le seguenti stringhe utilizzando
# solo i metodi di Adapter e  Lavoratore:
# Il commesso Paolo vende abiti
# Il musicista Veronica suona musica pop
# Il cuoco Antonio cucina una lasagna

from Ex_6.lavoratori import Cuoco, Musicista, Commesso


class Adapter:

    def __init__(self, obj, adapted_methods):
        self.obj = obj
        self.__dict__.update(adapted_methods)

    def __str__(self):
        return str(self.obj)


class Lavoratore:

    def __init__(self, nome):
        self.nome = nome

    def __str__(self):
        return "il lavoratore {}".format(self.nome)

    def lavora(self, lavoro):
        return "svolge il seguente {}".format(lavoro)




x= Commesso("Paolo")
y= Cuoco("Antonio")
z= Musicista("Veronica")

objects= []

objects.append(Adapter(x, dict(lavora=x.vende("abiti"))))
objects.append(Adapter(y, dict(lavora=y.cucina("lasagne"))))
objects.append(Adapter(z, dict(lavora=z.suona("musica pop"))))

for i in objects:
    print('{} {}'.format(i.__str__(), i.lavora))


