# Build the sanka compiler.
#
# Install the compiler shell script as
# $prefix/bin/sanka
#
# Install the compiler jar file as
# $prefix/share/sanka.jar

PREFIX=/opt/sanka

UNAME := $(shell uname)
ifeq ($(UNAME), Linux)
ANTLR_RUNTIME=    /usr/share/java/antlr4-runtime.jar
COMMONS_COMPRESS= /usr/share/java/commons-compress.jar
endif
ifeq ($(UNAME), Darwin)
ANTLR_FILE=	lib/antlr4-runtime-4.5.1.jar
ANTLR_RUNTIME=	$(PREFIX)/$(ANTLR_FILE)
endif
LIBS=           $(ANTLR_RUNTIME):$(COMMONS_COMPRESS)

all:	bin/sanka.jar bin/sanka.sh

bin/sanka.jar: FORCE
	ant -e jar

bin/sanka.sh: FORCE
	echo '#!/bin/sh' > $@
	echo exec java -cp ${PREFIX}/share/sanka.jar:$(LIBS) \
	sanka/SankaCompiler -I ${PREFIX}/include -L ${PREFIX}/lib '"$$@"' >> $@
	chmod 755 $@

clean: FORCE
	rm -rf bin *~

install: all
	mkdir -p $(PREFIX)/bin
	mkdir -p $(PREFIX)/share
	cp bin/sanka.sh $(PREFIX)/bin/sanka
ifeq ($(UNAME), Darwin)
	cp $(ANTLR_FILE) $(ANTLR_RUNTIME)
endif
	cp bin/sanka.jar $(PREFIX)/share/

FORCE:

CONFIGURE = PKG_CONFIG_PATH=${PREFIX}/lib/pkgconfig  ./configure --prefix=${PREFIX} --disable-shared

install-libgc:
	wget https://github.com/ivmai/libatomic_ops/releases/download/v7.6.8/libatomic_ops-7.6.8.tar.gz
	wget https://github.com/ivmai/bdwgc/releases/download/v7.6.10/gc-7.6.10.tar.gz
	gzip -cd libatomic_ops-7.6.8.tar.gz | tar xf -
	cd libatomic_ops-7.6.8 && ${CONFIGURE} && make install
	rm -rf libatomic_ops-7.6.8.tar.gz libatomic_ops-7.6.8
	gzip -cd  gc-7.6.10.tar.gz | tar xf -
	cd gc-7.6.10 && ${CONFIGURE} && make install
	rm -rf gc-7.6.10.tar.gz gc-7.6.10
