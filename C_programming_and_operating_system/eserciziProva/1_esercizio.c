/*
Scrivere un programma che prenda come primo parametro sulla riga di comando il nome di un file
o una directory (pathname relativo o assoluto) e fornisca in uscita le seguenti informazioni:
 “DIR” se si tratta di una directory, “File” altrimenti
 Numero di file presenti nella directory (se si tratta di una directory)
 Dimensione (in entrambi i casi)
 ID del proprietario
 Numero di link
*/

#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void main(void){

    char cwd[64];
    DIR* dir= opendir(getcwd(cwd, 64));
    struct dirent* dor;
    struct stat buf;
    int countFile= 0;
    int countLink= 0;

    //temporary variables used to scan a directory
    DIR* tmp1;
    struct dirent* tmp2;
    char tmp[64];
    
    //variable that store the name of the root directory
    strcpy(tmp, cwd);

    while ((dor= readdir(dir))  !=  NULL){
        countFile++;
        lstat(dor->d_name, &buf);

        if(S_ISLNK(buf.st_mode)){
            countLink++;
        }
        else if(S_ISREG(buf.st_mode)){
            printf("%s FILE di peso %ld con user %d e %ld link\n", dor->d_name, buf.st_size, buf.st_uid, buf.st_nlink);
        }
        else if(S_ISCHR(buf.st_mode)){
            printf("%s CHARACTER di peso %ld con user %d e %ld link\n", dor->d_name, buf.st_size, buf.st_uid, buf.st_nlink);
        }
        else if(S_ISDIR(buf.st_mode)){
            printf("%s DIR di peso %ld con user %d e %ld link\n", dor->d_name, buf.st_size, buf.st_uid, buf.st_nlink);
            chdir(dor->d_name);
            tmp1= opendir(getcwd(cwd, 64));
            int k= 0;
            while((tmp2= readdir(tmp1))  !=  NULL){
                k++;
            }
            printf("con %d file dentro\n", k);
            chdir(tmp);
        }
    }
    printf("# link= %d\n", countLink);
    printf("# file= %d\n", countFile);

    exit(0);
}