#Scrivere la funzione conta all’interno del file esercizio4.py.
# Se la funzione ha bisogno di invocare altre procedure, fornire anche quest’ultime.
# La funzione conta prende in input una stringa parola, una lista di nomi di file listaFile
# e il parametro concorrenza. Facendo uso di Futures e Multiprocessing, la funzione
# conta deve contare quante volte parola appare in ciascuno dei file di listaFile e
# stampare per ciascun file l’intero computato. Cio` deve essere fatto con un processo
# separato per ogni file di listaFile e le stampe devono essere effettuate nell’ordine
# in cui terminano i processi. Il callable usato da conta deve prendere in input la lista
# di file e la parola.
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

##################### CONCORRENTE FUTURES ###########################
@timer
def canta(concorrenza, parola, listaFile):

    if concorrenza is True:
        futures = set()

        with concurrent.futures.ProcessPoolExecutor(max_workers=len(listaFile)) as executor:
            for parola, nomeFile in get_jobs(parola, listaFile):
                future = executor.submit(cerca, parola, nomeFile)
                futures.add(future)

        wait_for(futures, parola, listaFile)

    else:
        print("NO CONCORRENZA")
        exit(1)


def get_jobs(parola, listaFile):

    for nomeFile in listaFile:
        yield parola, nomeFile


def cerca(parola, nomeFile):
    k= 0

    with open(nomeFile, "r") as f:
        testo = f.read().split()

        for word in testo:
            if word == parola:
                k += 1
        
        return [k, nomeFile]


def wait_for(futures, parola, listaFile):
    for future in concurrent.futures.as_completed(futures):
        res = future.result()
        print(f"La parola \"{parola}\" è presente nel file \"{res[1]}\" \"{res[0]}\" volte")
#####################################################################


#################### CONCORRENTE QUEUE ##############################
@timer
def centa(concorrenza, parola, listaFile):

    if concorrenza is True:
        jobs = multiprocessing.JoinableQueue()
        create_processes(len(listaFile), jobs)
        add_jobs(jobs, parola, listaFile)
        jobs.join()

    else:
        print("NO CONCORRENZA")
        exit(1)


def create_processes(nFile, jobs):

    for _ in range(nFile):
        process = multiprocessing.Process(target=worker, args=(jobs,))
        process.daemon = True
        process.start()


def worker(jobs):
    while True:
        i, parola, nomeFile = jobs.get()
        k = cerca(parola, nomeFile)
        print(f"La parola \"{parola}\" è presente nel file \"{nomeFile}\" \"{k}\" volte")

def add_jobs(jobs, parola, listaFile):

    for i, nomeFile in enumerate(listaFile):
        jobs.put((i, parola,nomeFile))
#####################################################################

def main():
    parola = "andrea"
    listaFile = ["appello12Luglio/testox-1", "appello12Luglio/testox-2"] 
    print("---------------------------CONCORRENZA FUTURES------------------------------")            
    canta(True , parola, listaFile)
    print("---------------------------CONCORRENZA QUEUE--------------------------------")            
    centa(True , parola, listaFile)
    
if __name__ == '__main__':
    main()