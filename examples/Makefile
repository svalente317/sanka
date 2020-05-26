PREFIX=	/opt/sanka

PROGS=	anonymoustest channeltest cheesefinder parsenumber processviewer total wordmap

all:	$(PROGS)

anonymoustest:	AnonymousTest.san
	sanka $^ --exe $@ --main sanka.examples.ATMainClass

channeltest:	ChannelTest.san
	sanka $^ --exe $@ --main sanka.examples.ChannelTest

cheesefinder:		CheeseFinder.san Mouse.san
	sanka $^ --exe $@ --main sanka.examples.CheeseFinder

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
