#Scrivere nel file esercizio2.py un decoratore di classe "contaIstanze" che dota
# la classe decorata di un metodo "istanzeDiClasseDer" che conta quante sono le
# istanze di classi derivate direttamente dalla classe decorata. Ad esempio,
# supponiamo che la classe decorata sia la classe CL e supponiamo di definire le
# due classe CLF1 e CLF2 come segue
# class CLF1(CL): ...
# class CLF2(CL): ...
# e di creare 5 oggetti di tipo CLF1 e 3 oggetti di tipo CLF2. Supponiamo inoltre
# che non vi sia nessuna altra classe che estende direttamente CL. In questo caso
# "istandeDiClassiDer" deve restituire 8 indipendentemente  dal numero totale di
# oggetti di tipo CL. Ovviamente il metodo deve funzionare per un numero arbitrario
# di sottoclassi immediate della classe base e il decoratore NON deve essere usato
# per decorare le sottoclassi.

#Suggerimento: potete usare tipo.__bases__ per ottenere la tupla delle classi da cui
# è stato derivato tipo. Si assuma che non venga utilizzata l'ereditarietà multipla.

def contaIstanze(cls):
    class Spam(cls):
        _instances= 0
        def __new__(cls, *args, **kwargs):
            if Spam in cls.__bases__:
                Spam._instances+=1
            cls.__init__(args, kwargs)
        @staticmethod
        def istanzeDiClasseDer():
            return Spam._instances
    return Spam

@contaIstanze
class CL:
    pass

class CLF1(CL):
    pass

class CLF2(CL):
    pass

class cavolo(CLF2):
    pass

f= CL()
g= CL()

a= CLF1()
b= CLF1()
c= CLF1()
d= CLF1()
e= CLF1()

h= CLF2()
y= CLF2()
x= CLF2()

z= cavolo()

print(CL.__bases__)
print(CLF1.__bases__)
print(CLF2.__bases__)

print(cavolo.__bases__)

print(CL.istanzeDiClasseDer())