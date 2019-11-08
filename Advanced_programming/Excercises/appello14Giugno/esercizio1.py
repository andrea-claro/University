#Scrivere nel file esercizio1.py una coroutine selezionatore(n,ricevitore)
# che prende in input un intero n e una coroutine ricevitore e si comporta
# come segue: ogni volta che riceve un testo, cerca al suo interno le stringhe
# di lunghezza maggiore di n e le invia al ricevitore. Scrivere inoltre una
# coroutine archivista(archivio) che ogni volta che riceve una stringa la
# inserisce nel file di nome archivio seguita da uno spazio. Il parametro
# ricevitore e` una coroutine archivista.
# Suggerimento: potete usare re.findall(r'\w+', testo) per estrarre parole da testo.

