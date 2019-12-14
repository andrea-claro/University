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


# class Bambino:
# 	stati = ["iscritto", "alSecondoAnno", "alTerzoAnno", "diplomato"]
# 	ISCRITTO, IIANNO, IIIANNO, DIPLOMATO = [0, 1, 2, 3]
#
# 	def __init__(self):
# 		self._statobimbo = 0
# 		self._statoBimbo = Bambino.ISCRITTO
#
# 	@property
# 	def statoBimbo(self):
# 		if self.succ != self._succ:
# 			return Bambino.DIPLOMATO
# 		if self.pred != self._pred:
# 			return Bambino.ISCRITTO
# 		if self.succ == self._succ and self.salto_anno != self._salto_anno:
# 			return Bambino.IIIANNO
# 		return Bambino.IIANNO
#
# 	@statoBimbo.setter
# 	def statoBimbo(self, newState):
# 		if newState == Bambino.IIANNO:
# 			self.succ = self._succ
# 			self.salta_anno = self._salta_anno
# 			self.pred = self._pred
# 		if newState == Bambino.IIIANNO:
# 			self.salta_anno = lambda *args: print("Il bambino è nello stato 3_anno")
# 			self.succ = self._succ
# 			self.pred = self._pred
# 		if newState == Bambino.ISCRITTO:
# 			self.pred = lambda *args: print("Il bambino è nello stato iscritto")
# 			self.succ = self._succ
# 			self.salta_anno = self._salta_anno
# 		if newState == Bambino.DIPLOMATO:
# 			self.salta_anno = lambda *args: print("Il bambino è nello stato diplomato")
# 			self.succ = lambda  *args: print("Il bambino è già diplomato")
# 			self.pred = self._pred
#
# 	def _succ(self):
# 		self.statoBimbo = self.statoBimbo+1
#
# 	def _pred(self):
# 		self.statoBimbo = self.statoBimbo-1
#
# 	def _salta_anno(self):
# 		self.statoBimbo = self.statoBimbo+2
#
# 	def stampaStato(self):
# 		print("Il bambino è nello stato "+ Bambino.stati[self.statoBimbo])




class Bambino:
	STATE = ["ISCRITTO", "ALSECONDOANNO", "ALTERZOANNO", "DIPLOMATO"]
	ISCRITTO, ALSECONDOANNO, ALTERZOANNO, DIPLOMATO = [0, 1, 2, 3]

	def __init__(self):
		self._state = 0
		self.state = Bambino.ISCRITTO

	def _pred(self):
		if self._state == Bambino.ISCRITTO:
			print("Il bambino  e` appena stato iscritto al I anno e non puo` tornare in uno stato precedente")
		else:
			self._state =  self._state-1

	def _succ(self):
		if self._state == 3:
			print("Il bambino  si e` gia` diplomato e non puo` avanzare in uno stato successivo")
		else:
			self._state = self._state+1

	def stampaStato(self):
		print("Il bambino è nello stato {}".format(Bambino.STATE[self.state]))

	def _salta_anno(self):
		if self._state == 2:
			print("Il bambino e` nello stato alTerzoAnno  e non puo` saltare un anno")
		else:
			self._state = self._state+2

	@property
	def state(self):
		return self._state

	@state.setter
	def state(self, newState):
		if newState == Bambino.ISCRITTO or newState == Bambino.ALSECONDOANNO or newState == Bambino.ALTERZOANNO or newState == Bambino.DIPLOMATO:
			self.succ = self._succ
			self.pred = self._pred
			self.salta_anno = self._salta_anno
		else:
			print("Immesso uno stato sbagliato")

def main():
	bambino = Bambino()
	bambino.stampaStato()
	bambino.pred()
	bambino.succ()
	bambino.stampaStato()
	bambino.succ()
	bambino.stampaStato()
	bambino.salta_anno()
	bambino.succ()
	bambino.stampaStato()
	bambino.succ()

if __name__== "__main__":
	main()



"""IL programma deve stampare:

Il bambino e` nello stato  iscritto
Il bambino  e` appena stato iscritto al I anno e non puo` tornare in uno stato precedente
Il bambino e` nello stato  alSecondoAnno
Il bambino e` nello stato  alTerzoAnno
Il bambino e` nello stato alTerzoAnno  e non puo` saltare un anno
Il bambino e` nello stato  diplomato
Il bambino  si e` gia` diplomato e non puo` avanzare in uno stato successivo
"""