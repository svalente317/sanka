PREFIX=	/opt/sanka
CC=	gcc
DBG=	-g

all:	wordmap interface

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

clean:
	rm -rf wordmap interface *.o *~ sanka
