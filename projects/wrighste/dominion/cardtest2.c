/*
 * cardtest2.c
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
#include <stdlib.h>

#define TESTCARD "adventurer"
#define NOISY_TEST 1

int main() {
    int newCards = 0;
    int discarded = 1;
    int xtraCoins = 0;
    int shuffledCards = 0;
    int i, j, m;
    int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0;
    int remove1, remove2;
    int seed = 1000;
    int numPlayers = 2;
    int thisPlayer = 0;
	struct gameState G, testG;
	int k[10] = {baron, embargo, village, minion, mine, cutpurse,
			sea_hag, tribute, smithy, council_room};

	// initialize a game state and player cards
	initializeGame(numPlayers, k, seed, &G);

	printf("----------------- Testing Card: %s ----------------\n", TESTCARD);

	// ----------- TEST 1: Increment buy\n"--------------
	printf("TEST 1: Increment buy\n");

	// copy the game state to a test case
	memcpy(&testG, &G, sizeof(struct gameState));
	choice1 = 0 ;
	
	cardEffect(baron, choice1, choice2, choice3, &testG, handpos, &bonus);
    playCard(baron, choice1, choice2, choice3, &G);

	newCards = 2;
	xtraCoins = 0;
 	if (testG.numBuys != (G.numBuys + 1))
 	{
		printf("%s not correctly incrementing buy \n", TESTCARD);	
 	}
 	printf("buy count = %d, expected = %d\n", testG.numBuys, G.numBuys + 1);
	// ----------- TEST 2: Test of discard estate"--------------
	printf("TEST 2: Choice to discard an estate\n");

	// copy the game state to a test case
	memcpy(&testG, &G, sizeof(struct gameState));
	choice1 = 1 ;
	
	cardEffect(baron, choice1, choice2, choice3, &testG, handpos, &bonus);
    playCard(handpos, choice1, choice2, choice3, &G);

	newCards = 2;
	int currentPlayer =  whoseTurn(&testG);

 	if (testG.discardCount[currentPlayer] != (G.discardCount[currentPlayer] + 1))
 	{
		printf("%s not correctly discarding estate card \n", TESTCARD);	
 	}
 	printf("discard card count = %d, expected = %d\n", testG.discardCount[currentPlayer], G.discardCount[currentPlayer] + 1);

 

	printf("\n >>>>> SUCCESS: Testing complete %s <<<<<\n\n", TESTCARD);


	return 0;
}


