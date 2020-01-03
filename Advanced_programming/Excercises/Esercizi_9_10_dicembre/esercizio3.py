# Scrivere una classe tale che ciascuna istanza della classe ha solo tre
# attributi: nome, cognome ed età. Non deve essere possibile aggiungere
# altri attributi.
# 
# Scrivere una classe tale che ogni istanza ha lo stesso stato



class MyClass:


    class A:
        __slots__ = ["nome", "cognome", "eta"]

        def __init__(self, *args, **kwargs):
            self.nome = args[0]
            self.cognome = args[1]
            self.eta = args[2]

        def stampa(self):
            print(self.nome + " " + self.cognome + " " + str(self.eta))


    def __init__(self, *args, **kwargs):
        self.instance = MyClass.A(*args, **kwargs)

    def stampa(self):
        self.instance.stampa()


class MyCloss(MyClass):

    def __init__(self, *args, **kwargs):
        self.instance = MyClass(*args, **kwargs)

    def stampa(self):
        self.instance.stampa()


def main():
    a = MyClass("andrea", "claro", 22, 11)
    a.stampa()
    b = MyCloss("gerardo", "gullo", 22, 11)
    b.stampa()

if __name__ == '__main__':
    main()