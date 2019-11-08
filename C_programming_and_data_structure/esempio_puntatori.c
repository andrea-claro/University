#include<stdio.h>

int main(){

  int x= 10,
  *p,
  **z,
  *a= &x,
  **b= &a;

  p= &x;
  z= &p;

  printf("\n\n%d\t%d\t%d\n%d\t%d\n\n", x, *p, **z, *a, **b);
  printf("\n\n%x\t%x\t%x\n%x\t%x\n\n", &x, p, *z, a, *b);

  return 0;
}
