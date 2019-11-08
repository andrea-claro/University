/*----------------------OPERATORI UTILIZZATI----------------------------------*/
/* 1) */int searchElementRicor( int *, int, object );
/* 2) */int minArrayRicor( int *, int, int );
/* 3) */int minArrayBin( int *, int, object );
/* 4) */int *deleteArrayPos( int *, int *, int );
/* 5) */int *reallocArray( int *vet, int dim );
/* 6) */int *addElement( int *, int *, object, int );
/* 7) */void printArray( int *, int );
/* 8) */int *selectionSort( int *, int );
/* 9) */void elementExchange( int *, int * );
/* 10) */int *insertArray( int *, int );
/* 11) */int *allocArray( int *, int );
/* 12) */int sumArray( int *, int );
/* 13) */int *sumPosArray( int *, int *, int, int );
/* 14) */int *productPosArray( int *, int *, int, int );
/* 15) */int sumProductPosArray( int *, int *, int, int );
/* 16) */int max2N( int, int );
/* 17) */void mergeSortRicor( int *, int, int );
/* 18) */void merge( int *, int, int, int );
/* 19) */void quickSortRicor( int [], int, int );
/* 20 */int partition ( int [], int, int );
/*----------------------------------------------------------------------------*/



/*--------------------------DESCRIZIONE OPERATORI-------------------------------
1) cercare tramite algoritmo ricorsivo un elemento nell'array
2) ricerca dell'elemento minimo in un arrat tramite algoritmo ricorsivo
3) ricerca binaria di un elemento all'interno di un array
4) cancellazione di una posizione dell'array
5) rialloca la memoria dell'array con la dimensione scelta
6) inserimento di un elemento in array
7) stampa dell'array
8) ordinamento di un array tramite algoritmo selection sort
9) scambio degli elementi dell'array tra loro
10) inserimento di dati all'interno di un array
11) allocazione in memoria di un array
12) somma totale tra gli elementi di un array
13) array somma tra posizioni i-esime di due array
14) array prodotto tra posizioni i-esime di due array
15) somma totale tra gli elementi di un array prodotto tra posizioni i_esime di due array
16) massimo tra due numeri
17) ordinamento di un vettore in maniera crescente attraverso l'algoritmo ricorsivo mergesort
18) algoritmo di fusione utilizzato nella riordinazione di un array attraverso il mergesort
19) ordinamento di un vettore in maniera crescente attraverso l'algoritmo ricorsivo quicksort
20) algoritmo di ricerca del pivot utilizzato nella riordinazione di un array attraverso il quicksort
------------------------------------------------------------------------------*/



/*-------------------------SPECIFICA SINTATTICA FILE ARRAY----------------------
1) searchElementRicor( int *, int, object ) -> int;
2) minArrayRicor( int *, int, int ) -> int;
3) minArrayBin( int *, int, object ) -> int;
4) deleteArrayPos( int *, int *, int ) -> int *;
5) reallocArray( int *, int ) -> int *;
6) addElement( int *, int *, object, int ) -> int *;
7) printArray( int *, int ) -> void;
8) selectionSort( int *, int ) -> int *;
9) elementExchange( int *, int * ) -> void;
10) insertArray( int *, int ) -> int *;
11) allocArray( int *, int ) -> int *;
12) sumArray( int *, int ) -> int;
13) sumPosArray( int *, int *, int, int ) -> int *;
14) productPosArray( int *, int *, int, int )) -> int *;
15) sumProductPosArray( int *, int *, int, int ) -> int;
16) max2N( int, int ) -> int;
17) mergeSortRicor( int *, int, int) -> void;
18) merge( int *, int, int, int ) -> void;
19) quickSortRicor( int [], int, int ) -> void;
20) partition ( int [], int, int ) -> int;
------------------------------------------------------------------------------*/



/*------------------------SPECIFICA SEMANTICA FILE ARRAY------------------------
1) searchElementRicor( x[], size, el ) -> flag
                                  pre_condition:
                                  post_condition: (flag=0 per elemento non trovato) || (flag=1 per
                                                  elemento trovato)

2) minArrayRicor( x[], size, min ) -> min'
                                  pre_condition:
                                  post_condition: (min è uguale al valore minimo presente nell'array)

3) minArrayBin( x[], size, el ) -> flag
                                  pre_condition: (x[] != NULL)
                                  post_condition: (flag=1 se l'elemento viene trovato) || (flag=0 se l'
                                                  elemento non viene trovato)

4) deleteArrayPos( x[], size, pos ) -> x'[]
                                  pre_condition: (x[] != NULL) && (pos < (size)) && (pos > 0)
                                  post_condition: (x'[] è uguale al nuovo array con l'elemento eliminato)

5) reallocArray( x[], size ) -> x'[]
                                  pre_condition:
                                  post_condition: (x'[] è uguale al nuovo array con dimensione della memoria
                                                  modificata)
6) addElement( x[], size, el, pos ) -> x'[]
                                  pre_condition: (el != NULL) && (pos < (size)) && (pos > 0)
                                  post_condition: (x'[] è uguale al nuovo array con l'elemento inserito)

7) void printArray( x[], size ) ->
                                  pre_condition: (x[] != NULL)
                                  post_condition: (stampa degli elementi di x[])

8) selectionSort( x[], size ) -> x'[]
                                  pre_condition: (vet != NULL) && (size != 0)
                                  post_condition: (x'[] è ordinato in modo crescente)

9) elementExchange( a, b ) ->
                                  pre_condition:
                                  post_condition: (a' = b) && (b' = a)

10) insertArray( x[], n ) -> x'[]
                                  pre_condition: (n != 0)
                                  post_condition: (x'[] con gli elementi scelti al suo interno)

11) allocArray( x[], size ) -> x'[]
                                  pre_condition:
                                  post_condition: (x'[] abrà memoria allocata di size grandezza)

12) sumArray( x[], size ) -> sum
                                  pre_condition: (x[] != NULL)
                                  post_condition: (sum è uguale alla somma degli elementi dell'array)

13) sumPosArray( a[], b[], size_a, size_b ) -> x[]
                                  pre_condition: (a[] != NULL) && (size_a != 0) && (size_b != 0) &&
                                                 (b[] != NULL)
                                  post_condition: (x[]= per ogni posizione i-esima a[i]+b[i])

14) productPosArray( a[], b[], size_a, size_b ) -> x[]
                                  pre_condition: (a[] != NULL) && (size_a != 0) && (size_b != 0) &&
                                                 (b[] != NULL)
                                  post_condition: (x[]= per ogni posizione i-esima a[i]*b[i])

15) sumProductPosArray( a[], b[], size_a, size_b ) -> sum
                                  pre_condition:
                                  post_condition: (sum è uguale alla somma degli elementi dell'array
                                                  x[]= per ogni posizione i-esima a[i]*b[i])

16) max2N( a, b ) -> max
                                  pre_condition:
                                  post_condition: (max è uguale al massimo del valore tra gli elementi a e b)

17) mergeSortRicor( x[], p, r) ->
                                  pre_condition:
                                  post_condition: (x'[] viene ordinato in maniera crescente)

18) merge( x[], p, q, r ) ->
                                  pre_condition:
                                  post_condition: (x'[] e x''[] vengono fusi nuovamente in x[])

19) quickSortRicor( x[], p, r ) ->
                                  pre_condition:
                                  post_condition: (x'[] viene ordinato in maniera crescente)

20) partition ( x[], p, r ) -> j
                                  pre_condition:
                                  post_condition: (scambia gli elementi di x[] a seconda del pivot p)
------------------------------------------------------------------------------*/
