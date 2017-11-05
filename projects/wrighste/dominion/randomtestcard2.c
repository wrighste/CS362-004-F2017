/*
 * randomtestcard2.c
 *
 
 */

 
#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

#define DEBUG 0
#define NOISY_TEST 1

 

int checkSalvager(int p, struct gameState *post) {
  int r;

     
  int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0, EndinggnumNumBuys = 0,StartingNumBuys = 0;
  int cards[10] = {adventurer, council_room, feast, gardens, mine,
          remodel, smithy, village, baron, great_hall};
  //r = peformSalvagerActions(0, 0, 0, 0, &post, 0, 0, 0,0,0,cards,0,0);

  struct gameState pre;
  memcpy (&pre, &post, sizeof(struct gameState));
 
  cardEffect(baron, choice1, choice2, choice3, &post, handpos, &bonus);
  //playCard(handpos, choice1, choice2, choice3, &post);
  int randomInt = rand() % 10 + 1;
  if (randomInt < 6)
  {
  	choice1 = 1;
  } else
  {
  	choice1 = 0;
  }
  
 
  StartingNumBuys = post->numBuys;
  int expectedNumBuys = StartingNumBuys + 1; //post->numBuys + 1;
  int ActualNumBuys = post->numBuys; //post->numBuys + 1;
  if (StartingNumBuys != ActualNumBuys)
  	{
    	printf ("The Salvager method did not increment buy properly. Expected: %i  Actual: i% \n",expectedNumBuys ,ActualNumBuys );
 	}; 
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


  printf ("Testing Salvager .\n");

  SelectStream(2);
 // PutSeed(3);

//int initializeGame(int numPlayers, int kingdomCards[10], int randomSeed,
//		   struct gameState *state) 
     for (n = 1; n < 3000  ; n++) {
   	for (i = 0; i < sizeof(struct gameState); i++) {
       ((char*)&G)[i] = floor(Random() * 256);
    }
  	p = floor(Random() * 2);
 
  	G.deckCount[p] = floor(Random() * MAX_DECK);	
  	G.discardCount[p] = floor(Random() * MAX_DECK);
  	G.handCount[p] = floor(Random() * MAX_HAND);
  	memset(&G, 23, sizeof(struct gameState)); 
  	//initializeGame(int numPlayers, int kingdomCards[10], int randomSeed,
	//	   struct gameState *state)
  	//r = initializeGame(p, k, 21, &G);
  	checkSalvager(p, &G);
     }
  return 0;
}


