PREFIX=	/opt/sanka
CC=	gcc
DBG=	-g

all:	wordmap interface heap

wordmap:	WordMap.san
	sanka $^ --exe $@ --main sanka.examples.WordMap

interface:	Interface.san
	sanka $^ --exe $@ --main sanka.examples.User

heap:		Heap.san
	sanka $^ --exe $@ --main sanka.examples.HeapTest

clean:
	rm -rf wordmap interface heap *.o *~ sanka
