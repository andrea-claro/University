class Implementation:

    def f(self):
        print("Implementation.f()")

    def g(self):
        print("Implementation.g()")

    def h(self):
        print("Implementation.h()")


class Proxy:

    def __init__(self):
        self.__implementation = Implementation()

    def f(self):
        self.__implementation.f()

    def g(self):
        self.__implementation.g()

    def h(self):
        self.__implementation.h()


p = Proxy()
p.f();
p.g();
p.h()


class Implementation2:

    def f(self):
        print("Implementation.f()")

    def g(self):
        print("Implementation.g()")

    def h(self):
        print("Implementation.h()")


class Proxy2:

    def __init__(self):
        self.__implementation = Implementation2()

    def __getattr__(self, name):
        return getattr(self.__implementation, name)


p = Proxy2()
p.f();
p.g();
p.h();
