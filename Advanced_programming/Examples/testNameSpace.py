class A:

    def foo():
        print("dio cane")

a = 4
b = 'zaino'
c = A()
d = A
f = c.foo

print("dir di a")
print(dir(a))     #dir() genera la lista degli attributi e metodi dell'oggetto passato, questo è opzionale
print("####")
print(dir())
print("####")
print(vars())     #vars() ritorna il __dict__ dell'oggetto passato, questo è opzionale
print()
print("dir di b")
print(dir(b))
print()
print("dir di c")
print(dir(c))
print()
print("vars di c")
print(vars(c))
print()
print("dir di d")
print(dir(d))
print()
print("vars di d")
print(vars(d))
print()
print("dir di f")
print(dir(f))
print()
print("vars di f")
print(vars(f))
