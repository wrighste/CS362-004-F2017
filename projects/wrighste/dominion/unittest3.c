#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

#define DEBUG 0
#define NOISY_TEST 1


//  peformBaronActions(int card, int choice1, int choice2, int choice3, struct gameState *state, int handPos, int *bonus, int drawntreasure,int currentPlayer,int cardDrawn,int temphand[],int z3,int i3)
//  {
      
//       state->numBuys++;//Increase buys by 1!
//       if (choice1 > 0){//Boolean true or going to discard an estate
//   int p = 0;//Iterator for hand!
//   int card_not_discarded = 1;//Flag for discard set!
//   while(card_not_discarded){
//     if (state->hand[currentPlayer][p] == estate){//Found an estate card!
//       state->coins += 4;//Add 4 coins to the amount of coins
//       state->discard[currentPlayer][state->discardCount[currentPlayer]] = state->hand[currentPlayer][p];
//       state->discardCount[currentPlayer]++;
//       for (;p < state->handCount[currentPlayer]; p++){
//         state->hand[currentPlayer][p] = state->hand[currentPlayer][p+1];
//       }
//       state->hand[currentPlayer][state->handCount[currentPlayer]] = -1;
//       state->handCount[currentPlayer]--;
//       card_not_discarded = 0;//Exit the loop
//     }
//     else if (p > state->handCount[currentPlayer]){
//       if(DEBUG) {
//         printf("No estate cards in your hand, invalid choice\n");
//         printf("Must gain an estate if there are any\n");
//       }
//       if (supplyCount(estate, state) > 0){
//         gainCard(estate, state, 0, currentPlayer);
//         state->supplyCount[estate]--;//Decrement estates
//         if (supplyCount(estate, state) == 0){
//     isGameOver(state);
//         }
//       }
//       card_not_discarded = 0;//Exit the loop
//     }
          
//     else{
//       p++;//Next card
//     }
//   }
//       }
          
//       else{
//   if (supplyCount(estate, state) > 0){
//     gainCard(estate, state, 0, currentPlayer);//Gain an estate
//     state->supplyCount[estate]--;//Decrement Estates
//     if (supplyCount(estate, state) == 0){
//       isGameOver(state);
//     }
//   }
//       }
      
//       return 0;
// }


int checkUnit3(int p, struct gameState *post) {
  int r;

  int StartingNumBuys = post->numBuys;
        
  int expectedNumBuys = StartingNumBuys + 1;
    int cards[10] = {adventurer, council_room, feast, gardens, mine,
         remodel, smithy, village, baron, great_hall};

  r = peformBaronActions(1, 1, 1, 1, post, 1, 1, 1,1,1,cards,1,1);
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
