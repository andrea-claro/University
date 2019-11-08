#Scrivere nel file esercizio2.py il decoratore di classe
# decoraClasse che trasforma la classe in una classe di cui può
# esistenre al più un'istanza. Se si tenta di creare più di
# un'istanza della classe decorata si ha un RuntimeError

def decoraClasse(cls):
    old_new= getattr(cls, '__new__')
    def newNew(cls, *args, **kwargs):
        if '_instance' not in cls.__dict__:
            setattr(cls, '_instance', True)
            return old_new(cls, *args, **kwargs)
        else:
            raise RuntimeError('Istanza esistente')
    setattr(cls, '__new__', newNew)
    return cls


@decoraClasse
class Spam:
    pass


x= Spam()
print(type(x))
y= Spam()

