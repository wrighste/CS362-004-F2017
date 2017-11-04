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


int checkAdventurer(int p, struct gameState *post) {
  int r;
  int currentPlayer = whoseTurn(post);
  int cardDrawn;
  int pretreasureinhand = 0;
  int posttreasureinhand = 0;
  int cards[10] = {adventurer, council_room, feast, gardens, mine,
         remodel, smithy, village, baron, great_hall};
  struct gameState pre;
  memcpy (&pre, post, sizeof(struct gameState));

 // int preHandCount = pre->handCount[currentPlayer];
  int preHandCount = post->handCount[currentPlayer];
  int thiscard;
   for (thiscard = 0; thiscard<preHandCount; thiscard++) {
  	cardDrawn = pre.hand[currentPlayer][thiscard];//top card of hand is most recently drawn card.
 	if (cardDrawn == copper || cardDrawn == silver || cardDrawn == gold)
 	{
 	  pretreasureinhand++;
	}
   }
  r = peformAdventurerActions(1, 1, 1, 1, post, 1, 1, 1,1,1,cards,1,1);
  int postHandCount = post->handCount[currentPlayer];

   for (thiscard = 0; thiscard<postHandCount; thiscard++) {
  	cardDrawn = post->hand[currentPlayer][thiscard];//top card of hand is most recently drawn card.
 	if (cardDrawn == copper || cardDrawn == silver || cardDrawn == gold)
 	{
 	  posttreasureinhand++;
	}
   }
   int expectedpretreasureinhand = pretreasureinhand + 2;
  if (expectedpretreasureinhand !=  posttreasureinhand )
        {
         printf ("Random testing adventurer. Expect treasure cards: %i actual treasure cards %i.\n",expectedpretreasureinhand ,posttreasureinhand);
        }; 
  }
//  while(drawntreasure<2){
     
// 	if (state->deckCount[currentPlayer] <=1){//if the deck is empty we need to shuffle discard and add to deck
// 	  shuffle(currentPlayer, state);
// 	}
// 	drawCard(currentPlayer, state);
// 	cardDrawn = state->hand[currentPlayer][state->handCount[currentPlayer]-1];//top card of hand is most recently drawn card.
// 	if (cardDrawn == copper || cardDrawn == silver || cardDrawn == gold)
// 	  drawntreasure++;
// 	else{
// 	  temphand[z3]=cardDrawn;
// 	  state->handCount[currentPlayer]--; //this should just remove the top card (the most recently drawn one).
// 	  z3++;
// 	}
// }
// while(z3-1>=0){
// 	state->discard[currentPlayer][state->discardCount[currentPlayer]++]=temphand[z3-1]; // discard all cards in play that have been drawn
// 	z3=z3-1;
//   }
//   return 0;


//   int i3;
  
//   for (i3 = 0; i3 < post->numPlayers; i3++){
//     if (i3 != currentPlayer){
//       if (post->deck[i3][post->deckCount[i3]--] != curse)
//         {
//          printf ("This is other than current player, and top card is not a curse card.\n");
//         }; 
//     } else if (i3 == currentPlayer)
//     {
//       if (post->deck[i3][post->deckCount[i3]--] == curse)
//         {
//          printf ("This is current player, and top card is a curse card.\n");
//         };
//     }
//   }
// }

 

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


  printf ("Testing Adventurer find treasure.\n");

  SelectStream(2);
  PutSeed(3);

	memset(&G, 23, sizeof(struct gameState)); 
	r = initializeGame(4, k, 21, &G);
  checkAdventurer(p, &G);

  return 0;
}


