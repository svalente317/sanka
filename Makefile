# Build the sanka compiler and the runtime library.
#
# Install the compiler shell script as
# $prefix/bin/sanka
#
# Install the compiler jar file as
# $prefix/share/sanka.jar
#
# Install the sanka runtime header files as
# $prefix/include/sanka/*.{h,san}
#
# Install the sanka runtime library as
# $prefix/lib/libsankaruntime.a

PREFIX=/opt/sanka

OBJS=	bin/panic.o \
	bin/rb.o \
	bin/string_add.o \
	bin/FileReader.o \
	bin/System.o

INCLUDES=rb.h \
	sanka_header.h \
	sanka/io/FileReader.h \
	sanka/io/FileReader.san \
	sanka/lang/String.h \
	sanka/lang/String.san \
	sanka/lang/System.h \
	sanka/lang/System.san

CC=		gcc
DBG=		-g
CFLAGS=		$(DBG) -Ilib
ANTLR_RUNTIME=	/usr/share/java/antlr4-runtime.jar

all:	bin/sanka.jar bin/sanka.sh bin/libsankaruntime.a

bin/sanka.jar:
	ant -e jar

bin/sanka.sh:
	echo '#!/bin/sh' > $@
	echo exec java -cp ${PREFIX}/share/sanka.jar:$(ANTLR_RUNTIME) \
	sanka/Translator '"$$@"' >> $@
	chmod 755 $@

bin/libsankaruntime.a: $(OBJS)
	rm -f $@
	ar rc $@ $^

bin/panic.o:		lib/panic.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/rb.o:		lib/rb.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/string_add.o:	lib/string_add.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/FileReader.o:	lib/sanka/io/FileReader.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/System.o:		lib/sanka/lang/System.c
	$(CC) $(CFLAGS) -o $@ -c $<

clean:
	rm -rf bin *~

install: all
	mkdir -p $(PREFIX)/bin
	mkdir -p $(PREFIX)/include
	mkdir -p $(PREFIX)/lib
	mkdir -p $(PREFIX)/share
	cp bin/sanka.sh $(PREFIX)/bin/sanka
	cd lib; tar cf - $(INCLUDES) | (cd $(PREFIX)/include; tar xf -)
	cp bin/libsankaruntime.a $(PREFIX)/lib/
	cp bin/sanka.jar $(PREFIX)/share/
