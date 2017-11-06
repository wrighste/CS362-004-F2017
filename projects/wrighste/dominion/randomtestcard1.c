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
      int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0;
  struct gameState pre;
  memcpy (&pre, &post, sizeof(struct gameState));
 
  cardEffect(baron, choice1, choice2, choice3, &post, handpos, &bonus);
 ;
 
 
	int preHandCount = pre.discardCount[p];
   int expected = preHandCount - 1;
  //int currentPlayer = whoseTurn(post);
  int actual = post->discardCount[p];
  if (preHandCount != expected)
  	{
	 	printf("%s not correctly discarding estate card. Expected=%i Actual=%i \n", "Baron ",expected , actual);	
 	}

}
 
 

int main () {

  int i, n, r, p, deckCount, discardCount, handCount;

  int card;
  int choice1;
  int choice2;
  int choice3;
  int handPos;
  int *bonus;
  int drawntreasure;
  int currentPlayer;
  int cardDrawn;
  int temphand[MAX_HAND];// moved above the if statement  int z3;
  int i3;
  
  struct gameState G ;
  //struct gameState *state, 
  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};


  printf ("Testing Baron .\n");

  SelectStream(2);
 // PutSeed(3);

//int initializeGame(int numPlayers, int kingdomCards[10], int randomSeed,
//		   struct gameState *state) 
    for (n = 1; n < 3000; n++) {
   	for (i = 0; i < sizeof(struct gameState); i++) {
       ((char*)&G)[i] = floor(Random() * 256);
    }
  	p = floor(Random() * 2);
  	G.deckCount[p] = floor(Random() * MAX_DECK);	
  	G.discardCount[p] = floor(Random() * MAX_DECK);
  	G.handCount[p] = floor(Random() * MAX_HAND);
  	memset(&G, 23, sizeof(struct gameState)); 
 
  	r = initializeGame(p, k, 21, &G);
  	checkBaron(p, &G);
   }
  return 0;
}


