#Abbiamo una classe MyClass che ha una variabile di istanza v inizializzata
# da __init__ e tre metodi di istanza: f(self, a), g(self, x, y), create(self)
# e finalize(self). I metodi f e g fanno uso della variabile v.
#
# Vogliamo scrivere una classe P che ha anch'essa i metodi f, g, create e finalize.
# Questi metodi di P si comportano come segue:
# - f invoca rispettivamente il metodo f di MyClass
# - create e g, se invocate, non provocano immediatamente l'invocazione del
#   metodo create di MyClass. L'invocazione di questo metodo avviene solo se
#   viene invocato finalize.
# - finalize invoca finalize di MyClass(ovviamente se deve essere invocata
#   create o g, invoca prima create/g)


class MyClass:


    def __init__(self):
        self._v= 1

    def f(self, a):
        print("Sono in f ", self._v)

    def g(self, x= 0, y= 0):
        print("Sono in g ", self._v)

    def create(self):
        print("Sono in create")

    def finalize(self):
        print("Sono in finalize")


class P:

    def __init__(self):
        self._mc= MyClass()
        self._cmd= list()

    def f(self, a):
        self._mc.f(a)

    def g(self, x, y):
        self._cmd.append([self._mc.g, x, y])

    def create(self):
        self._cmd.append([self._mc.create])

    def finalize(self):
            for e in self._cmd:
                a, *w= e
                a(*w)

            self._mc.finalize()

a= P()

a.f(1)
a.g(2, 3)
a.create()
a.finalize()
