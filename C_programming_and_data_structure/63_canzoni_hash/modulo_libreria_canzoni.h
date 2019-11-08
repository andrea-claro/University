typedef struct libreria_canzoni* lib;

lib newLib( int, char* );
int deleteSong( lib, char* );
int searchSong( lib, char* );
int insertSong( lib, object );
