#!/bin/sh
#
# Dump a bunch of words to stdout.

tmpfile=/tmp/random$$.html
wget -q 'https://en.wikipedia.org/wiki/Special:Random' -O $tmpfile
cat $tmpfile |
    tr " " "\n" |
    grep '^[a-z]*$' |
    sort -u |
    grep . |
    shuf
