from __future__ import annotations
from abc import ABC

import functools

def courutine(gen):
    @functools.wraps(gen)
    def wrapper(*args,**kargs):
        myGen = gen(*args,**kargs)
        next(myGen)
        return myGen
    return wrapper


class Mediated:

    def __init__(self):
        self._mediator = None

    def on_change(self,event):
        if self._mediator is not None:
            self._mediator.send(event)




class BaseComponent:
    """
    The Base Component provides the basic functionality of storing a mediator's
    instance inside component objects.
    """

    

    def __init__(self, mediator: Mediator = None) -> None:
        self.c1 = Component1()
        self.c2 = Component2()
        self.createMediator()

    @property
    def mediator(self) -> Mediator:
        return self._mediator

    @mediator.setter
    def mediator(self, mediator: Mediator) -> None:
        self._mediator = mediator

    def createMediator(self) -> None:
        self.mediator = self.handler2(self.handler1())

        for x in (self.c1,self.c2):
            x._mediator = self.mediator
            
    @courutine
    def handler1(self,successor=None) -> None:
        while True:
            event = (yield)
            if event == "A":
                print("Mediator reacts on A and triggers following operations:")
                self.c2.do_c()
            if successor :
                successor.send(event)
    @courutine
    def handler2(self, successor=None) -> None:
        while True:
            event = (yield)
            if event == "D":
                print("Mediator reacts on D and triggers following operations:")
                self.c1.do_b()
                self.c2.do_c()
            if successor :
                successor.send(event)


"""
Concrete Components implement various functionality. They don't depend on other
components. They also don't depend on any concrete mediator classes.
"""


class Component1(Mediated):
    def do_a(self) -> None:
        print("Component 1 does A.")
        self.on_change("A")

    def do_b(self) -> None:
        print("Component 1 does B.")
        self.on_change("B")


class Component2(Mediated):
    def do_c(self) -> None:
        print("Component 2 does C.")
        self.on_change("C")

    def do_d(self) -> None:
        print("Component 2 does D.")
        self.on_change("D")


if __name__ == "__main__":
    # The client code.
    c = BaseComponent()

    print("Client triggers operation A.")
    c.c1.do_a()

    print("\n", end="")

    print("Client triggers operation D.")
    c.c2.do_d()


# Client triggers operation A.
# Component 1 does A.
# Mediator reacts on A and triggers following operations:
# Component 2 does C.


# Client triggers operation D.
# Component 2 does D.
# Mediator reacts on D and triggers following operations:
# Component 1 does B.
# Component 2 does C.