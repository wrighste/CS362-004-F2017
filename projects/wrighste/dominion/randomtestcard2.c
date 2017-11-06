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

int seaHagErrorCount; 
int seaMethodRuns; 


int checkSeaHag(int p, struct gameState *post) {
  int r;
  seaMethodRuns++;

     
  int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0, EndinggnumNumBuys = 0,StartingNumBuys = 0;
  int cards[10] = {adventurer, council_room, feast, gardens, mine,
          remodel, smithy, village, baron, great_hall};
 

  struct gameState pre;
  memcpy (&pre, &post, sizeof(struct gameState));
 
  cardEffect(sea_hag, choice1, choice2, choice3, &post, handpos, &bonus);
 
 ////
  int i3; 
  for (i3 = 0; i3 < post->numPlayers; i3++){
      if (i3 != p)
      {
       if (post->deck[i3][post->deckCount[i3]] != curse)
      	{
          seaHagErrorCount++;
        } 
      }	
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


  printf ("Testing Sea hag .\n");
  seaHagErrorCount = 0;
  seaMethodRuns = 0;
  SelectStream(2);
  for (n = 1; n < 2000  ; n++) {
   	for (i = 0; i < sizeof(struct gameState); i++) {
       ((char*)&G)[i] = floor(Random() * 256);
    }
  	p = floor(Random() * 2);
 
  	G.deckCount[p] = floor(Random() * MAX_DECK);	
  	G.discardCount[p] = floor(Random() * MAX_DECK);
  	G.handCount[p] = floor(Random() * MAX_HAND);
  	memset(&G, 23, sizeof(struct gameState)); 
 
  	r = initializeGame(p, k, 21, &G);
  	checkSeaHag(p, &G);
 }
 if (seaHagErrorCount > 0)  
 {
      printf ("Total number of sea hag methods run: %i out of those, the method failed to set the top card to curse %i times\n", seaHagErrorCount,seaMethodRuns);
 } 

  return 0;
}


