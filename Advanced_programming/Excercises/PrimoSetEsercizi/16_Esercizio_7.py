#Scrivere una classe di base ClsBase in cui c’e`un metodo addAttr che
# prende in input due argomenti: una stringa s e un valore v,
# controlla se la classe ha l’attributo di nome s
# e se tale attributo non e`presente allora aggiunge alla classe
# l’attributo s con valore v; in caso contrario non fa niente.
# Il metodo deve funzionare anche per le eventuali sottoclassi di ClsBase

class ClsBase:

    def addAttr(self, s, v):
        if not hasattr(ClsBase.__dict__, s):
            setattr(ClsBase, s, v)

# class ClsBase:
#
#
#     def addAttr(self, s, v):
#         if s not in self.__dict__:
#             setattr(self, s, v)
#
#
# x= ClsBase()
# print(ClsBase)
# y= "miao"
# print("y" in x.__dict__)
# x.addAttr("y", y)
# print("y" in x.__dict__)
#