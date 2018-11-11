PREFIX=	/opt/sanka
CC=	gcc
DBG=	-g

all:	wordmap interface heap channel

wordmap:	WordMap.san
	sanka $^ --exe $@ --main sanka.examples.WordMap

interface:	Interface.san
	sanka $^ --exe $@ --main sanka.examples.User

heap:		Heap.san
	sanka $^ --exe $@ --main sanka.examples.HeapTest

channel:	ProducerConsumer.san Channel.san
	sanka $^ --exe $@ --main sanka.examples.ProducerConsumer

clean:
	rm -rf wordmap interface heap channel *.o *~ sanka
