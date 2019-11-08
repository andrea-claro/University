#include <sys/types.h>
#include <fcntl.h>
#include <sys/stat.h>

int main(void){
	int fd;

	fd=open("FILE",O_RDONLY);

	exit(0);
}
