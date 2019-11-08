#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
int main(void)
{
int fd1, fd2;
char s[3];
if ((fd1=open("File",O_RDONLY))<0) {printf("errore\n"); exit(0);}
read(fd1,s,3);
write(1,s,3);
exit(0);
}