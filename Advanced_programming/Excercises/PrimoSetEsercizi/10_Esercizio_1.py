#Scrivere una funzione che prende in input una lista L e
#restituisce una lista di |L|! liste in cui ciascuna lista
#contiene una diversa permutazione degli elementi della lista
#input L


def perm(l):
    if len(l) == 0:
        return []
    if len(l) == 1:
        return list([l])
    else:
        out= []
        p= perm(l[1:])
        for e in p:
            for j in range(0, len(e)+1):
                out+= list([e[:j] + [l[0]] + e[j:]])
        return out


print("--------------------")
print(perm([1, "str", [5, 6]]))
print("--------------------")
