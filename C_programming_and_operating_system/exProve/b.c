#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
void exit1(void);
void exit2(void);
int main(void) {
int pid;
char array[]="Dopo\n";
atexit(exit1);
printf("Prima");
if((pid=fork())<0)
 exit(1);
if(pid==0) {
 atexit(exit2);
 printf("Sono il figlio");
 write(1,array,5);
 exit(0);
 }
wait(NULL);
printf("Sono il padre");
write(1,array,5);
printf("Fine esecuzione");
exit(0);
}
 void exit1(void) {
 printf("Sono il primo handler");
}
 void exit2(void) {
 printf("Sono il secondo handler");
}