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

 


int checkSmithy(int p, struct gameState *post) {
  int r;
 

     
  int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0, EndinggnumNumBuys = 0,StartingNumBuys = 0;
  int cards[10] = {adventurer, council_room, feast, gardens, mine,
          remodel, smithy, village, baron, great_hall};
 

  struct gameState pre;
  memcpy (&pre, &post, sizeof(struct gameState));
  
 // int originalHandCount =   post->handCount[p];
  cardEffect(smithy, choice1, choice2, choice3, &post, handpos, &bonus);
 // int expectedHandCount =  originalHandCount + 3;
 // int actualHandCount =  post->handCount[p];

 
 // if (expectedHandCount != actualHandCount)
   // {
  //  printf("smithy is not correctly adding cards. Expected=%i Actual=%i \n", "Baron ",expectedHandCount , actualHandCount);  
 // }

 ////
  // int i3; 
  // for (i3 = 0; i3 < post->numPlayers; i3++){
  //     if (i3 != p)
  //     {
  //      if (post->deck[i3][post->deckCount[i3]] != curse)
  //     	{
  //         seaHagErrorCount++;
  //       } 
  //     }	
  //   } 
 
 
  }
 
 

int main () {

  int i, n, r, p, deckCount, discardCount, handCount;

  int card;
  int choice1 = 0;
  int choice2 = 0;
  int choice3 = 0;
  int handPos;
  int *bonus;
  int drawntreasure;
  int currentPlayer;
  int cardDrawn;
  int temphand[MAX_HAND];// moved above the if statement  int z3;
  int i3;
  int handpos = 0;
  
  struct gameState G ;
  struct gameState testG ;
  //struct gameState *state, 
  int k[10] = {adventurer, council_room, feast, gardens, mine,
	       remodel, smithy, village, baron, great_hall};


  printf ("Testing Sea hag .\n");
 
  SelectStream(2);
  for (n = 1; n < 2000  ; n++) {
   	//for (i = 0; i < sizeof(struct gameState); i++) {
    //   ((char*)&G)[i] = floor(Random() * 256);
    //}
  	p = floor(Random() * 2);
    r = initializeGame(p, k, 21, &G);
    memcpy (&testG, &G, sizeof(struct gameState));
 
  	G.deckCount[p] = floor(Random() * MAX_DECK);	
  	G.discardCount[p] = floor(Random() * MAX_DECK);
  	G.handCount[p] = floor(Random() * MAX_HAND);
 // 	memset(&G, 23, sizeof(struct gameState)); 
 
  //	checkSmithy(p, &G);
///////////////////
     

  
 // int originalHandCount =   post->handCount[p];
  cardEffect(smithy, choice1, choice2, choice3, &testG, handpos, &bonus);


/////////////// 


}
 

  return 0;
}


