class Implementation:

    def f(self):
        print("implementation.f()")

    def g(self):
        print("implementation.g()")
        
    def h(self):
        print("implementation.h()")

class Proxy:

    def __init__(self):
        self.__implementation = Implementation()

    def __getattr__(self, name):
        return getattr(self.__implementation, name)
        
p = Proxy()
p.f()
p.g()
p.h()