#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>

void main(char* argv[]){

  printf("\ninizio\n");
  if(symlink(argv[1], argv[2])  !=  0)
      printf("\nerrore\n");

  exit(0);
}
