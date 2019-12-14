# Nella classe singleton si fa in modo che l'elemento istanza sia istanziabile una sola volta,
# di modo che ad ogni richiamo del costruttore, questa non venga cambiata
class Singleton:
    __instance = None

    class __impl:

        def spam(self):
            return id(self)

    def __init__(self):
        if Singleton.__instance is None:
            Singleton.__instance = Singleton.__impl()
        self.__dict__['_Singleton__instance'] = Singleton.__instance
        print(self.__dict__)

    def __getattr__(self, attr):
        return getattr(self.__instance, attr)

    def __setattr__(self, attr, value):
        return setattr(self.__instance, attr, value)


# Test it
s1 = Singleton()
print(id(s1), s1.spam())
s2 = Singleton()
print(id(s2), s2.spam())
