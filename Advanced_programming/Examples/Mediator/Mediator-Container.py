import collections
import functools

def coroutine(function):
    @functools.wraps(function)
    def wrapper(*args, **kwargs):
        generator = function(*args, **kwargs)
        next(generator)
        return generator
    return wrapper

class Container:

    def create_components(self):
        self.component1 = Component1()
        self.component2 = Component2()

    def create_mediator(self):
        self.mediator = self.component1_mediator(self.component2_mediator())
        for component in (self.component1, self.component2):
            component.mediator = self.mediator

    @coroutine
    def component1_mediator(self, successor=None):
        while True:
            component = (yield)
            if component == self.component1:
                print("Cambiamento di stato di '{}' intercettato dal component1_mediator".format(type(component).__name__))
            elif successor is not None:
                successor.send(component)

    @coroutine
    def component2_mediator(self, successor=None):
        while True:
            component = (yield)
            if component == self.component2:
                print("Cambiamento di stato di '{}' intercettato dal component2_mediator".format(type(component).__name__))
            elif successor is not None:
                successor.send(component)

class Mediated:

    def __init__(self):
        self.mediator = None

    def on_change(self):
        if self.mediator is not None:
            self.mediator.send(self)

class Component1(Mediated):

    def __init__(self):
        super().__init__()

    def doSomething(self):
        print("Daniele = Salvatore")
        self.on_change()

class Component2(Mediated):
    def __init__(self):
        super().__init__()

    def verità(self):
        print("Paolo è un Hacker")
        self.on_change()


def main():
    container = Container()
    container.create_components()
    container.create_mediator()
    container.component1.doSomething()
    container.component2.verità()

if __name__ == '__main__':
    main()