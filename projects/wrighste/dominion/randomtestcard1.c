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


int checkBaron(int p, struct gameState *pre) {
  int r;
  int currentPlayer = whoseTurn(pre);
  int cardDrawn;
  int pretreasureinhand = 0;
  int posttreasureinhand = 0;
      int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0;
  int cards[10] = {adventurer, council_room, feast, gardens, mine,
         remodel, smithy, village, baron, great_hall};
  struct gameState post;
  memcpy (&post, &pre, sizeof(struct gameState));

  cardEffect(baron, choice1, choice2, choice3, &post, handpos, &bonus);
  playCard(handpos, choice1, choice2, choice3, &post);
 
 // int preHandCount = pre->handCount[currentPlayer];
  if (pre->discardCount[currentPlayer] != (post.discardCount[currentPlayer] + 1))
 	{
		printf("%s not correctly discarding estate card \n", "Baron ");	
 	}

  //	r = peformBaronActions(1, 1, 1, 1, post, 1, 1, 1,1,1,cards,1,1);
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
  PutSeed(3);

//int initializeGame(int numPlayers, int kingdomCards[10], int randomSeed,
//		   struct gameState *state) 
  for (n = 0; n < 20000; n++) {
  	p = floor(Random() * 2);
  	G.deckCount[p] = floor(Random() * MAX_DECK);	
  	G.discardCount[p] = floor(Random() * MAX_DECK);
  	G.handCount[p] = floor(Random() * MAX_HAND);
  	memset(&G, 23, sizeof(struct gameState)); 
  	r = initializeGame(4, k, 21, &G);
  	checkBaron(p, &G);
  }
  return 0;
}


