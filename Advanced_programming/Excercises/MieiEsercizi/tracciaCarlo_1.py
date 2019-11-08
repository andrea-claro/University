#Contare il numero di invocazioni di un metodo di una classe

def contaI(funz):
    def conta(cls):
        oldFunz= getattr(cls, funz)
        setattr(cls, '_nInvoc', 0)
        def newFunz():
            setattr(cls, '_nInvoc', getattr(cls, '_nInvoc')+1)
            oldFunz()
        setattr(cls, funz, newFunz)
        return cls
    return conta

@contaI("funz")
class Spam:
    @staticmethod
    def funz():
        print("Sono in funz")

x= Spam()
Spam.funz()
Spam.funz()
Spam.funz()


print(Spam._nInvoc)