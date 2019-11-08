#Creare un decorator factory parametrizzato con (classeConDelegata, funz, delegata)
import functools

class Delegata:
    @staticmethod
    def f(): print("sono f")

def decoratoreF(cls,funz,delegato):

    def decora(classe):
        setattr(classe,funz,getattr(cls,delegato))
        return classe

    return decora

@decoratoreF(Delegata,"miao","f")
class spam : pass

spam.miao()
    