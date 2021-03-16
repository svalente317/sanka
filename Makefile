# Build the sanka compiler.
#
# Install the compiler shell script as
# $prefix/bin/sanka
#
# Install the compiler jar file as
# $prefix/share/sanka.jar

PREFIX=/opt/sanka

all:
	@echo use \'./gradlew\' to build and \'make install\' to install

install:
	./gradlew installDist
	mkdir -p $(PREFIX)/bin
	mkdir -p $(PREFIX)/lib
	cp build/install/sanka/lib/sanka.jar $(PREFIX)/lib/
	cp build/install/sanka/lib/antlr4-runtime-4.9.2.jar $(PREFIX)/lib/
	cp build/install/sanka/lib/commons-compress-1.20.jar $(PREFIX)/lib/
	@echo '#!/bin/sh' > build/sanka
	@echo exec java -cp $(PREFIX)/lib/sanka.jar:$(PREFIX)/lib/antlr4-runtime-4.9.2.jar:$(PREFIX)/lib/commons-compress-1.20.jar sanka/SankaCompiler -I $(PREFIX)/include -L $(PREFIX)/lib '"$$@"' >> build/sanka
	install -m 755 build/sanka $(PREFIX)/bin/sanka

AO=https://github.com/ivmai/libatomic_ops/releases/download/v7.6.8/libatomic_ops-7.6.8.tar.gz
GC=https://github.com/ivmai/bdwgc/releases/download/v7.6.10/gc-7.6.10.tar.gz

CONFIGURE =   ./configure --prefix=$(PREFIX) --disable-shared
CONFIGURE2  = ATOMIC_OPS_CFLAGS=-I$(PREFIX)/include \
              ATOMIC_OPS_LIBS=-L$(PREFIX)/lib $(CONFIGURE)

install-libgc:
	curl -L $(AO) | gzip -cd | tar xf -
	cd libatomic_ops-7.6.8 && $(CONFIGURE) && make install
	rm -rf libatomic_ops-7.6.8
	curl -L $(GC) | gzip -cd | tar xf -
	cd gc-7.6.10 && $(CONFIGURE2) && make install
	rm -rf gc-7.6.10
