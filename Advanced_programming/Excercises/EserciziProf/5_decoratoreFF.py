#Scrivere un decoratore di classe che decora una classe
# in modo che se la classe non contiene la funzione "ff"
# allora viene invocata la funzione "ff" della "classeConFF"

class ClasseConFF:
    @staticmethod
    def ff():
        print(".............ff")

def putFF(method):
    def wrapper(cls):
        if (method not in cls.__dict__):
            setattr(cls, "ff", ClasseConFF.ff)
        else:
            print("method already exists")
        return cls
    return wrapper


@putFF(ClasseConFF.ff)
class Classe:
    pass

x= ClasseConFF
x.ff()
print("---------------------")
y= Classe
y.ff()