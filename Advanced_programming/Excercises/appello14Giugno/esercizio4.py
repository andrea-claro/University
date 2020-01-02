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
import concurrent.futures
import functools
from datetime import datetime


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

def coroutine(function):
    @functools.wraps(function)
    def wrapper(*args,**kwargs):
        generator=function(*args,**kwargs)
        next(generator)
        return generator
    return wrapper

################### SENZA CONCORRENZA ###############################
@timer
def pracTesto(parole=None, lstNomiFile=[]):
    for i in range(0, len(lstNomiFile)):
        with open(lstNomiFile[i], "r") as f:
            text = f.read().split()
            confronto(i, parole, text)

def confronto(n, parole=None, text=None):
    if parole[n] in text:
        print(f"Associazione presente \"{parole[n]}\"")
    else:
        print(f"Parola non presente \"{parole[n]}\" - {text}")
#####################################################################        


#################### CONCORRENTE QUEUE ##############################
@timer
def precTesto(concorrenza=False, parole=[], lstNomiFile=[]):
    if concorrenza is True:
        jobs = multiprocessing.JoinableQueue()
        create_processes(len(lstNomiFile), jobs)
        add_jobs(jobs, parole, lstNomiFile)
        jobs.join()
    else:
        pracTesto(parole, lstNomiFile)

def create_processes(nFile, jobs=None):
    for _ in range(nFile):
        process = multiprocessing.Process(target=worker, args=(jobs,))
        process.daemon = True
        process.start()

def add_jobs(jobs, parole, lstNomiFile):
    for i, (parola, nomeFile) in enumerate(zip(parole, lstNomiFile)):
        jobs.put((i, parola, nomeFile))

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
#####################################################################


##################### CONCORRENTE FUTURES ###########################
@timer
def pricTesto(concorrenza=False, parole=[], lstNomiFile=[]):
    if concorrenza is True:
        futures = set()
        with concurrent.futures.ProcessPoolExecutor(max_workers=len(lstNomiFile)) as executor:
            for i, testo, parola in get_jobs(parole, lstNomiFile):
                future = executor.submit(cerca, i, parola, testo)
                futures.add(future)
        wait_for(futures, parole, lstNomiFile)
    else:
        pracTesto(parole, lstNomiFile)

def get_jobs(parole=[], lstNomiFile=[]):
    for i, (parola, nomeFile) in enumerate(zip(parole, lstNomiFile)):
        with open(nomeFile, "r") as f:
            testo = f.read()
            yield i, testo, parola

def wait_for(futures=None, parole=[], lstNomiFile=[]):
    for future in concurrent.futures.as_completed(futures):
        res = future.result()
        if res[0] == True:
            print("La stringa {} e' presente nel file {}:".format(parole[res[1]],lstNomiFile[res[1]]))
        else:
            print("La stringa {} non e' presente nel file {}:".format(parole[res[1]], lstNomiFile[res[1]]))

def cerca (i, parola, testo):
    for st in testo.split():
        if st == parola:
            return (True,i)
    return (False,i)
######################################################################


##################### CONCORRENTE COROUTINE ##########################
@timer
def procTesto(concorrenza=False, parole=[], lstNomiFile=[]):
    if concorrenza is True:
        ricevitore = reporter(parole, lstNomiFile)
        cercatori = dict()
        for parola in parole:
            cercatori[parola] = cercatore(ricevitore, parola)
        try:
            for i, (parola, nomeFile) in enumerate(zip(parole, lstNomiFile)):
                with open(nomeFile, "r") as f:
                    testo = f.read()
                    cercatori[parola].send((i, testo))
        finally:
            for c in cercatori.values():
                c.close()
                ricevitore.close()
    else:
        pracTesto(parole, lstNomiFile)

@coroutine
def reporter(parole=[], lstNomiFile=[]):
    while True:
        trovato, i = (yield)
        if trovato is True:
            print("La stringa {} e' presente nel file {}:".format(parole[i], lstNomiFile[i]))
        else:
            print("La stringa {} non e' presente nel file {}:".format(parole[i], lstNomiFile[i]))

@coroutine
def cercatore(ricevitore, parola):
    while True:
        i, testo = (yield)
        if parola in testo.split():
            ricevitore.send((True, i))
        else:
            ricevitore.send((False, i))
######################################################################

def main():
    parole = ["andrea", "ciao", "sono", "mio", "fratello", "mamma"]
    nomiFile = ["appello14Giugno/testox-1", "appello14Giugno/testox-2"]
    print("---------------------------SENZA CONCORRENZA--------------------------------")       
    pracTesto(parole, nomiFile)
    print("---------------------------CONCORRENZA QUEUE--------------------------------")            
    precTesto(True , parole, nomiFile)
    print("---------------------------CONCORRENZA FUTURES------------------------------")            
    pricTesto(True , parole, nomiFile)
    print("--------------------------------COROUTINE-----------------------------------")            
    pricTesto(True , parole, nomiFile)

if __name__ == "__main__":
    main()
