PREFIX=	/opt/sanka
CC=	gcc
DBG=	-g

PROGS=	channeltest cheesefinder jsontest parsenumber processviewer total wordmap

all:	$(PROGS)

channeltest:	ChannelTest.san
	sanka $^ --exe $@ --main sanka.examples.ChannelTest

cheesefinder:		CheeseFinder.san Mouse.san
	sanka $^ --exe $@ --main sanka.examples.CheeseFinder

jsontest:	JsonTest.san
	sanka $^ --exe $@ --main sanka.examples.JsonTest

parsenumber:	ParseNumber.san NumberMaps.san
	sanka $^ --exe $@ --main sanka.examples.ParseNumber

processviewer:	ProcessViewer.san
	sanka $^ --exe $@ --main sanka.examples.ProcessViewer

total:		Total.san
	sanka $^ --exe $@ --main sanka.examples.Total

wordmap:	WordMap.san
	sanka $^ --exe $@ --main sanka.examples.WordMap

clean:
	rm -rf $(PROGS) sanka *~
