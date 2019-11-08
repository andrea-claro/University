#include<stdio.h>
#include<stdlib.h>

void quicksort(int [], int, int);
int partition (int [], int, int);

int main(){

  int a[5];

  for( int k = 0; k < 5; k++ )
    scanf("%d", &a[k]);

  printf("\n\n");
  for( int k = 0; k < 5; k++ )
    printf("%d   ", a[k]);

  quicksort( a, 0, (5-1) );

  printf("\n\n");
  for( int k = 0; k < 5; k++ )
    printf("%d   ", a[k]);

  printf("\n\n");

  return 0;
}


int partition (int A[], int p, int r){
  int x, i, j, temp;
  x = A[p];              // pivot
  i=p-1;
  j=r+1;
  while (i < j){
    while(A[--j] > x);  // esce se A[j]<=x
    while(A[++i] < x);  // esce se A[i]>=x
    if(i<j){            // scambia A[i] <-> A[j]
      temp = A[i]; A[i] = A[j]; A[j] = temp;
    }
  }
return(j);
}

void quicksort(int A[], int p, int r)
{
  int q;
  if(p < r){
    q = partition(A, p, r);
    quicksort(A, p, q);
    quicksort(A, q+1, r);
  }
}
