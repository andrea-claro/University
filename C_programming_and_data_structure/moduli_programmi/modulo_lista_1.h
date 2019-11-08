#include <stdio.h>
#include <stdlib.h>
#include "modulo_item.h"

struct node {
  item data;
  struct node *next;
};

typedef struct c_list *list;

int size_list (list l);

list new_list(void);

int empty_list(list l);

item get_item(list l, int pos);

int position (list l, item val);

int adding_item(list l, int pos,item data);

int erasing(list l, int pos);

list reversing(list l);

void print_list(list l);

list clone_list(list l);

void deleting_list(list l);
