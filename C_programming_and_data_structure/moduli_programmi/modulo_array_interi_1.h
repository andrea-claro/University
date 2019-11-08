int *scelta_input_array_interi(  int *, int *  );
/**************************************************************************************************
						The function has been created to write a numeric array;

						Pre-condition: the choice of the dimension has to be more or equal of zero;

						Post-condition: there should need to be enough space to write the numeric array;
**************************************************************************************************/

int *selection_sort_array_interi(  int *, int  );
/**************************************************************************************************
						The function serves to put in order a numeric array;

						Pre-condition: the numeric array should be at least of size two;
**************************************************************************************************/

void stampa_array_interi(  int *, int  );
/**************************************************************************************************
						The function serves to print a numeric array;
**************************************************************************************************/

int *inserimento_in_array_interi(  int *, int *  );
/**************************************************************************************************
						The function makes possible to insert an element in the numeric array and makes even to choose the right position where the user would put the element;

						Pre-condition: the position choosed should be of a lower dimension than the array;

						Post-condition: after operations the array has to be rewrite in a higher dimension;
**************************************************************************************************/

int *eliminazione_in_array_interi(  int *, int *  );
/**************************************************************************************************
						The function serves to delete an element of a specific position into a numeri array;

						Pre-condition: the position choosed should be of a lower dimension than the array;

						Post-condition: after operations the array has to be rewrite in a lower dimension;
**************************************************************************************************/

void minimo_array_binario_interi(  int *, int  );
/**************************************************************************************************
						The function trough a binary algorithym searchs a number that the user wants to find inside a numeric tidy array;

						Pre-condition: the number choosed has to be alive into the range beetween the lowest and the highest number of the numeri array;
**************************************************************************************************/

int *alloca_array_interi(  int *, int  );
/**************************************************************************************************
						Given a pointer that points to a numeric array and a dimension, the function allocates the needed space in memory to create the array;
**************************************************************************************************/

int *rialloca_array_interi(  int *, int  );
/**************************************************************************************************
						Given a pointer that points to a numeric array and a dimension, the function makes possible to change the size of the array;
**************************************************************************************************/

int somma_totale_array_interi(  int *, int  );
/**************************************************************************************************
						The function sums all the elements in a numeric array;
**************************************************************************************************/

int *vet_somma_array_interi(  int *, int *, int, int  );
/**************************************************************************************************
						The function makes the user to create another numeric array and then sums the K positions of two numeric array between themselves;
**************************************************************************************************/

int sommatoria_vettori_interi(  int *, int *, int, int  );
/**************************************************************************************************
						This function sums all the products obtained with the operation between the K positions of two numeric array;
**************************************************************************************************/

void scambio_tra_elementi(  int *, int *  );
