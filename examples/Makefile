PREFIX=	/opt/sanka

PROGS=	channeltest copy_directory file_to_sanka json_format parsenumber processviewer sequence_generator sudoku total wordmap

all:	$(PROGS)

channeltest:	ChannelTest.san
	sanka $^ --exe $@ --main sanka.examples.ChannelTest

copy_directory:		CopyDirectory.san
	sanka $^ --exe $@ --main sanka.examples.CopyDirectory

file_to_sanka:	FileToSanka.san
	sanka $^ --exe $@ --main sanka.examples.FileToSanka

json_format:	JsonFormatter.san
	sanka $^ --exe $@ --main sanka.examples.JsonFormatter

parsenumber:	ParseNumber.san NumberMaps.san
	sanka $^ --exe $@ --main sanka.examples.ParseNumber

processviewer:	ProcessViewer.san
	sanka $^ --exe $@ --main sanka.examples.ProcessViewer

sequence_generator:		SequenceGenerator.san
	sanka $^ --exe $@ --main sanka.examples.SequenceGenerator

sudoku:		Sudoku.san
	sanka $^ --exe $@ --main sanka.examples.Sudoku

total:		Total.san
	sanka $^ --exe $@ --main sanka.examples.Total

wordmap:	WordMap.san
	sanka $^ --exe $@ --main sanka.examples.WordMap

clean:
	rm -rf $(PROGS) sanka *~
