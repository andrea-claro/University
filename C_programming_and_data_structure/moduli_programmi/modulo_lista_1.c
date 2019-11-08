/*********************************************************************************************************************
** This file is part of the list ADT file construction, it serves to produce simple function that makes the program
*   to work
*********************************************************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "modulo_item.h"
#include "modulo_lista.h"

/*-----------------------------------------------PROTOTYPES WITH THE INFORMATION HIDING--------------------------*/
static struct node* add_node(  struct node* n, int pos, item data  );
static struct node* make_node(  struct node* l, item data  );
static struct node* erase_node(  struct node* n, int pos  );

/*------------------------------BUILDING THE STRUCTURE FOR THE LIST------------------------------------------------*/
struct c_list {
     struct node *first;
     int size;
};

/*--------------------------------------------------RETURNING THE SIZE OF THE LIST--------------------------------*/
int size_list(  list l  ){

    if(  l == NULL  )
      return -1;

    return l->size;
}

/*---------------------------------------------ALLOCATING THE SPACE FOR A LIST POINTER---------------------------*/
list new_list(  void  ){

     struct c_list *l;

     l = malloc(  sizeof(  struct c_list  )  );
     if(  l != NULL  ){
     	l->first = NULL;
      l->size = 0;
     }

     return l;
}

/*---------------------------------------CONTROLLING THAT THE LIST IS EMPTY OR NOT------------------------------*/
int empty_list(  list l  ){
      return(  l == NULL  ) ? -1 : (  l->size == 0  );
}

/*-------------------------------GETTING ELEMENTS FOR THE LIST-------------------------------------------------*/
item get_item(  list l, int pos  ){

    if (  l == NULL || pos < 0 || pos >= l->size  )
      return NULLITEM;

    struct node *temp = l->first; // temp is used to scroll the list

    for(  int i = 0; temp; i++, temp = temp->next  )
      if(  pos == i  )
        return temp->data;
}

/*--------------------------------------SEARCHING THE POSITION OF THE LIST ELEMENT-----------------------------*/
int position (  list l, item val  ){

    if(  l == NULL  )
	   return -1;

    struct node *temp = l->first;

    for(  int i=0; temp; i++, temp=temp->next  )
      if(  compare_item(  temp->data,val  )  )
        return i;

    return -1;
}

/*----------------------------------ADDING AN ELEMENT TO THE LIST--------------------------------------------*/
int adding_item(  list l, int pos, item data  ){

    if (  l == NULL || pos < 0 || pos > l->size  )
        return NULLITEM;

    struct node* temp = add_node(  l->first, pos, data  );

    if(  !temp  )
      return 0;

    l->size++;
    l->first = temp;

    return 1;
}

/*-------------------------------DELETING AN ELEMENT OF THE LIST---------------------------------------------*/
int erasing(  list l, int pos  ){

  if (  l == NULL || pos<0 || pos>=l->size  )
    return NULLITEM;

  struct node* temp=erase_node(l->first,pos);

  if(!temp)
    return 0;

  l->size--;
  l->first = temp;

  return 1;
}

/*------------------------------------CREATING A SECOND LIST THAT IS THE REVERSE OF THEE FIRST ONE---------*/
list reversing(  list l  ){

  list l2 = new_list();

  if(  !l  )
    return NULL;

  struct node* temp=l->first;

  for(  int i=0; temp; temp = temp->next, i++  )
    if(  !adding_item(  l2, 0, get_item(  l, i  )  )  )
      return NULL;

  return l2;
}

/*----------------------------------PRINTING A LIST--------------------------------------------------------*/
void print_list(  list l  ){

  int i;

  if(  !l  )
    return;

  struct node* temp=l->first;

  for(  int i = 0; temp; temp = temp->next, i++  ){
    printf(  "POS %d : ", i  );
    print_item(  temp->data  );
    printf(  " ; "  );
  }
  printf("\n");
}

/*-----------------------------------ADDING A STRUCT NODE WITH THE INFORMATION HIDING TECHNIQUE---------------------*/
static struct node* add_node(  struct node* n, int pos, item data  ){

    struct node* temp = n;

    if(  pos == 0  ){
        n = make_node(  n, data  );
        return n;
    }

    for(  int i = 0; temp; i++, temp = temp->next  )
      if(  pos-1 == i  )
        if(  !(  temp->next = make_node(  temp->next, data  )  )  )
          return NULL;

    return n;
}

/*---------------------------------CREATING A STRUCT NODE WITH THE INFORMATION HIDING TECHNIQUE---------------------*/
static struct node* make_node(struct node* l,item data){

  struct node *nuovo;

  nuovo=(struct node*)malloc(sizeof(struct node));
  if(!nuovo){
    printf("Errore allocazione della memoria\n");
    return NULL;
  }

  nuovo->next=l;
  nuovo->data=data;

  return nuovo;
}

/*---------------------------------DELETING A STRUCT NODE WITH THE INFORMATION HIDING TECHNIQUE---------------------*/
static struct node* erase_node(  struct node* n, int pos  ){

    struct node* temp = n; struct node* c = n;

    if(  pos == 0  ){
      n = n->next;
      temp = NULL;
      return n;
    }

    for(  int i = 0; c; c = c->next, i++  )
      if(  pos-1 == i  ){
        temp = c->next;
        c->next = temp->next;
        temp = NULL;
      }

    return n;
}

/*------------------------------------------------CLONING THE LIST------------------------------------------------*/
list clone_list(  list l  ){

  list l2 = new_list();

  l2 = reversing(  l  );
  l2 = reversing(  l  );

  return l2;
}

/*---------------------------------------------DELETING THE LIST--------------------------------------------------*/
void deleting_list(  list l  ){

  if(  !l  )
    return;

  struct node* temp = l->first; struct node* c;

  while (  temp  ) {
    c = temp;
    temp = temp->next;
    c = NULL;
  }

  l = NULL;
}
