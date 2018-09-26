PREFIX=	/opt/sanka
CC=	gcc
DBG=	-g

all:	wordmap

wordmap:	wordmap.o main.o
	$(CC) -o $@ $^ -L$(PREFIX)/lib -lsankaruntime

wordmap.o:	sanka/examples/WordMap.c
	$(CC) $(DBG) -I$(PREFIX)/include -I. -o $@ -c $^

main.o:		main.c
	$(CC) $(DBG) -I$(PREFIX)/include -I. -o $@ -c $^

sanka/examples/WordMap.c: WordMap.san
	sanka $^

clean:
	rm -rf wordmap *.o *~ sanka
