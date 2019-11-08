struct node* queue;
struct counter_nodes* head;

head createHead( void );
queue createNode( void );
int emptyTail( head, head );
int emtyNode( queue );
queue scrollForward( queue );
int sizeTail( head, head );
int pushTail( head );
queue scrollBackward( head, queue );
queue popTail( head, head );
void deleteNode( queue );
void deleteTail( head, head );
