PREFIX=	/opt/sanka
CC=	gcc
DBG=	-g

PROGS=	wordmap interface heap channel jsontest finder

all:	$(PROGS)

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

finder:		CheeseFinder.san Mouse.san
	sanka $^ --exe $@ --main sanka.examples.CheeseFinder

clean:
	rm -rf $(PROGS) sanka *~
