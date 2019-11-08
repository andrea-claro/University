#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

void main(){

    int fd1;
    char buf1[]="prima del buco";
    char buf2[]="dopo il buco";
      //opening the filedescriptor for a file that could even not exist, in the way that
      //the user can open, read and write the file but for the group and the other.
    fd1= open("3_1_file1" , O_CREAT  |  O_RDWR  |  O_TRUNC, 0744);

    printf("write with a hole inside\n");
      //writing in the first file
    if(write(fd1, &buf1, sizeof(buf1)-1)  ==  -1  ||  lseek(fd1, 20, SEEK_CUR)  ==  -1)
        printf("\n write error\n");
    if(write(fd1, &buf2, sizeof(buf2)-1)  ==  -1)
        printf("\n write error\n");

    int fd2;
      //opening the filedescriptor for a file that could even not exist, in the way that
      //the user can open, read and write the file but for the group and the other.
    fd2= open("3_1_file2" , O_CREAT  |  O_RDWR  |  O_TRUNC, 0744);

    if(lseek(fd1, 0, SEEK_SET)  ==  -1)
        printf("\nerror\n");

    char c;

    printf("\nwriting the second file\n");
      //writing in the second file taking off the whole
    while(  read(fd1, &c, 1)  )
        if(c  !=  '\0')
            write(fd2, &c, 1);

    if(close(fd1) == -1  &&  close(fd2) == -1)
        printf("\nclosing error\n");

    exit(0);
}
