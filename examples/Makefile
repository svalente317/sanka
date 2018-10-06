PREFIX=	/opt/sanka
CC=	gcc
DBG=	-g

all:	wordmap interface heap

OBJS1=	sanka/examples/WordMap.o \
	main.o

CS1=	sanka/examples/WordMap.c

wordmap:	$(OBJS1)
	$(CC) -o $@ $^ -L$(PREFIX)/lib -lsankaruntime

%.o: %.c
	$(CC) $(DBG) -I$(PREFIX)/include -I. -o $@ -c $^

$(CS1): WordMap.san
	sanka $^

OBJS2=	sanka/examples/Adder.o \
	sanka/examples/Calculator.o \
	sanka/examples/Multiplier.o \
	sanka/examples/User.o \
	main2.o

CS2=	sanka/examples/Adder.c \
	sanka/examples/Calculator.c \
	sanka/examples/Multiplier.c \
	sanka/examples/User.c

interface:	$(OBJS2)
	$(CC) -o $@ $^ -L$(PREFIX)/lib -lsankaruntime

$(CS2): Interface.san
	sanka $^

OBJS3=	sanka/examples/HeapUtils.o \
	sanka/examples/Heap.o \
	sanka/examples/HeapTest.o \
	main3.o

CS3=	sanka/examples/HeapUtils.c \
	sanka/examples/Heap.c \
	sanka/examples/HeapTest.c

heap:	$(OBJS3)
	$(CC) -o $@ $^ -L$(PREFIX)/lib -lsankaruntime

$(CS3): Heap.san
	sanka $^

clean:
	rm -rf wordmap interface heap *.o *~ sanka
