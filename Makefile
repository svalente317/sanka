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
LIBS=             $(ANTLR_RUNTIME):$(COMMONS_COMPRESS)
endif

ifeq ($(UNAME), Darwin)
ANTLR_RUNTIME=	    lib/antlr-runtime-4.7.2.jar
COMMONS_COMPRESS=   lib/commons-compress-1.20.jar
I_ANTLR_RUNTIME=    $(PREFIX)/$(ANTLR_RUNTIME)
I_COMMONS_COMPRESS= $(PREFIX)/$(COMMONS_COMPRESS)
LIBS=               $(I_ANTLR_RUNTIME):$(I_COMMONS_COMPRESS)
endif

SRCS=   src/main/java/sanka/*.java \
        src/main/java/sanka/c/*.java \
        src/main/java/sanka/antlr4/*.java

TOP=    bin

all:	bin/sanka.jar bin/sanka.sh

bin/sanka.jar: compile
	jar -c -f $@ -C $(TOP) sanka

bin/sanka.sh: FORCE
	echo '#!/bin/sh' > $@
	echo exec java -cp ${PREFIX}/share/sanka.jar:$(LIBS) \
	sanka/SankaCompiler -I ${PREFIX}/include -L ${PREFIX}/lib '"$$@"' >> $@
	chmod 755 $@

compile: FORCE
	javac -g $(SRCS) -d $(TOP) -cp $(ANTLR_RUNTIME):$(COMMONS_COMPRESS)

clean: FORCE
	rm -rf bin *~

install: all
	mkdir -p $(PREFIX)/bin
	mkdir -p $(PREFIX)/share
	cp bin/sanka.sh $(PREFIX)/bin/sanka
ifeq ($(UNAME), Darwin)
	mkdir -p $(PREFIX)/lib
	cp $(ANTLR_RUNTIME) $(I_ANTLR_RUNTIME)
	cp $(COMMONS_COMPRESS) $(I_COMMONS_COMPRESS)
endif
	cp bin/sanka.jar $(PREFIX)/share/

FORCE:

AO=https://github.com/ivmai/libatomic_ops/releases/download/v7.6.8/libatomic_ops-7.6.8.tar.gz
GC=https://github.com/ivmai/bdwgc/releases/download/v7.6.10/gc-7.6.10.tar.gz

CONFIGURE =   ./configure --prefix=$(PREFIX) --disable-shared
#CONFIGURE2 = PKG_CONFIG_PATH=$(PREFIX)/lib/pkgconfig $(CONFIGURE)
CONFIGURE2  = ATOMIC_OPS_CFLAGS=-I$(PREFIX)/include \
              ATOMIC_OPS_LIBS=-L$(PREFIX)/lib $(CONFIGURE)

install-libgc:
	curl -L $(AO) | gzip -cd | tar xf -
	cd libatomic_ops-7.6.8 && $(CONFIGURE) && make install
	rm -rf libatomic_ops-7.6.8
	curl -L $(GC) | gzip -cd | tar xf -
	cd gc-7.6.10 && $(CONFIGURE2) && make install
	rm -rf gc-7.6.10
