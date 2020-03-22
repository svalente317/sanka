# Build the sanka runtime library.
#
# Install the sanka runtime header files as
# $prefix/include/sanka/*.{h,san}
#
# Install the sanka runtime library as
# $prefix/lib/libsankaruntime.a

PREFIX=/opt/sanka

SRCS=	bin/sanka/lang/Channel.c \
	bin/sanka/lang/Condition.c \
	bin/sanka/lang/Mutex.c \
	bin/sanka/lang/Runnable.c \
	bin/sanka/lang/String.c \
	bin/sanka/lang/System.c \
	bin/sanka/lang/Thread.c \
	bin/sanka/io/File.c \
	bin/sanka/io/FileReader.c \
	bin/sanka/io/FileStats.c \
	bin/sanka/io/LineReader.c \
	bin/sanka/io/Reader.c \
	bin/sanka/json/JsonElement.c \
	bin/sanka/json/JsonObject.c \
	bin/sanka/json/JsonParser.c \
	bin/sanka/json/Serializable.c \
	bin/sanka/json/StringEncoder.c \
	bin/sanka/net/Socket.c

OBJS=	bin/panic.o \
	bin/array.o \
	bin/rb.o \
	bin/string_add.o \
	$(SRCS:.c=.o)

CC=	gcc
DBG=	-O6
CFLAGS=	$(DBG) -I. -Ibin

all:	bin bin/libsankaruntime.a

bin:
	mkdir -p bin

bin/libsankaruntime.a: $(OBJS)
	rm -f $@
	ar rc $@ $^

$(SRCS):
	sanka --skip-imports --top bin `find sanka -name '*.san'`

bin/%.o: %.c
	$(CC) $(CFLAGS) -o $@ -c $<

%.o: %.c
	$(CC) $(CFLAGS) -o $@ -c $<

clean:
	rm -rf bin *~

install: all
	mkdir -p $(PREFIX)/lib
	cp bin/libsankaruntime.a $(PREFIX)/lib/
	mkdir -p $(PREFIX)/include
	cp -p rb.h sanka_header.h $(PREFIX)/include/
	tar cf - `find sanka -name '*.san'` | (cd $(PREFIX)/include; tar xf -)
	cd bin; tar cf - `find sanka -name '*.h'` | (cd $(PREFIX)/include; tar xf -)

FORCE:
