#Scrivere la funzione procTesto all’interno del file esercizio4.py.
# Se la funzione ha bisogno di invocare altre procedure, fornire anche quest’ultime.
# La funzione procTesto prende in input una lista di nomi di file, una lista di stringhe,
# e il parametro concorrenza. La funzione procTesto deve cecare nel testo dell’i-esimo file
# della prima lista l’i-esima stringa della seconda lista e deve fare cio` con un processo
# separato per ogni coppia file-stringa. Attenzione, il callable utilizzato da procTesto
# deve riceve in input il testo del file e non il file. La funzione procTesto deve inoltre
# stampare per ciascuna coppia file-stringa se la stringa e` presente o meno nel file.
# Le stampe devono avvenire nell’ordine in cui terminano i processi e al termine degli stessi.