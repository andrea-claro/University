/*********************************************************************************************************************
** This file is part of the list ADT file construction, it serves to produce the base commands to returning a list
*********************************************************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include "../moduli_programmi/modulo_item.h"
#include "../moduli_programmi/modulo_lista.h"

/*------------------------------------------------------MAIN--------------------------------------------------------*/
int main(  void  ){

  list l = new_list(), l2;
  int n;
  item e;

  if(  !l  )
    printf(  "Errore\n"  );

  printf(  "inserisci la quantita' : "  );
  scanf(  "%d",&n  );

  for(  int i = 0; i < n; i++  ){
    printf(  "inserisci l'elemento  : "  );
    input_item(  &e  );
    if(  !adding_item(  l, 0, e  )  )
      printf(  "Errore\n"  );
  }

  print_list(  l  );
  l = reversing(  l  );
  print_list(  l  );
  addItem(  l, 3, 5  );
  print_list(  l  );
  erasing(  l, 2  );
  print_list(  l  );
  l2 = clone_list(  l  );
  print_list(  l2  );
  return 0;
}
