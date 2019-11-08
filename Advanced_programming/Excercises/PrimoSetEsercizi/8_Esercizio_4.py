#Definire un decoratore di funzione che trasforma una funzione che
#prende in input un numero variabile di numeri in una funzione che
#prende in input una lista e opera solo sugli elementi della lista
# di tipo float, int e str convertiti in int.
#La funzione somma non decorata viene invocata in questo modo:
# somma(3.5, 6, 1.2)
#Se usiamo il decoratore, possiamo invocare somma([1.3, 4 ,"6"])
import functools


def cambiaV(funz):
    @functools.wraps(funz)
    def wrapper(*args, **kwargs):
        l= []
        for x in args:
            if isinstance(x, (int, str, float)):
                l.append(int(x))
            else:
                continue
        return funz(*l)
    return wrapper

@cambiaV
def somma(*args):
    return sum(args)

print(somma(3.5, 6, 1.2))
print(somma(1.3, 4, "6"))

# import functools
#
#
# def decoratoreSomma(funz):
#     @functools.wraps(funz)
#     def wrapper(list, *args, **kwargs):
#         el= [int(val) for val in list if isinstance(val, int) or isinstance(val, str) or isinstance(val, float)]
#         return funz(*el)
#     return wrapper
#
# @decoratoreSomma
# def somma(*args):
#     return sum(args)
#
#
# print(somma([1.3, 4, "anna", "6"]))
