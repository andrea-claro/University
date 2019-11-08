typedef struct exam* item;

item newItem( void );
void printItem( struct exam * );
item insertItem(struct exam *);
int searchItem( struct exam *, char * );
