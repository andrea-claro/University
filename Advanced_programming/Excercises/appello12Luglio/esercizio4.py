#Scrivere la funzione conta all’interno del file esercizio4.py.
# Se la funzione ha bisogno di invocare altre procedure, fornire anche quest’ultime.
# La funzione conta prende in input una stringa parola, una lista di nomi di file listaFile
# e il parametro concorrenza. Facendo uso di Futures e Multiprocessing, la funzione
# conta deve contare quante volte parola appare in ciascuno dei file di listaFile e
# stampare per ciascun file l’intero computato. Cio` deve essere fatto con un processo
# separato per ogni file di listaFile e le stampe devono essere effettuate nell’ordine
# in cui terminano i processi. Il callable usato da conta deve prendere in input la lista
# di file e la parola.

def conta(parola, concorrenza, *fileNames):

