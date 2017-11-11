#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

#define DEBUG 0
#define NOISY_TEST 1

int checkUnit1(int p, struct gameState *post) {
  int r;
  int cards[10] = {adventurer, council_room, feast, gardens, mine,
         remodel, smithy, village, baron, great_hall};
 // r = peformSeaHagctions(1, 1, 1, 1, post, 1, 1, 1,1,1,cards,1,1);
 // int i3;
  // int currentPlayer = whoseTurn(post);
  // for (i3 = 0; i3 < post->numPlayers; i3++){
  //   if (i3 != currentPlayer){
  //     if (post->deck[i3][post->deckCount[i3]--] != curse)
  //       {
  //        printf ("This is other than current player, and top card is not a curse card.\n");
  //       }; 
  //   } else if (i3 == currentPlayer)
  //   {
  //     if (post->deck[i3][post->deckCount[i3]--] == curse)
  //       {
  //        printf ("This is current player, and top card is a curse card.\n");
  //       };
  //   }
  // }
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


  printf ("Testing SeaHag actions.\n");

  SelectStream(2);
  PutSeed(3);

	memset(&G, 23, sizeof(struct gameState)); 
	r = initializeGame(4, k, 21, &G);
  checkUnit1(p, &G);

  return 0;
}
