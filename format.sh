#!/bin/sh
cd src/sanka
for file in *.java c/*.java; do
    expand -t 4 $file | sed 's/[[:space:]]*$//' > x
    cmp -s $file x || mv x $file
done
rm -f x
