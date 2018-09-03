#!/bin/sh
src="$1"
if [ -z "$src" ]; then
    src="${HOME}/shared/sanka/examples/Syntax.sk"
fi
exec java -cp ${HOME}/shared/sanka/bin:/usr/share/java/antlr4-runtime.jar sanka/Translator "$src"
