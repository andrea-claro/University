#include "modulo_object_struct.h"

typedef struct classifique* class;

class createClass( char* );
int insertClass( class, int );
int searchClass( char*, class );
int updateClass( class, char*, char*, int, int );
void printClass( class );
