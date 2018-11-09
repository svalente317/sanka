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
	bin/array.o \
	bin/rb.o \
	bin/string_add.o \
	bin/FileReader.o \
	bin/Condition.o \
	bin/Mutex.o \
	bin/System.o \
	bin/Thread.o

CC=		gcc
DBG=		-O6
CFLAGS=		$(DBG) -Iruntime

UNAME :=	$(shell uname)
ifeq ($(UNAME), Linux)
ANTLR_RUNTIME=	/usr/share/java/antlr4-runtime.jar
endif
ifeq ($(UNAME), Darwin)
ANTLR_FILE=	lib/antlr4-runtime-4.5.1.jar
ANTLR_RUNTIME=	$(PREFIX)/$(ANTLR_FILE)
endif

all:	bin/sanka.jar bin/sanka.sh bin/libsankaruntime.a

bin/sanka.jar:
	ant -e jar

bin/sanka.sh:
	echo '#!/bin/sh' > $@
	echo exec java -cp ${PREFIX}/share/sanka.jar:$(ANTLR_RUNTIME) \
	sanka/Translator -I ${PREFIX}/include '"$$@"' >> $@
	chmod 755 $@

bin/libsankaruntime.a: $(OBJS)
	rm -f $@
	ar rc $@ $^

bin/%.o:		runtime/%.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/%.o:		runtime/sanka/lang/%.c
	$(CC) $(CFLAGS) -o $@ -c $<

bin/%.o:		runtime/sanka/io/%.c
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
ifeq ($(UNAME), Darwin)
	cp $(ANTLR_FILE) $(ANTLR_RUNTIME)
endif
	cp bin/sanka.jar $(PREFIX)/share/
	cd runtime; tar cf - rb.h sanka_header.h \
	`find sanka -name '*.h'` | (cd $(PREFIX)/include; tar xf -)
