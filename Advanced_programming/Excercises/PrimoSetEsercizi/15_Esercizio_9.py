# Scrivere un decorator factory che genera un decoratore di classe
# che dota la classe di un metodo che restituisce il numero di
# invocazioni del metodo passato come parametro al decorator factory
import functools


def dec(func):
    def conta(cls):
        oldA = getattr(cls, func)
        setattr(cls, '__nInvoc', 0)

        def new():
            setattr(cls, '__nInvoc', cls.__nInvoc + 1)
            return oldA()
        setattr(cls, func, new)
        @staticmethod
        def getInv():
            return getattr(cls, '__nInvoc', 0)

        setattr(cls, 'getInv', getInv)
        return cls
    return conta


@dec('a')
class Spam:

    @staticmethod
    def a():
        print("mmm")


a = Spam()
print(a.getInv())
Spam.a()
print(a.getInv())

# def dFactory(f):
#     def wrapper(cls):
#         cls.counterF = 0
#         setattr(cls, "old", getattr(cls, f))
#
#         def new_f(*args, **kwargs):
#             cls.counterF += 1
#             getattr(cls, "old")(*args, **kwargs)
#
#         setattr(cls, f, new_f)
#         return cls
#
#     return wrapper
#
#
# @dFactory("funz")
# class Spam:
#
#     def funz(self):
#         print("funz")


# a = Spam()
# a.funz()
# a.funz()
# print(a.counterF)
#