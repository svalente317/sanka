#!/bin/sh
PREFIX="$1"
filename="$2"
classpath=`echo ${PREFIX}/lib/*.jar | tr " " ":"`
echo '#!/bin/sh' > "$filename"
echo exec java -cp "$classpath" sanka/SankaCompiler -I ${PREFIX}/include -L ${PREFIX}/lib '$@' >> "$filename"
chmod 755 "$filename"
