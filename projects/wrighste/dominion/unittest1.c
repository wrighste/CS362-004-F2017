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
  int cardDrawn;
  int pretreasureinhand = 0;
  int choice1 = 0; int choice2 = 0; int choice3 = 0;
  int handPos = 1;
  int bonus = 1;

  int cards[10] = {adventurer, council_room, feast, gardens, mine,
         remodel, smithy, village, baron, great_hall};

  r =  cardEffect(sea_hag, choice1, choice2, choice3, post, handPos, bonus);
////////////////////
  //     for (i = 0; i < state->numPlayers; i++){
  // if (i != currentPlayer){
  //   state->discard[i][state->discardCount[i]] = state->deck[i][state->deckCount[i]--];          state->deckCount[i]--;
  //   state->discardCount[i]++;
  //   state->deck[i][state->deckCount[i]--] = curse;//Top card now a curse
  // }
  //     }


///////////////////
 // r = peformSeaHagctions(1, 1, 1, 1, post, 1, 1, 1,1,1,cards,1,1);
   int playerLoop;
   int cardLoop;
   int topCard;
    int currentPlayer = whoseTurn(post);
    for (playerLoop= 0; playerLoop < post->numPlayers; playerLoop++){
      if (playerLoop != currentPlayer){
            // for (cardLoop = post->deckCount[playerLoop]; cardLoop >= 0; cardLoop--){
            //     p  rintf ("This is other than current player (%i), the next card is %i.\n",playerLoop,post->deck[playerLoop][cardLoop]); 
            // }
//       if (post->deck[playerLoop][cardLoop] != curse)
      topCard = post->deckCount[playerLoop];
       if (post->deck[playerLoop][topCard] != curse)
         {
          printf ("This is other than current player, top card is not a curse card.\n");
         }; 
     } else if (playerLoop == currentPlayer)
     {
       if (post->deck[playerLoop][post->deckCount[playerLoop]--] == curse)
         {
          printf ("This is current player, and top card is a curse card.\n");
         };
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
