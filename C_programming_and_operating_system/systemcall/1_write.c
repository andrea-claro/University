#include <sys/types.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>

int main(void){
	int fd,i;
	char buf[20];

	fd=open("FILE",O_RDONLY);
	i=lseek(fd,50,SEEK_CUR);

	read(fd,buf,20);
	write(1,buf,20);

	exit(0);
}
