lista_progr.exe:	item-int.o item-string.o list.o lista_progr.o
	gcc item-int.o item-string.o list.o lista_progr.o -o lista_progr.exe

item-int.o:	item-int.c item.h
	gcc -c item-int.c

item-string.o:	item-string.c item.h
	gcc -c item-string.c

list.o:	list.c list.h item.h
	gcc -c list.c

lista_progr.o:	lista_progr.c list.h item.h item-int.h item-string.h
	gcc -c lista_progr.c

clean:	
	rm -f lista_progr.o list.o item-int.o item-string.o lista_progr.exe