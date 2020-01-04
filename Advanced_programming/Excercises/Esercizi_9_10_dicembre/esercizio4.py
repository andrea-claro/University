# Scrivere un programma concorrente (facendo prima usi di futures e multiprocessing e poi 
# di joinable queue) che prende in input una lista L di stringhe ed un intero n e crea, in
# modo concorrente, per ciascuna delle stringhe s in L una lista. La lista creata per la
# stringa i-esima di L deve contenere n//(10^i) occorrenze della stringa. Le liste devono 
# essere stampate non appena vengono create.
# 
# Ad esempio, se n = 10 e L = ["anna", "mario"]
# vengono stampate le liste ["anna", anna", "anna", anna", "anna", "anna", "anna", anna", "anna", anna"] ["mario"]
import multiprocessing
import concurrent.futures
import functools
from datetime import datetime

def timer(func):
    @functools.wraps(func)
    def wrapper(*args, **kwargs):
        start = datetime.now()
        result = func(*args, **kwargs)
        end = datetime.now()
        print(f"{func.__name__} eseguita in {end-start} secondi")
    return wrapper

##################### CONCORRENTE FUTURES ###########################
@timer
def executor_f(concorrenza, n, stringhe):
    if concorrenza:
        futures = set()

        with concurrent.futures.ProcessPoolExecutor(max_workers=concorrenza) as executor:
            
            for i, stringa in get_jobs(stringhe):
                future = executor.submit(job, n, i, stringa)
                futures.add(future)

        sommario = wait_for(futures)

        for result in sommario:
            print(result)


def get_jobs(stringhe):
    for k, s in enumerate(stringhe):
        yield (k, s)


def job(n, i, stringa):
    l = []

    for _ in range((n//(10**i))):
        l.append(stringa)

    return l


def wait_for(futures):
    result = []

    for future in concurrent.futures.as_completed(futures):
        result.append(future.result())

    return result
#####################################################################

#################### CONCORRENTE QUEUE ##############################
@timer
def executor_q(concorrenza, n, stringhe):
    if concorrenza:
        jobs = multiprocessing.JoinableQueue()
        results = multiprocessing.Queue()
        create_processes(concorrenza, n, stringhe, jobs, results)
        add_jobs(stringhe, jobs)
        jobs.join()

        while not results.empty():
            print(results.get())


def create_processes(concorrenza, n, stringhe, jobs, results):
    for _ in range(concorrenza):
        process = multiprocessing.Process(target=worker, args=(n, stringhe, jobs, results))
        process.daemon = True
        process.start()


def add_jobs(stringhe, jobs):
    for k, s in enumerate(stringhe):
        jobs.put((k, s))


def worker(n, stringhe, jobs, results):
    while True:
        k, s = jobs.get()
        l= []

        for _ in range((n//(10**k))):
            l.append(s)
        
        results.put(l)
        jobs.task_done()
#####################################################################


def main():
    stringhe = ["anna", "mario"]
    n = 10
    print("---------------------------- FUTURES ----------------------------")
    executor_f(len(stringhe), n, stringhe)
    print("---------------------------- QUEUE ----------------------------")
    executor_q(len(stringhe), n, stringhe)


if __name__ == '__main__':
    main()
