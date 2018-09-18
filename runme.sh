#!/bin/sh
dir="$PWD"
exec java -cp ${dir}/bin:/usr/share/java/antlr4-runtime.jar sanka/Translator "$@"
