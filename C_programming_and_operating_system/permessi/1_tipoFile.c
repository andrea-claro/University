#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	int i;
	struct stat buf;

	for (i= 1; i  <  argc; i++){
 		printf("%s:", argv[i]);
 		if (lstat(argv[i], &buf)  <  0){
 			printf("lstat error");
 			continue;
 		}
 		if (S_ISREG(buf.st_mode)) printf("regular");
 		else if (S_ISDIR(buf.st_mode)) printf("directory");
 		else if (S_ISCHR(buf.st_mode)) printf("character special");
 		else if (S_ISBLK(buf.st_mode)) printf("block special");
	}
	exit(0);
}
