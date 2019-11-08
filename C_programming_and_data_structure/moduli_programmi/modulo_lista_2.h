typedef struct node* list;
typedef struct counter_nodes* head;

head addingNode( int, head );
void addingObject( int,/* object,*/ head );
int posList( /*object,*/ head );
int emptyList( head );
list getNode( int, head );
int sizeHead( head );
list createList( void );
head createHead( void );
void deleteNode( list );
head deletePos( int, head );
head deleteList( head );
void printNode( list );
void printList( head );
void printPos( int pos, head top );
