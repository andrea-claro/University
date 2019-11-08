#include <stdio.h>

int main()
{
  int var=8, *p;
  printf("%d\n", var);
  printf("%p\n", p);

  p=&var;

  printf("%p\n", p);
  printf("%p\n", &var);

  printf("%d\n", *p);
  var++;
  printf("%d\n", *p);
  (*p)++;
  printf("%d\n", *p);
return 0;
}
