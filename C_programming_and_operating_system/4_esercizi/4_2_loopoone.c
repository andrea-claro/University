/*
Esercizio 4_2
Scrivere un programma che con un loop, crea una directory e poi va in questa nuova directory.
A quale profondità si riesce ad arrivare?
*/

#include <dirent.h>

void main(){
    char cwd[999];

    getcwd(cwd, 999);

    int count= 1;

    while(1){ 
        if(mkdir("cartellone", 0644)  <  0){
            
            for(int k= count; k  >=  0; k--){
                chdir("..");
                rmdir("cartellone");
            }
            break;
        }
        else{
        count++;
        chdir("cartellone");
        }
    }

    printf("\n%d numero cartelle\n", count)

    closedir(dir);
    exit(0);
}