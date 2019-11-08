	/* File: seek.c */

#include <sys/types.h>
#include <fcntl.h>

int main(void){
	off_t i;
	int fd;
	char s[25];

	fd=open("seek.c",O_RDONLY);
	i=lseek(fd, 30, SEEK_CUR);

	printf("posizione corrente %d\n", i);

	read (fd, s, 20);

	printf ("leggo da: \n %s\n", s);

	exit(0);
}
