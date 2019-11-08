#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

void main(){
    int fd1, fd2, n, c, buf[256];

      //opening the filedescriptor for a file that could even not exist, in the way that
      //the user can open, read and write the file but the group and the others can only read.
    if((fd1= open("3_2_file1", O_CREAT  |  O_RDWR  |  O_TRUNC, 0744))  <  0)
        write(1, "creat error\n", sizeof("creat error\n"));

    if((fd2= open("3_2_file2", O_CREAT  |  O_RDWR  |  O_TRUNC, 0744))  <  0)
        write(1, "creat error\n", sizeof("creat error\n"));

      //reading from standard input
    n= read(0, buf, 90);
       //writing on the first file
    write(fd1, buf, n);
      //getting the end pointer of the first file
    n= lseek(fd1, -1, SEEK_END);

    while (n  >=  0)  {
        read(fd1, &c, 1);
        write(fd2, &c, 1);
        n= lseek(fd1, -2, SEEK_CUR);
      }

      lseek(fd2, 0, SEEK_SET);

    while (read(fd2, &c, 1)  >  0)
        write(1, &c, 1);

      exit(0);

}
