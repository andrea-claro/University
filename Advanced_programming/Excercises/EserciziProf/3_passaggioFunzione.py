#Scirvere una classe che abbia un metodo statico che prende
# come parametro una funzione, e se la funzione e' definita,
# allora aggiunge la funzione alla classe come attributo f

class Foo:

    f= None

    @staticmethod
    def funz(method= None):
        if(method is not None ):
            Foo.f= method
        else:
            print("no method")


def f():
    print("****f")


f()
print("----------")
Foo.funz()
Foo.funz(f)
print(Foo.f)
