#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

#define DEBUG 0
#define NOISY_TEST 1


// peformSalvagerActions(int card, int choice1, int choice2, int choice3, struct gameState *state, int handPos, int *bonus, int drawntreasure,int currentPlayer,int cardDrawn,int temphand[],int z3,int i3)
// {
//       //+1 buy
//       state->numBuys++;
      
//       if (choice1)
//   {
//     //gain coins equal to trashed card
//     state->coins = state->coins + getCost( handCard(choice1, state) );
//     //trash card
//     discardCard(choice1, currentPlayer, state, 1);  
//   }
      
//       //discard card
//       discardCard(handPos, currentPlayer, state, 0);
//       return 0;


// }

// ///////////////////////
int checkUnit4(int p, struct gameState *post) {
  int r;

  int StartingNumBuys = post->numBuys;
        
  int expectedNumBuys = StartingNumBuys + 1;
    int cards[10] = {adventurer, council_room, feast, gardens, mine,
         remodel, smithy, village, baron, great_hall};

  // r = peformSalvagerActions(1, 1, 1, 1, post, 1, 1, 1,1,1,cards,1,1);
  // int EndinggnumNumBuys = post->numBuys;
  // if (StartingNumBuys != EndinggnumNumBuys)
  //       {
  //        printf ("The Salvager method did not increment buy properly.\n");
  //       }; 
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


  printf ("Testing Salvager actions.\n");

  SelectStream(2);
  PutSeed(3);

  memset(&G, 23, sizeof(struct gameState)); 
  r = initializeGame(4, k, 21, &G);
  checkUnit4(p, &G);

  return 0;
}

