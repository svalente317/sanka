# Sanka Command Line Options

## Default Mode

Specify a set of Sanka source files. The names and locations of the files can be freeform. The directory names are not required to match the package names, and the file names are not required to match the class names. A single source file can contain any number of classes (in a single package).

For each class, Sanka generates `.c` and `.h` files. Sanka creates a directory tree matching the package name, and it creates files matching the class names.

For example, run:
~~~
sanka two_classes.san
~~~
Where the contents of two_classes.san is:
~~~
package foo.bar.baz;
class ClassOne {}
class ClassTwo {}
~~~
Then Sanka will create these four files:
1. foo/bar/baz/ClassOne.h
2. foo/bar/baz/ClassOne.c
3. foo/bar/baz/ClassTwo.h
4. foo/bar/baz/ClassTwo.c

## Specify the top of the build tree

Use the `--top` argument to specify where Sanka creates its output files. For example, run:
~~~
sanka --top /home/svalente/build two_classes.san
~~~
Then Sanka will create these four files:
1. /home/svalente/build/foo/bar/baz/ClassOne.h
2. /home/svalente/build/foo/bar/baz/ClassOne.c
3. etc.

## Building an application

Say that you want to build a "self-contained" application. By "self-contained", I mean that the application does not depend on any 3rd party libraries or pre-compiled libraries, other then the basic Sanka runtime library. So you are providing the source code for the entire application. To do this, specify all of the Sanka source files on the command line, and use the `--main` argument and the `--exe` argument.

* For `--main`, specify the name of a class, including its package name.
* For `--exe`, specify the name of the executable file to create.

The `--main` class must have a static method named `main`. The application will run that method. For example, run:
~~~
sanka two_classes.san third_class.san --main foo.bar.baz.ClassOne --exe runme
~~~
This will create the build-tree as above, and it will also create a `.o` file along with each `.c` file:
1. foo/bar/baz/ClassOne.h
2. foo/bar/baz/ClassOne.c
3. foo/bar/baz/ClassOne.o
etc.

And it will create ehe compiled execuable file `runme`.

## Building a library for use by other applications

TODO

## Building an application with prebuilt libraries

TODO
