typedef struct c_set *head;
typedef struct series *set;

void printNumber( set );
int sizeList( head );
set scrollTo( head, int );
int emptySet( head );
int emptyNumber( set );
set scrollBackward( set, head );
set scrollForward( set );
head createHead( void );
set createSet( void );
head newSet( int );
int addNumber( head, object );
void printSet( head );
