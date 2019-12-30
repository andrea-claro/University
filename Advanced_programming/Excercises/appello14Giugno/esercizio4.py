#Scrivere la funzione procTesto all’interno del file esercizio4.py.
# Se la funzione ha bisogno di invocare altre procedure, fornire anche quest’ultime.
# La funzione procTesto prende in input una lista di nomi di file, una lista di stringhe,
# e il parametro concorrenza. La funzione procTesto deve cecare nel testo dell’i-esimo file
# della prima lista l’i-esima stringa della seconda lista e deve fare cio` con un processo
# separato per ogni coppia file-stringa. Attenzione, il callable utilizzato da procTesto
# deve ricevere in input il testo del file e non il file. La funzione procTesto deve inoltre
# stampare per ciascuna coppia file-stringa se la stringa e` presente o meno nel file.
# Le stampe devono avvenire nell’ordine in cui terminano i processi e al termine degli stessi.

import multiprocessing

def precTesto(fileParole=None, lstNomiFile=[]):
    with open(fileParole, "r") as ff:
        texto = ff.read().split()
        for i in range(0, len(lstNomiFile)):
            with open(lstNomiFile[i], "r") as f:
                text = f.read().split()
                confronto(texto, text, i)

def confronto(textParole, textFile, n):
    if textParole[n] in textFile:
        print("Parola presente")
    else:
        print("Parola non presente")
            
print("---------------------------SENZA CONCORRENZA--------------------------------")            
precTesto("appello14Giugno/parole", ["appello14Giugno/testox", "appello14Giugno/testox-1", "appello14Giugno/testox-2"])










def procTesto(concorrenza=False, fileParole=None, lstNomiFile=[]):
    with open(fileParole, "r") as f:
        parole = f.read().split()
    create_processes(concorrenza, parole, lstNomiFile)

def create_processes(concorrenza=False, parole=None, lstNomiFile=[]):
    if concorrenza is True:
        for i in range(0, len(lstNomiFile)):
            print(i)
            process = multiprocessing.Process(target=worker, name="Pippo", args=(i, parole, lstNomiFile[i]))
            process.daemon = True
            process.start()
            process.join()
    else:
        print("NO CONCORRENZA")

def worker(i=-1, parole=None, file=None):
    with open(file, "r") as f:
        testo = f.read().split()
    if parole[i] in testo:
        print("Associazione presente \"{}\"".format(parole[i]))
    else:
        print("Parola non presente \"{}\" in {}".format(parole[i], testo))

print("---------------------------CONCORRENZA--------------------------------")            
procTesto(True ,"appello14Giugno/parole", ["appello14Giugno/testox", "appello14Giugno/testox-1", "appello14Giugno/testox-2"])
