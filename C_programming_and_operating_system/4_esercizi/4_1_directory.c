/*
Creare un link simbolico con il comando ln -s.
Scrivere un programma che selezioni il link nella directory e stampi a video il contenuto del file 
a cui punta il link.
*/
#include <sys/types.h>
#include <dirent.h>
#include <sys/stat.h>
#include <sys/types.h>
#include  <unistd.h>
#include  <fcntl.h>
#include <stdio.h>

void main(){
    DIR* direttore;
    char cwd[64];

    getcwd(cwd, 64);

    if( (direttore= opendir(cwd))  == NULL)
        write(1, "opening error\n", sizeof("opening error\n"));

    rewinddir(direttore);

    struct dirent* dottore;
    struct stat* buf;
    char c;
    int fd;

    /* stampa dei nomi dei file contenuti nella directory */
    while (dottore = readdir(direttore)){
        if (dottore->d_ino != 0){
            printf("%s\n", dottore->d_name);
            
            lstat(dottore->d_name, buf);
            if(S_ISLNK(buf->st_mode)){
                printf("Trovato il link %s\n",dottore->d_name);
           
                fd= open(dottore->d_name,O_RDONLY);
                while( read(fd, &c, 1) > 0) 
                    write(STDOUT_FILENO, &c, 1); 
            }
        }
    }

    closedir(direttore);

}