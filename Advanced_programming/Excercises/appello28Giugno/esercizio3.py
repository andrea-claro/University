#Modificare il codice di cui all'esercizio2.py in modo tale che
# il decoratore possa essere parametrizzato con un intero i che
# indica il numero massimo di istanze che possono essere create.
# Se si tenta di creare più di i istanze della classe decorata si
# ha un RuntimeError. Il codice di questo esercizio deve essere
# scritto nel file esercizio3.py

def decoraClasse(k):
    def wrapper(cls):
        old_new = getattr(cls, '__new__')
        def newNew(cls, *args, **kwargs):
            n = getattr(cls, '_instance', 0)
            if n < k:
                if '_instance' not in cls.__dict__:
                    setattr(cls, '_instance', 1)
                    return old_new(cls, *args, **kwargs)
                else:
                    setattr(cls, '_instance', n + 1)
                    return old_new(cls, *args, **kwargs)
            else:
                raise RuntimeError('Istanza esistente')
        setattr(cls, '__new__', newNew)
        return cls
    return wrapper


@decoraClasse(5)
class Spam:
    pass


x= Spam()
print(type(x))
y= Spam()
c= Spam()
d= Spam()
e= Spam()
f= Spam()
