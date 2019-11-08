# Scrivere una classe che contiene un metodo che restituisce il
# numero di invocazioni degli altri metodi della classe. Il codice dei suddetti
# metodi non deve essere modificato

def contaInv(cls):
    oldAtt = getattr(cls, '__getattribute__')
    setattr(cls, '__nInvoc', 0)

    def new(self, name):
        x= oldAtt(self, name)
        if hasattr(x, '__call__'):
            setattr(cls, '__nInvoc', cls.__nInvoc + 1)
        return oldAtt(self, name)

    setattr(cls, '__getattribute__', new)

    @staticmethod
    def getInv():
        return getattr(cls, '__nInvoc', 0)

    setattr(cls, 'getInv', getInv)
    return cls


# def contaInv(cls):
#     setattr(cls, '__nInvoc', 0)
#     for func in cls.__dict__:
#         print(func)
#         if hasattr(func, '__call__'):
#             print("******{}".format(func))
#             def new(*args, **kwargs):
#                 setattr(cls, '__nInvoc', cls.__nInvoc+1)
#                 return func(args, kwargs)
#             x= new
#             setattr(cls, func, x)
#     @staticmethod
#     def getInv():
#         return getattr(cls, '__nInvoc', 0)
#     setattr(cls, 'getInv', getInv)
#     return cls

@contaInv
class Spam:
    def a(self):
        pass

    def func(self):
        return getattr(Spam, '__nInvoc', 0)


print("##############")
s = Spam()
print(Spam.getInv())
s.a()
print(Spam.getInv())
s.a()
print(Spam.getInv())
s.__dict__
print(Spam.getInv())

# import functools
#
# class A:
#
#     def decCounter(funz):
#         @functools.wraps(funz)
#         def wrapper(self, *args, **kwargs):
#             x= getattr(A, "_counter", 0)
#             setattr(A, "_counter", x+1)
#             return funz(self)
#         return wrapper
#
#     @decCounter
#     def a(self):
#         print("sono in a....")
#
#     @decCounter
#     def b(self):
#         print("sono in b....")
#
#     @decCounter
#     def c(self):
#         pass
#
#     @classmethod
#     def getCounter(cls):
#         return getattr(cls, "_counter")
#
#
# x= A()
# x.a()
# x.b()
# x.c()
# y=A()
# y.a()
# print(A.getCounter())
