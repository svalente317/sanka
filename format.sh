#!/bin/sh
cd src/sanka
for file in *.java c/*.java; do
    expand -t 4 $file > x && sed -i 's/[[:space:]]*$//' x
    cmp -s $file x || mv x $file
done
rm -f x
