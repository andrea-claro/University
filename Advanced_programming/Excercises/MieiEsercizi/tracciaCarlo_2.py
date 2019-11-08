# Contare il numero di invocazioni di tutti i metodi della classe

# def contaMetodi(aClass):
#     class myClass(aClass):
#         countDict = dict()
#         def __getattribute__(self, name):
#             e = super().__getattribute__(name)
#             if hasattr(e, "__call__"):
#                 if name in myClass.countDict.keys():
#                     myClass.countDict[name] += 1
#                 else:
#                     myClass.countDict[name] = 1
#             return e
#     return myClass
#
# @contaMetodi
# class spam:
#     def a(self): pass
#     def b(self): pass
#
# s = spam()
# print(s.__getattribute__("a"))
# s.a()
# s.b()
# s.b()
#
# print(s.countDict)

def contaInvoc(cls):
    cls._nInvoc = 0
    oldGet= getattr(cls, '__getattribute__')
    def new(self, name):
        func= oldGet(self, name)
        if hasattr(func, '__call__'):
            cls._nInvoc+=1
        return func
    setattr(cls, '__getattribute__', new)

    return cls


@contaInvoc
class Spam:
    def a(self):
        pass

    def b(self):
        pass

    def c(self):
        pass


x = Spam()
print(x._nInvoc)
x.a()
x.b()
x.a()
print(x._nInvoc)
# x.__dict__
# print(x._nInvoc)
