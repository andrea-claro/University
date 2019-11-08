#Definire un decoratore di classe che permette alla classe
# decorata di contare le sue istanze.

def contaInst(cls):
    oldNew= getattr(cls, '__new__')
    setattr(cls, '__countI', 0)
    def new(cls):
        setattr(cls, '__countI', cls.__countI+1)
        return oldNew(cls)
    setattr(cls, '__new__', new)
    @staticmethod
    def getI():
        return cls.__countI
    setattr(cls, 'getI', getI)
    return cls


@contaInst
class Spam:
    pass

print(Spam.getI())
a= Spam()
print(Spam.getI())
b= Spam()
print(Spam.getI())

# import functools
#
#
# def dSpam(cls):
#     @functools.wraps(cls)
#     def wrapper(*args, **kwargs):
#         cls()
#         cls.numInstances+= 1
#         return cls
#     return wrapper
#
# @dSpam
# class Spam:
#     numInstances= 0
#     pass
#
# a= Spam()
# b= Spam()
#
# print(a.numInstances)
#