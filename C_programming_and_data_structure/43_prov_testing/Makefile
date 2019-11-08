modulo_array.o: ../moduli_programmi/modulo_array.h ../moduli_programmi/modulo_array.c
	gcc -c ../moduli_programmi/modulo_array.c -o ../moduli_programmi/modulo_array.o

modulo_utilities.o: ../moduli_programmi/modulo_utilities.h ../moduli_programmi/modulo_utilities.c
	gcc -c ../moduli_programmi/modulo_utilities.c -o ../moduli_programmi/modulo_utilities.o

43_prova_testing.o: 43_prova_testing.c
	gcc -c 43_prova_testing.c -o 43_prova_testing.o

43_prova_testing: 43_prova_testing.o ../moduli_programmi/modulo_array.o ../moduli_programmi/modulo_utilities.o
	gcc -o 43_prova_testing 43_prova_testing.o ../moduli_programmi/modulo_array.o ../moduli_programmi/modulo_utilities.o

clean: 
	rm 43_prova_testing.o ../moduli_programmi/modulo_array.o ../moduli_programmi/modulo_utilities.o
