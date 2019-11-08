#Scrivere una classe "class" che ridefinisce il metodo
# "new" in modo tale da associare alla classe il metodo
# "funz" che e` definito nella classe innestata "innerclass"

class Class:
    class InnerClass:
        @staticmethod
        def funz():
            print("**funz**")

    @staticmethod
    def new():
        print("--not funz--")

    @classmethod
    def sostitution(cls, method= None):
        if(method is not None and method not in cls.__dict__):
            setattr(cls, "new", method)
        else:
            print("not funz")



Class.InnerClass.funz()
Class.new()

print("**********************")

Class.sostitution(Class.InnerClass.funz)
Class.new()
