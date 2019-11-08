struct node* queue;
struct counter_nodes* head;

head createHead( void );
queue createNode( void );
int emptyTail( head );
int emtyNode( queue );
queue scrollForward( queue );
int sizeTail( head );
int pushTail( head );
queue scrollBackward( head, queue );
queue popTail( head );
void deleteNode( queue );
void deleteTail( head );
