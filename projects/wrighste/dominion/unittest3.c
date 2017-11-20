#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

#define DEBUG 0
#define NOISY_TEST 1


 

int checkUnit3(int p, struct gameState *post) {
  int r;

  int StartingNumBuys = post->numBuys;
        
  int expectedNumBuys = StartingNumBuys + 1;
    int cards[10] = {adventurer, council_room, feast, gardens, mine,
         remodel, smithy, village, baron, great_hall};
 int choice1 = 0; int choice2 = 0; int choice3 = 0;
  int handPos = 1;
  int bonus = 1;
   r =  cardEffect(baron, choice1, choice2, choice3, post, handPos, bonus);
  // r = peformBaronActions(1, 1, 1, 1, post, 1, 1, 1,1,1,cards,1,1);
   int EndinggnumNumBuys = post->numBuys;
   if (StartingNumBuys != EndinggnumNumBuys)
         {
          printf ("The Baron method did not increment buy properly.\n");
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
  struct gameState G;
 
  //struct gameState *state, 
  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};


  printf ("Testing Baron actions.\n");

  SelectStream(2);
  PutSeed(3);

	memset(&G, 23, sizeof(struct gameState)); 
	r = initializeGame(4, k, 21, &G);
  checkUnit3(p, &G);

  return 0;
}
