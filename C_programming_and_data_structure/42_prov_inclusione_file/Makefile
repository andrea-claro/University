modulo_array.o: ../moduli_programmi/modulo_array.h ../moduli_programmi/modulo_array.c
	gcc -c ../moduli_programmi/modulo_array.c -o ../moduli_programmi/modulo_array.o

42_prova_inclusione_file.o: 42_prova_inclusione_file.c
	gcc -c 42_prova_inclusione_file.c -o 42_prova_inclusione_file.o

42_prova_inclusione_file: 42_prova_inclusione_file.o ../moduli_programmi/modulo_array.o
	gcc -o 42_prova_inclusione_file 42_prova_inclusione_file.o 					../moduli_programmi/modulo_array.o

clean: 
	rm 42_prova_inclusione_file.o ../moduli_programmi/modulo_array.o
