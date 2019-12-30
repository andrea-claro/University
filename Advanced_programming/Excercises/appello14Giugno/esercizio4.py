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
import functools
from datetime import datetime

def precTesto(parole=None, lstNomiFile=[]):
    for i in range(0, len(lstNomiFile)):
        with open(lstNomiFile[i], "r") as f:
            text = f.read().split()
            confronto(i, parole, text)

def confronto(n, parole=None, text=None):
    if parole[n] in text:
        print(f"Associazione presente \"{parole[n]}\"")
    else:
        print(f"Parola non presente \"{parole[n]}\" - {text}")
            
print("---------------------------SENZA CONCORRENZA--------------------------------")       
parole= ["andrea", "ciao", "sono", "mio", "fratello", "mamma"]
nomiFile = ["appello14Giugno/testox-1", "appello14Giugno/testox-2"]
precTesto(parole, nomiFile)







def timer(func): 
    """decoratore che pemette di misuare il tempo di esecuzione"""
    @functools.wraps(func)
    def wrapper(*args, **kargs):
        start = datetime.now()
        result = func(*args, **kargs)
        finish = datetime.now()
        print(f'{func.__name__} finito in {finish-start} secondi')
        return result
    return wrapper

@timer
def procTesto(concorrenza=False, parole=None, lstNomiFile=[]):
    if concorrenza is True:
        jobs = multiprocessing.JoinableQueue()
        create_processes(len(lstNomiFile), jobs)
        add_jobs(jobs, parole, lstNomiFile)
        jobs.join()
    else:
        precTesto(parole, lstNomiFile)

def create_processes(nFile, jobs=None):
    for _ in range(nFile):
        process = multiprocessing.Process(target=worker, args=(jobs,))
        process.daemon = True
        process.start()

def add_jobs(jobs, parole, lstNomiFile):
    for n, (parola, f) in enumerate(zip(parole, lstNomiFile)):
        jobs.put((n, parola, f))

def worker(jobs=None):
    while True:
        n, parola, nomeFile = jobs.get()
        with open(nomeFile, "r") as f:
            text = f.read().split()
            if parola in text:
                print(f"La stringa \"{parola}\" e' presente nel file \"{nomeFile}\"")
            else:
                print(f"La stringa \"{parola}\" non e' presente nel file \"{nomeFile}\"")
            jobs.task_done()

print("---------------------------CONCORRENZA--------------------------------")            
procTesto(True , parole, nomiFile)
