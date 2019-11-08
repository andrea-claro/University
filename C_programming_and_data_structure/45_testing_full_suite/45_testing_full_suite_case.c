/*************************************************************************************************
** This program is going to test a full suite of testing cases in once making possible to improve ** as most as the program can, the testing phase.
**************************************************************************************************/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include "../moduli_programmi/modulo_array.h"
/*--------------------------------------PROTOTYPES-----------------------------------------------*/
void getting_data(  FILE *, FILE *, FILE *, char *[]  );
int comparing(  char *, int, int, FILE *, FILE *, char *  );    
/*------------------------------COMPARING DATA---------------------------------------------------*/
int comparing(  char *tc_ID, int n_ID, int n, FILE *a, FILE *b, char *string ){    

	char tc_compare[3];
	int n_compare,
	    temp,
	    *input;

	while(  !feof(b)  ){

		fscanf(  b, "%s", tc_compare  );
		if(  !strcmp(tc_compare, string)  ){  
			fscanf(  a, "%d", &n_compare  );

			if(  n_ID == n_compare  ){

				input = alloca_array_interi(  input, n  );
				for(  int k = 0; k < n; k++  )
					fscanf(  a, "%d", (input+k)  );
				input = selection_sort_array_interi(  input, n  );

				for(  int k = 0; k < n; k++  )
					if(  fscanf(b, "%d", &temp) != input[k]  ){
						free(input);	
						return 0;
					}
			
				free(input);	
				return 1;
			}
		}
	}
}            
/*-----------------------------------OPERATING FUNCTION------------------------------------------*/
void getting_data(  FILE *a, FILE *b, FILE *c, char *names[]  ){

	int n,			//number of elements to write and to read
	    n_ID,		//number of the test case
	    flag;		
	char tc_ID[3],		//name of the test case
	    *string = "TC";	     

	n = atoi (  names[1]  );

	while(  !feof(a)  ){

		fscanf(  a, "%s", tc_ID  );
		if(  !strcmp(tc_ID, string)  ){

			fscanf(  a, "%d", &n_ID  );
			printf(  "\n%s %d\n", tc_ID, n_ID  );

			flag = comparing(  tc_ID, n_ID, n, a, b, string  );    
			fprintf(  c, "%s %d\t", tc_ID, n_ID);    

			if(  flag  )
				fprintf(  c, "PASS\n"  );    
			else
				fprintf(  c, "FAIL\n"  );
		}
	}
}
/*------------------------------------------MAIN-------------------------------------------------*/
int main(  int argc, char *argv[]  ){

	if(  argc != 5  ){
		printf(  "\nThere hasn't been inserted enough statements, try again."  );
		exit(0);
	}

	FILE *doc1, 	//pointing to the file suite created	
	     *doc2,	//pointing to the suite oracle created
	     *doc3; 	//pointing to the result suite 

	doc1 = fopen (  argv[2], "r"  );
	doc2 = fopen (  argv[3], "r"  );
	doc3 = fopen (  argv[4], "w"  );
	if(  !doc1 || !doc2 || !doc3 ){
		printf(  "\nThere is a file that can't be opened"  );
		exit(0);
	}

	getting_data(  doc1, doc2, doc3, argv  );	

fclose(  doc1  );
fclose(  doc2  );
fclose(  doc3  );
return 0;
}
	
