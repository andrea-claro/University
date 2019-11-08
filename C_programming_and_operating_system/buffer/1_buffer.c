#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>


int main(void)
{
char *stringa="Uno alla volta?";
while (*stringa) {
 putchar(*stringa++);
 sleep(1); /* fermiano il processo per un
secondo */
 }
putchar('\n');
sleep(4);
return(0);
}
