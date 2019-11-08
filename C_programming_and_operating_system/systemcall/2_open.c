#include <sys/types.h>
#include <fcntl.h>
#include <sys/stat.h>

int main(void){
	int fd;

	fd=open("FILE1",O_CREAT|O_EXCL|O_WRONLY,0600);

	exit(0);
}
