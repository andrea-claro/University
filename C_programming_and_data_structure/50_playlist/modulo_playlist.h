typedef struct playlist* play;

play createPlaylist( void );
play insertPlaylist( int, char * );
int deletePlaylist( play );
int addingSong( play, int );
int deleteSong( play, int );
int searchSong( play, object );
void printPlaylist( play );
