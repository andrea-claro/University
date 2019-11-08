#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

	/*esempio di utilizzo di umask*/

int main(void){
	umask(0);

	if(creat("foo",S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH)  <  0)
		printf("creat error for foo \n");

	umask(S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH);/* 0066 */

	if(creat("bar",S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH)  <  0)
		printf("creat error for bar \n");

	exit(0);
}
