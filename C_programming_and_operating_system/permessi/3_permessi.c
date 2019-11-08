#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

int main(char *argv[]){
  struct stat statbuf;

  printf("\nciao \n%s\n", argv[1]);

  if(stat(argv[1], &statbuf)  <  0)
    printf("stat error");

    printf("\nci arrivo\n");

 // turn on set-group-ID and turn off group-execute
  if(chmod(argv[1], (statbuf.st_mode & ~S_IXGRP) | S_ISGID)  <  0)
    printf("chmod error for %s", argv[1]);

 // set absolute mode to "rw-r--r--"
 if(chmod(argv[1], S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH)  <  0)
    printf("chmod error for %s", argv[1]);

 exit(0);
}
