#!/bin/sh
dir="$PWD"
src="$1"
if [ -z "$src" ]; then
    src="${dir}/examples/Syntax.sk"
fi
exec java -cp ${dir}/bin:/usr/share/java/antlr4-runtime.jar sanka/Translator "$src"
