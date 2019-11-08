#include <sys/types.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>

int main(void){
	int fd,i;

	fd=open("FILE",O_RDONLY);
	i=lseek(fd,50,SEEK_CUR);

	exit(0);
}
