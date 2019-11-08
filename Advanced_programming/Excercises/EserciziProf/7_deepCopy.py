#Scrivere una funzione ricorsiva myDeepCopy che prende in input una lista
#che potrebbe contenere al suo interno elementi di tipo lista che a loro
#volta potrebbero contenere elementi di tipo lista, e cosi` via.
#La funzione restituisce la deep copy della lista (no, non si puo` usare
# copy e deepcopy),
#       Esempio di input: [], [1, [2, 3]], [[], [1, [2, 3]]], [[[5, 4]][2], 3], 5]
#Scrivere anche una funzione main che testi il corretto funzionamento di myDeepCopy


def myDeepCopy(lista):
    if len(lista)== 0:
        return lista
    myCopy= []
    for val in lista:
        if isinstance(val, list):
            myCopy.append(myDeepCopy(val))
        else:
            myCopy.append(val)
    return myCopy

lista= [[1, 2, 3], 4, 5, 6, [1, 2, 3, [5, 6, [4, 8, 9]]]]
print(lista)
f= myDeepCopy(lista)
print(f)