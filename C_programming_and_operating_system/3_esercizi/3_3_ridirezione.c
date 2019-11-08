#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

void main(){
    int fd1, fd2, fdin, fdout;

    /*
    if(fd1= open("3_3_1_es", O_CREAT  |  O_RDWR  |  O_TRUNC, 0744)  <  0)
        printf("open error\n");
    if(fd2= open("3_3_2_es", O_RDWR, 0744)  <  0)
        printf("open error\n");
    */

    FILE *in, *out;

    in=fopen("3_3_file1","r");
    out=fopen("3_3_file2","w+");
    fd1=fileno(in);
    fd2=fileno(out);

    fdin= dup(STDIN_FILENO);
    fdout= dup(STDOUT_FILENO);

    dup2(fd1, STDIN_FILENO);
    dup2(fd2, STDOUT_FILENO);

    char c;
    while((c= getchar())  !=  '\n'){
        putchar(c);
    }

    exit(0);
}
