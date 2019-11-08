#Leggere parole da file e stamparle in un altro file in ordine inverso

def writeOnFile(file, word):
    file.write(word)

def swapOnFile(file, copia):
    for linea in file.readlines():
        for string in linea.split():
            size= len(string)
            for k in range(0, size):
                copia.write(string[size-1-k])
            copia.write(" ")



file= open("pitonz", "r+")
parola=" lurido"
writeOnFile(file, parola)
copia= open("ganzo", "w+")
swapOnFile(file, copia)
