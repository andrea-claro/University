typedef struct hash* hashtable;

item HashSearch( struct hash *, char * );
int HashInsert( struct hash *, char *, int, int );
int hash1( char *, int );
int hash2( char *, int );
void DestroyHash( hashtable );
int DeleteHash( hashtable, char * );
struct elem* SearchHash( hashtable, char * );
hashtable newHashtable( int );
int InsertHash( hashtable, struct elem* );
