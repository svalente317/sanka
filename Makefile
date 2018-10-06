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
CFLAGS=		$(DBG) -Iruntime
ANTLR_RUNTIME=	lib/antlr4-runtime-4.5.1.jar

all:	bin/sanka.jar bin/sanka.sh bin/libsankaruntime.a

bin/sanka.jar:
	ant -e jar

bin/sanka.sh:
	echo '#!/bin/sh' > $@
	echo exec java -cp ${PREFIX}/share/sanka.jar:$(PREFIX)/$(ANTLR_RUNTIME) \
	sanka/Translator -I ${PREFIX}/include '"$$@"' >> $@
	chmod 755 $@

bin/libsankaruntime.a: $(OBJS)
	rm -f $@
	ar rc $@ $^

bin/panic.o:		runtime/panic.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/rb.o:		runtime/rb.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/string_add.o:	runtime/string_add.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/FileReader.o:	runtime/sanka/io/FileReader.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/System.o:		runtime/sanka/lang/System.c
	$(CC) $(CFLAGS) -o $@ -c $<

clean:
	rm -rf bin *~

allclean:	clean
	rm -rf $(PREFIX)/*

install: all
	mkdir -p $(PREFIX)/bin
	mkdir -p $(PREFIX)/include
	mkdir -p $(PREFIX)/lib
	mkdir -p $(PREFIX)/share
	cp bin/sanka.sh $(PREFIX)/bin/sanka
	cp bin/libsankaruntime.a $(PREFIX)/lib/
	cp ${ANTLR_RUNTIME} $(PREFIX)/lib/
	cp bin/sanka.jar $(PREFIX)/share/
	cd runtime; tar cf - $(INCLUDES) | (cd $(PREFIX)/include; tar xf -)
