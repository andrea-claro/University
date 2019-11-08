/*********************************************************************************************************************
** A simple program that runs an ADT list
*********************************************************************************************************************/

#include<stdio.h>
#include<stdlib.h>

/*--------------------------------------------STRUCTURE--------------------------------------------------------------*/
struct list{
	int value;
	struct list *next;
};

/*------------------------------------------CREATING THE LIST--------------------------------------------------------*/
struct list *create(  struct list *top  ){

	struct list *new = NULL;
	int temp;

	new = malloc(  sizeof(  struct list  )  );

	printf(  "\nInsert the value:\t"  );
	scanf(  "%d", &temp  );

	new -> value = temp;
	new -> next = top;
	top = new -> next;

return new;
}

/*--------------------------------------------------PRINTING THE LIST------------------------------------------------*/
void print (  struct list *top  ){

	struct list *temp = NULL;

	temp = top;

	while(  temp != NULL  ){

		printf(  "\nValue:\t%d\n", temp -> value  );

		temp = temp -> next;
	}

}

/*--------------------------------------------MAIN-------------------------------------------------------------------*/
int main(  void  ){

	struct list *head = NULL;
	
	int flag =0;

	while(1){

		printf(  "\n1- Inserisci in lista\n2- Stampa\n3- Esci"  );
		scanf(  "%d", &flag  );

		switch(  flag  ){
	
			case 1:
				head = create(  head  );
				break;

			case 2:
				print(  head  );
				break;
			
			case 3:
				exit(1);
				break;

			default: 
				printf(  "\nError: character is not valid\n"  );
				break;
		}
	}

return 0;
}
