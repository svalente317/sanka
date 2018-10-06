#!/bin/sh
#
# Dump a bunch of words to stdout.

tmpfile=/tmp/random$$.html
curl -s -L 'https://en.wikipedia.org/wiki/Special:Random' > $tmpfile
cat $tmpfile |
    tr " " "\n" |
    grep '^[a-z]*$' |
    sort -u |
    grep . |
    shuf
