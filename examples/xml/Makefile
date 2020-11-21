all: xml_format

SAN_FILES = XmlParser.san XmlProcessor.san \
            XmlFormatter.san XmlFormatProcessor.san

xml_format: $(SAN_FILES) libsanka_expat.a
	sanka $(SAN_FILES) --main sanka.examples.xml.XmlFormatter --exe $@ \
	-L . -lexpat -lsanka_expat

libsanka_expat.a: sanka_expat.o
	rm -f $@
	ar cr $@ $<

sanka_expat.o: sanka_expat.c sanka/xml/XmlProcessor.h
	gcc -g -I/opt/sanka/include -I. -o $@ -c $<

sanka/xml/XmlProcessor.h: XmlProcessor.san
	sanka $(SAN_FILES)

clean:
	rm -rf xml_format sanka *.o *.a *~
