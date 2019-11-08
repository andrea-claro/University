typedef struct counter_stack* head;
typedef struct node* pile;
typedef char* object;

int sizeStack( head );
int getItem( head );
int pop( head );
int pushStack( head, int );
int emptyStack( head );
pile createNode( void );
head createHead( void );
