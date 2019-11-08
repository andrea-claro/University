#Scrivere la funzione ricorsiva myDeepCopyche prende in input una lista che
# potrebbe contenere al suo interno elementi di tipo lista che a loro volta
# potrebbero contenere elementi di tipo lista, e cosi`via. La funzione
# restituisce la deepcopy della lista (no, non si puo`usare copy.deepcopy).
# Esempidiinput:[] ,    [1, [2, 3]] ,       [[],[1, [2, 3]]] ,
# [[[5, 4]][[2], 3],5]
# Scrivere anche una funzione mainche testi il corretto
# funzionamento di myDeepCopy

def f(l= []):
    if len(l) == 0:
        return l
    c= []
    for val in l:
        if(isinstance(val, list)):
            c.append(f(val))
        else:
            c.append(val)
    return c


a= f([1, 3, 5, 6])
print(a)