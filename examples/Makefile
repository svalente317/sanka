PREFIX=	/opt/sanka
CC=	gcc
DBG=	-g

all:	wordmap interface heap channel jsontest

wordmap:	WordMap.san
	sanka $^ --exe $@ --main sanka.examples.WordMap

interface:	Interface.san
	sanka $^ --exe $@ --main sanka.examples.User

heap:		Heap.san
	sanka $^ --exe $@ --main sanka.examples.HeapTest

channel:	ChannelTest.san
	sanka $^ --exe $@ --main sanka.examples.ChannelTest

jsontest:	JsonTest.san
	sanka $^ --exe $@ --main sanka.examples.JsonTest

clean:
	rm -rf wordmap interface heap channel jsontest *.o *~ sanka
