#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void){
    
    int fdf[2];
    int fdc[2];

    pipe(fdf);
    pipe(fdc);

    pid_t child;

    int first,
        second,
        result= 0;
    char c_oper;

    child= fork();

    if(child > 0){  //father
        close(fdf[0]);
        close(fdc[1]);

        printf("insert the operand:\t");
        scanf("%c", &c_oper);
        printf("insert first operand:\t");
        scanf("%d", &first);
        printf("insert second operand:\t");
        scanf("%d", &second);
        
        write(fdf[1], &first, sizeof(first));
        write(fdf[1], &second, sizeof(second));
        write(fdf[1], &c_oper, sizeof(c_oper));

        read(fdc[0], &result, sizeof(result));
        printf("\nthe result is:\t%d\n", result);

        return 0;
    }



    else if(child == 0){    //child
        close(fdf[1]);
        close(fdc[0]);

        read(fdf[0], &first, sizeof(first));
        read(fdf[0], &second, sizeof(second));
        read(fdf[0], &c_oper, sizeof(c_oper));

        if(c_oper == '+'){
            result= first+second;
            write(fdc[1], &result, sizeof(result));
        }
        else if(c_oper == '-'){
            result= first-second;
            write(fdc[1], &result, sizeof(result));
        }
        else if(c_oper == '*'){
            result= first*second;
            write(fdc[1], &result, sizeof(result));
        }
        else if(c_oper == '/'){
            result= first/second;
            write(fdc[1], &result, sizeof(result));
        }

        exit(0);
    }
}