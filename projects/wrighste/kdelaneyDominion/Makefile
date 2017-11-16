CFLAGS = -Wall -fpic -coverage -lm

rngs.o: rngs.h rngs.c
	gcc -c rngs.c -g  $(CFLAGS)

#build dominion-------------------------------------------------------
dominion.o: dominion.h dominion.c rngs.o
	gcc -c dominion.c -g  $(CFLAGS)

#play dominion------------------------------------------------------
playdom: dominion.o playdom.c
	gcc -o playdom playdom.c -g dominion.o rngs.o $(CFLAGS)
#To run playdom you need to entere: ./playdom <any integer number> like ./playdom 10*/

#project 5------------------------------------------------


all: playdom player unittest1 unittest2 unittest3 unittest4 randomadventurer  randomtestcard2 
##randomtestcard1
runtests: rununit1 rununit2 rununit3 rununit4 runrandomadventurer randomtestcard1  runrandomtestcard2
	
 
clean:
	rm -f *.o playdom.exe playdom player player.exe  *.gcov *.gcda *.gcno *.so *.out testDrawCard testDrawCard.exe

unittest1: unittest1.c dominion.o rngs.o

	gcc  -o unittest1 -g  unittest1.c dominion.o rngs.o $(CFLAGS)

rununit1: unittest1
	./unittest1 &> unittest1result.out
	gcov dominion.c >> unittest1result.out
	cat dominion.c.gcov >> unittest1result.out 	
 
unittest2: unittest2.c dominion.o rngs.o
	gcc  -o unittest2 -g unittest2.c dominion.o rngs.o ${CFLAGS}


rununit2: unittest2
	./unittest2 &> unittest2result.out
	gcov dominion.c >> unittest2result.out
	cat dominion.c.gcov >> unittest2result.out	

unittest3: unittest3.c dominion.o rngs.o
	gcc -o unittest3 -g unittest3.c dominion.o rngs.o ${CFLAGS}

rununit3: unittest3
	./unittest3 &> unittest3result.out
	gcov dominion.c >> unittest3result.out
	cat dominion.c.gcov >> unittest3result.out
		
unittest4: unittest4.c dominion.o rngs.o
	gcc -o unittest4 -g unittest4.c dominion.o rngs.o ${CFLAGS} 

rununit4: unittest4
	./unittest4 &> unittest4result.out	
	gcov dominion.c >> unittest4result.out
	cat dominion.c.gcov >> unittest4result.out

randomadventurer: randomtestadventurer.c dominion.o rngs.o
	gcc -o randomtestadventurer -g randomtestadventurer.c dominion.o rngs.o ${CFLAGS}

runrandomadventurer: randomtestadventurer
	./randomtestadventurer &> randomtestadventurerresult.out
	gcov -f dominion.c >> randomtestadventurerresult.out
	cat dominion.c.gcov >> randomtestadventurerresult.out

randomtestcard1: randomtestcard1.c dominion.o rngs.o
	gcc -o randomtestcard1 -g randomtestcard1.c dominion.o  rngs.o ${CFLAGS}
 
runrandomtestcard1: randomtestcard1
	./randomtestcard1 &> randomtestcard1result.out
	gcov -f dominion.c >> randomtestcard1result.out
	cat dominion.c.gcov >> randomtestcard1result.out

randomtestcard2: randomtestcard2.c dominion.o rngs.o
	gcc -o randomtestcard2 -g randomtestcard2.c dominion.o rngs.o ${CFLAGS} 	

runrandomtestcard2: randomtestcard2
	./randomtestcard2 &> randomtestcard2result.out
	gcov -f dominion.c >> randomtestcard2result.out
	cat dominion.c.gcov >> randomtestcard2result.out



#project 5 above------------------------------------------------
 
#provided below

player: player.c interface.o
	gcc -o player player.c -g  dominion.o rngs.o interface.o $(CFLAGS)

