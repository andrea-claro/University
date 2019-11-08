#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "../moduli_programmi/modulo_array.h"

#define NUM_SOL 2		//number of solution in the second grade equation
#define NUM_COEF 3		//number of coefficients in the second grade equation


/*--------------------------------------PROTOTYPE------------------------------------------------*/
int *insert_data(  int *  );
int delta_solving(  int *  );
int *resolving(  int *, int *, int  );
void print_results(  int *, int *  );
/*--------------------------------------MAIN-----------------------------------------------------*/
void main(){

	int *equation,		//This is the array variable used for taking care of the array 						information
	    *solutions,		//This is the array variable used for taking care of the equation 						solutions
	    delta;		//Variable used to knowing information about the delta of the 						equation

	equation = insert_data (  equation  );
	delta = delta_solving(  equation  );

	if(  equation[1] && equation[2]  )
		if(  delta < 0  ){
			printf(  "\n\nThe equation delta is resulting to be lower than zero, so the equation doesn't permit any solution in the realistic case\n"  );

			exit(0);
	}

	solutions = resolving (  equation, solutions, delta  );
	
	print_results(  equation, solutions  );

free (  equation  );
free (  solutions  );
}
/*----------------------------------CREATING THE EQUATION----------------------------------------*/
int *insert_data(  int *expression  ){

	expression = alloca_array_interi(  expression, NUM_COEF  );

	do{
	printf(  "\nInsert the factor of 2nd grade: \t"  );
	scanf(  "%d", (expression+0)  );
	} while(  expression[0]<=0  );

	printf(  "Insert the factor of 1st grade: \t"  );
	scanf(  "%d", (expression+1)  );
	printf(  "Insert the factor of 0 grade: \t"  );
	scanf(  "%d", (expression+2)  );

return expression;
}
/*----------------------------------------ASSUMING DELTA VALUE-----------------------------------*/
int delta_solving(  int *expression  ){
	
	int temp;

	temp = (  (expression[1] * expression[1]) - (4 * expression[0] * expression[2])  );

return temp;
}
/*------------------------------------------OPERATING RESOLUTION---------------------------------*/
int *resolving(  int *expression, int *resolution, int delta  ){

	resolution = alloca_array_interi(  resolution, NUM_SOL  );
	
	if(  (expression[1] && expression[2])  ){
		resolution[0] = (  (-(expression[1]) - sqrt(delta)) / expression[0]  );
		resolution[1] = (  (-(expression[1]) + sqrt(delta)) / expression[0]  );
	}

	if(  !expression[2] && expression[1]  ){
		resolution[0] = 0;
		resolution[1] = (  -(expression[1] / expression[0])  );
	}

	if(  !expression[1] && expression[2]  ){
		if(  ((expression[0] > 0) && (expression[2] > 0)) || ((expression[0] < 0) && 										(expression[2] < 0))  ){
			resolution[0] = 0;
			resolution[1] = 0;
		}
		
		else{
			resolution[0] = (  -( sqrt( -(expression[2] / expression[0])) )  );
		}
	}

return resolution;
}
/*--------------------------------------PRINTING RESULTS-----------------------------------------*/
void print_results(  int *expression, int *results  ){

	system("clear");

	printf(  "The equation is resulting as [(%d)x^2 + (%d)x + (%d)] = 0", expression[0], expression[1], expression[2]  );
	printf(  "\nwith:\n\nx1 = %d\nx2 = %d\n", results[0], results[1]  );
	}
