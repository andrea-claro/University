modulo_array.o: ../moduli_programmi/modulo_array.h ../moduli_programmi/modulo_array.c
	gcc -c ../moduli_programmi/modulo_array.c -o ../moduli_programmi/modulo_array.o

44_risoluzione_equazione_secondo_grado.o: 44_risoluzione_equazione_secondo_grado.c
	gcc -c 44_risoluzione_equazione_secondo_grado.c -o 44_risoluzione_equazione_secondo_grado.o

44_risoluzione_equazione_secondo_grado: 44_risoluzione_equazione_secondo_grado.o ../moduli_programmi/modulo_array.o 
	gcc -lm -o 44_risoluzione_equazione_secondo_grado 44_risoluzione_equazione_secondo_grado.o ../moduli_programmi/modulo_array.o

clean: 
	rm 44_risoluzione_equazione_secondo_grado.o ../moduli_programmi/modulo_array.o
