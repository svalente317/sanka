PREFIX=	/opt/sanka

PROGS=	channeltest cheesefinder file_to_sanka json_format parsenumber processviewer sudoku total wordmap

all:	$(PROGS)

channeltest:	ChannelTest.san
	sanka $^ --exe $@ --main sanka.examples.ChannelTest

cheesefinder:		CheeseFinder.san Mouse.san
	sanka $^ --exe $@ --main sanka.examples.CheeseFinder

file_to_sanka:	FileToSanka.san
	sanka $^ --exe $@ --main sanka.examples.FileToSanka

json_format:	JsonFormatter.san
	sanka $^ --exe $@ --main sanka.examples.JsonFormatter

parsenumber:	ParseNumber.san NumberMaps.san
	sanka $^ --exe $@ --main sanka.examples.ParseNumber

processviewer:	ProcessViewer.san
	sanka $^ --exe $@ --main sanka.examples.ProcessViewer

sudoku:		Sudoku.san
	sanka $^ --exe $@ --main sanka.examples.Sudoku

total:		Total.san
	sanka $^ --exe $@ --main sanka.examples.Total

wordmap:	WordMap.san
	sanka $^ --exe $@ --main sanka.examples.WordMap

clean:
	rm -rf $(PROGS) sanka *~
