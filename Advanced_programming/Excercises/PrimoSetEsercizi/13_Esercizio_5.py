#Modificare la funzione al punto precedente in modo che la
# funzione decorata
# operi su qualsiasi elemento della lista che puo`essere
# convertito in int
# non lanci un’eccezione se un elemento della lista non puo`
# essere convertito a int
# cio`puo`non dipendere dal tipo dell’elemento ma dal suo
# specifico valore, ad esempio "anna" o b "anna"
import functools


def decoratoreSomma(funz):
    @functools.wraps(funz)
    def wrapper(list, *args, **kwargs):
        el= []
        for val in list:
            try:
               el.append(int(val))
            except Exception as e:
                continue
        return funz(*el)
    return wrapper

@decoratoreSomma
def somma(*args):
    return sum(args)


print(somma([1.3, 4, "anna", "6"]))
