# Immaginiamo che un bambino venga iscritto alla scuola media. Il bambino puo` essere in uno dei seguenti stati:
# a. iscritto: il bimbo e` inizialmente iscritto al primo anno
# b. alSecondoAnno: il bimbo e` promosso al secondo anno
# c. alTerzoAnno: il bimbo e` promosso al terzo anno
# d. diplomato: al termine del terzo, il bimbo consegue il diploma di scuola media.
# La classe Bambino ha il metodo succ per passare allo stato successivo,
# il metodo pred per passare a quello precedente (retrocesso in caso di debiti formativi non recuperati)
# e il metodo salta_anno per saltare un anno (da iscritto si salta al terzo anno e dal secondo anno al diploma).
# Lo stato iscritto non ha stati che lo precedono; lo stato diplomato non ha stati che vengono dopo di esso.
# La classe Bambino ha anche un metodo stampaStato per stampare lo stato del bambino.
# Scrivere la classe Bambino usando un approccio state-specific in cui lo stato del bambino e` una proprieta`.
# Non usare altre classi oltre la classe Bambino.