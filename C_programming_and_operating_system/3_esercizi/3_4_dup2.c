/*
copiare il contenuto di un file in un altro
usando esclusivamente read da standard input
e write su standard output. Successivamente
scrivere sul terminale la stringa “Ho finito”.
*/

#include <sys/types.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

void main(){
  int fd1, fd2;

  if( (fd1= open("3_4_file1", O_RDONLY))  <  0)
      write(1, "open error\n", sizeof("open error\n"));
  if( (fd2= open("3_4_file2", O_CREAT  |  O_TRUNC  |  O_WRONLY, 0744))  <  0)
      write(1, "open error\n", sizeof("open error\n"));

  int dupin= dup(STDIN_FILENO);
  int dupout= dup(STDOUT_FILENO);

  if(dup2(fd1, STDIN_FILENO)  <  0   ||   dup2(fd2, STDOUT_FILENO)  <  0)
      write(dupout, "dup error\n", sizeof("dup error\n"));

  char c;
  while( read(STDIN_FILENO, &c, 1)  >  0)
      write(STDOUT_FILENO, &c, 1);

  if(dup2(dupin, STDIN_FILENO)  <  0   ||   dup2(dupout, STDOUT_FILENO)  <  0)
      write(dupout, "dup error\n", sizeof("dup error\n"));

  printf("fine\n");

  exit(0);
}
