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

u1: unittest1.c dominion.o rngs.o

	gcc  -o unittest1 -g  unittest1.c dominion.o rngs.o $(CFLAGS)

runu1: unittest1
	./unittest1 &> u1.out
	gcov dominion.c >> u1.out
	cat dominion.c.gcov >> u1.out 	
 
gdbu1: unittest1
	gdb unittest1

##--for seah hag bug---------------------------

seahagUnit1: unittestseahag.c dominion.o rngs.o

	gcc  -o unittestseahag -g  unittestseahag.c dominion.o rngs.o $(CFLAGS)

runseahagUnit1: unittestseahag
	./unittestseahag &> u1.out
	gcov dominion.c >> u1.out
	cat dominion.c.gcov >> u1.out 	
#----------

u2: unittest2.c dominion.o rngs.o
	gcc  -o unittest2 -g unittest2.c dominion.o rngs.o ${CFLAGS}


runu2: unittest2
	./unittest2 &> u2.out
	gcov dominion.c >> u2.out
	cat dominion.c.gcov >> u2.out	

gdbu2: unittest2
	gdb unittest2

u3: unittest3.c dominion.o rngs.o
	gcc -o unittest3 -g unittest3.c dominion.o rngs.o ${CFLAGS}

runu3: unittest3
	./unittest3 &> u3.out
	gcov dominion.c >> u3.out
	cat dominion.c.gcov >> u3.out

gdbu3: unittest3
	gdb unittest3
			
u4: unittest4.c dominion.o rngs.o
	gcc -o unittest4 -g unittest4.c dominion.o rngs.o ${CFLAGS} 

runu4: unittest4
	./unittest4 &> u4.out	
	gcov dominion.c >>  u4.out
	cat dominion.c.gcov >>  u4.out

gdbu4: unittest4
	gdb unittest4

ranadv: randomtestadventurer.c dominion.o rngs.o
	gcc -o randomtestadventurer -g randomtestadventurer.c dominion.o rngs.o ${CFLAGS}

runadv: randomtestadventurer
	./randomtestadventurer &> ranadv.out
	gcov -f dominion.c >> ranadv.out
	cat dominion.c.gcov >> ranadv.out

gdbrana1: randomtestadventurer
	gdb unirandomtestadventurerttest2

gdba1: randomtestadventurer
	gdb randomtestadventurer

ran1: randomtestcard1.c dominion.o rngs.o
	gcc -o randomtestcard1 -g randomtestcard1.c dominion.o  rngs.o ${CFLAGS}
 
runran1: randomtestcard1
	./randomtestcard1 &> ran1.out
	gcov -f dominion.c >> ran1.out
	cat dominion.c.gcov >> ran1.out

gdbr1: randomtestcard1
	gdb randomtestcard1
 
ran2: randomtestcard2.c dominion.o rngs.o
	gcc -o randomtestcard2 -g randomtestcard2.c dominion.o rngs.o ${CFLAGS} 	

gdbr2: randomtestcard2
	gdb randomtestcard2
runran2:  randomtestcard2
	./randomtestcard2 &> randomtestcard2result.out
	gcov -f dominion.c >> randomtestcard2result.out
	cat dominion.c.gcov >> randomtestcard2result.out


#project 5 above------------------------------------------------
 
#provided below

player: player.c interface.o
	gcc -o player player.c -g  dominion.o rngs.o interface.o $(CFLAGS)

