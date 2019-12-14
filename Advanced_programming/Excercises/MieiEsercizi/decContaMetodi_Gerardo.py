

def contaMetodi(aClass):

    class myClass(aClass):

        countDict = dict()

        def __getattribute__(self, name):
            e = super().__getattribute__(name)

            if hasattr(e, "__call__"):

                if name in myClass.countDict.keys():
                    myClass.countDict[name] += 1
                else:
                    myClass.countDict[name] = 1

            return e

    return myClass


@contaMetodi
class spam:
    def a(self): pass
    def b(self): pass


s = spam()
s.a()
s.b()
s.b()

print(s.countDict)
