modulo_array.o: ../moduli_programmi/modulo_array.h ../moduli_programmi/modulo_array.c
	gcc -c ../moduli_programmi/modulo_array.c -o ../moduli_programmi/modulo_array.o

45_testing_full_suite_case.o: 45_testing_full_suite_case.c
	gcc -c 45_testing_full_suite_case.c -o 45_testing_full_suite_case.o

45_testing_full_suite_case: 45_testing_full_suite_case.o ../moduli_programmi/modulo_array.o 
	gcc -o 45_testing_full_suite_case 45_testing_full_suite_case.o ../moduli_programmi/modulo_array.o 

clean:
	rm 45_testing_full_suite_case.o ../moduli_programmi/modulo_array.o 

execute:
	./45_testing_full_suite_case 10 ../file_di_testing/45_TS_input ../file_di_testing/45_TS_oracle ../file_di_testing/45_TS_results
