/*
 * randomtestadventurer.c
 *
 
 */

/*
 * Include the following lines in your makefile:
 *
 * cardtest4: cardtest4.c dominion.o rngs.o
 *      gcc -o cardtest1 -g  cardtest4.c dominion.o rngs.o $(CFLAGS)
 */
#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

#define DEBUG 0
#define NOISY_TEST 1


int checkBaron(int p, struct gameState *post) {
  int r;
  int cardDrawn;
  int pretreasureinhand = 0;
  int posttreasureinhand = 0;
   
  int handpos = 0, choice1 = 1, choice2 = 0, choice3 = 0, bonus = 0;
  struct gameState pre;
  memcpy (&pre, &post, sizeof(struct gameState));
 
}
 
 

int main () {

  int i, n, r, p, deckCount, discardCount, handCount;

  int card;
  int choice1;
  int choice2;
  int choice3;
  int handPos;
  int bonus;
  int drawntreasure;
  int currentPlayer;
  int cardDrawn;
  int temphand[MAX_HAND];// moved above the if statement  int z3;
  int i3;
  
  struct gameState G;
  struct gameState testG;
  //struct gameState *state, 
  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};
  int pretreasureinhand = 0;
  int posttreasureinhand = 0;
   
  int handpos = 0;
  choice1 = 1;
  choice2 = 0;
  choice3 = 0;
  bonus = 0;
  printf ("Testing Baron .\n");

     for (n = 1; n < 1000 ; n++) { //change from 15 to 14 and no seg fault
       p = floor(Random() * 2);
       r = initializeGame(p, k, 1011, &G);
       memcpy (&testG, &G, sizeof(struct gameState));

  	   G.deckCount[p] = floor(Random() * MAX_DECK);	
  	   G.discardCount[p] = floor(Random() * MAX_DECK);
       G.handCount[p] = floor(Random() * MAX_HAND);
  	// memset(&G, 23, sizeof(struct gameState)); 
//  	   checkBaron(p, &G);
  ////
 
  int randomInt = rand() % 10 + 1;
   if (randomInt < 6)
  {
     choice1 = 1;
  } else
  {
    choice1 = 0;
  }
 cardEffect(baron, choice1, choice2, choice3, &testG, handpos,  &bonus);
 
 
  int preHandCount = G.discardCount[p];
  int expected = preHandCount - 1;
 // int currentPlayer = whoseTurn(G);
  int actual = testG.discardCount[p];
  if (actual != expected)
    {
     printf("%s not correctly discarding estate card. Expected=%i Actual=%i \n", "Baron ",preHandCount , expected);  
    }


  ///
  }
  return 0;
}


