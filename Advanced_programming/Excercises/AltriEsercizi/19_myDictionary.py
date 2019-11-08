#Scrivere la classe MyDictionary che implementa gli operatori di dict riportati di seguito.
# MyDictionary deve avere solo una variabile di istanza e questa deve essere di tipo lista.
# Per rappresentare le coppie, dovete usare la classe MyPair che ha due variabili di istanza
# (key e value) e i metodi getKey, getValue,setKey, setValue.



class MyPair:

    def __init__(self, k, v):
        self._key= k
        self._value= v

    def getKey(self):
        return self._key
    def setKey(self, k):
        self._key= k

    def getValue(self):
        return self._value
    def setValue(self, v):
        self._value= v



class MyDictionary:

    def __init__(self):
        self._dic= list()

    def getDic(self):
        return self._dic

    def insert(self, k, v):
        for e in self._dic:
            if e.getKey() == k:
                assert("The key already exists")
                return
        self._dic.append(MyPair(k, v))

    def getFromKey(self, k):
        if len(self._dic) == 0:
            assert("There is no value in the dictionary")
        else:
            for e in self._dic:
                if e.getKey() == k:
                    return e

    def setFromKey(self, k, v):
        if len(self._dic) == 0:
            assert("There is no value in the dictionary")
        else:
            for e in self._dic:
                if e.getKey() == k:
                    e.setValue(v)

    def delFromKey(self, k):
        if len(self._dic) == 0:
            assert("There is no value in the dictionary")
            return
        else:
            for i in range(0, len(self._dic)):
                if self._dic[i].getKey() == k:
                    c= i
            self._dic.pop(i)

    def isKeyInside(self, k):
        for e in self._dic:
            if e.getKey() == k:
                return True
        return False

    def isNotKeyInside(self, k):
        for e in self._dic:
            if e.getKey() == k:
                return False
        return True

    def isEquivalent(self, obj):
        if not isinstance(obj, MyDictionary):
            assert("The object passed isn't a dictionary")
        else:
            x= obj.getDic()
            if len(self._dic) == len(x):
                c= 0
                for e in self._dic:
                    for i in range(0, len(self._dic)):
                        if e.getValue() == x[i].getValue():
                            c+= 1
                if c == len(self._dic):
                    return True
            return False

        def isNotEquivalent(self, obj):
            if not isinstance(obj, MyDictionary):
                assert ("The object passed isn't a dictionary")
            else:
                x = obj.getDic()
                if len(self._dic) == len(x):
                    c = 0
                    for e in self._dic:
                        for i in range(0, len(self._dic)):
                            if e.getValue() == x[i].getValue():
                                c += 1
                    if c == len(self._dic):
                        return False
                return True


c= MyDictionary()
c.insert("chiave", 6)
print(c.getFromKey("chiave"))