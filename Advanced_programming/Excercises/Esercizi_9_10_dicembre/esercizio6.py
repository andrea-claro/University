# Scrivere una classe LaureaT_Student che può essere osservata e che ha i seguenti attributi
# che ne determinano lo stato:
# 
# total_cfu: numero di cfu acquisiti
# 
# english_r: booleano settato a False (valore di default) se e solo se lo studente non ha 
# la prova di inglese
# 
# grades: dizionario degli esami sostenuti con elementi con chiave uguale al nome dell'esame
# e valore uguale al voto (exam name, grade)
# 
# exam: una tupla del tipo definito Exam = collections.nametuple("Exam", "name cfu")
# 
# Gli attributi total_cfu e english_r sono accessibili con il loro nome e modificabili
# con "=" mentre grades è modificabile con il metodo add_grades che prende in input come
# primo argomento un oggetto Examm e come secondo argomento un int che rappresenta il voto


# Scrivere inoltre i due observer HistoryView e LiveView:
# 
# HistoryView mantiene una lista di triple della forma(dizionario degli esami sostenuti,
# booleano che indica se inglese superato, data cambio stato). Ciascuna tripla è creata
# quando l'oggetto LaureaT_Student cambia stato.
# 
# LiveView esengue le stampe:
# print("Cambio stato: lo studente ha appena superato la prova di Inglese\n")
# se il cambio di stato e`dovuto al superamento della prova di inglese
# print("Cambio stato: lo studente ha superato un nuovo esame")
# print("Cambio stato: il numero di CFU e`: " , student.total_cfu,"\n")
# se il cambio di stato e`dovuto al superamento di un nuovo esame
import collections
import datetime
import itertools
import time
import copy

Exam=collections.namedtuple("Exam", "name cfu")


class Observed:
    def __init__(self):
        self.__observers = set()

    def observers_add(self, observer, *observers):
        for observer in itertools.chain((observer,), observers):
            self.__observers.add(observer)
            observer.update(self)

    def observer_discard(self, observer):
        self.__observers.discard(observer)

    def observers_notify(self):
        for observer in self.__observers:
            observer.update(self)


class LaureaT_Student(Observed):

    class MyDict(dict):

        def __init__(self):
            super().__init__()

        def __setattr__(self, name, value):
            raise Exception("####")


    def __init__(self, cfu):
        super().__init__()
        self._total_cfu = cfu
        self._english_r = False
        self.grades = LaureaT_Student.MyDict()


    def add_grade(self, infoExam, gradeExam):
        self.grades[infoExam[0]] = gradeExam
        self._total_cfu += infoExam[1]
        self.observers_notify()

    @property
    def total_cfu(self):
        return self._total_cfu


    @total_cfu.setter 
    def total_cfu(self, cfu):
        self._total_cfu = cfu
        self.observers_notify()
        

    @property
    def english_r(self):
        return self._english_r


    @english_r.setter 
    def english_r(self, bool):
        self._english_r = bool
        if bool is True:
            self.observers_notify()

        
class HistoryView:
    
    def __init__(self):
        self.data = []

    def update(self, obj):
        self.data.append((copy.copy(obj.grades), obj.english_r, time.time()))


class LiveView:

    def __init__(self):
        self._oldEng = False
    
    def update(self, obj):
        if obj.english_r is True and self._oldEng is False:
            self._oldEng = True
            print("Cambio stato: lo studente ha appena superato la prova di Inglese\n")

        elif obj.total_cfu > 0:
                print("Cambio stato: lo studente ha superato un nuovo esame")
                print(f"Cambio stato: il numero di CFU e`: {obj.total_cfu}\n")


def main():
    historyView = HistoryView()
    liveView = LiveView()
    student = LaureaT_Student(0) 
    student.observers_add(historyView, liveView)
    print("Lo studente sta per superare analisi matematica")
    student.add_grade(Exam("analisi matematica",9),28)
    print("Lo studente sta per superare sistemi operativi")
    student.add_grade(Exam("sistemi operativi",6),20)
    print("Lo studente sta per superare la prova di Inglese")
    student.english_r = True
    
    for grades, flag, timestamp in historyView.data:
        print("Esami: {}, Inglese: {}, Data: {}".format(grades, "superato" if flag else "non superato", datetime.datetime.fromtimestamp(timestamp)))

        
if __name__ == "__main__":
    main()


"""Il programma stampa:

Lo studente sta per superare analisi matematica
Cambio stato: lo studente ha superato un nuovo esame
Cambio stato: il numero di CFU e` :  9 

Lo studente sta per superare asistemi operativi
Cambio stato: lo studente ha superato un nuovo esame
Cambio stato: il numero di CFU e` :  15 

Lo studente sta per superare la prova di Inglese
Cambio stato: lo studente ha appena superato la prova di Inglese

Esami: {}, Inglese: non superato, Data: 2019-12-10 10:54:41.413786
Esami: {'analisi matematica': 28}, Inglese: non superato, Data: 2019-12-10 10:54:41.474924
Esami: {'analisi matematica': 28}, Inglese: non superato, Data: 2019-12-10 10:54:41.658306
Esami: {'analisi matematica': 28, 'sistemi operativi': 20}, Inglese: non superato, Data: 2019-12-10 10:54:41.707940
Esami: {'analisi matematica': 28, 'sistemi operativi': 20}, Inglese: non superato, Data: 2019-12-10 10:54:41.908861
Esami: {'analisi matematica': 28, 'sistemi operativi': 20}, Inglese: superato, Data: 2019-12-10 10:54:41.959334

"""
