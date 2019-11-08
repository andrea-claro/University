modulo_item.o: ../moduli_programmi/modulo_item.h ../moduli_programmi/modulo_item.c
	gcc -c ../moduli_programmi/modulo_item.c -o ../moduli_programmi/modulo_item.o

modulo_lista.o: ../moduli_programmi/modulo_lista.h ../moduli_programmi/modulo_lista.c
	gcc -c ../moduli_programmi/modulo_lista.c -o ../moduli_programmi/modulo_lista.o

46_prova_list.o: 46_prova_list.c
	gcc -c 46_prova_list.c -o 46_prova_list.o

46_prova_list: 46_prova_list.o ../moduli_programmi/modulo_item.o ../moduli_programmi/modulo_lista.o
	gcc -o 46_prova_list 46_prova_list.o ../moduli_programmi/modulo_item.o ../moduli_programmi/modulo_lista.o

clean:
	rm ../moduli_programmi/modulo_item.o ../moduli_programmi/modulo_lista.o 46_prova_list.o
