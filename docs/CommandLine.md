# Sanka Command Line Options

## Default Mode

Specify a set of Sanka source files. The names and locations of the
files can be freeform. The directory names are not required to match
the package names, and the file names are not required to match the
class names. A single source file can contain any number of classes
(in a single package).

For each class, Sanka generates `.c` and `.h` files. Sanka creates a
directory tree matching the package name, and it creates files
matching the class names.

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

Use the `--top` argument to specify where Sanka creates its output
files. For example, run:
~~~
sanka --top /home/svalente/build two_classes.san
~~~
Then Sanka will create these four files:
1. /home/svalente/build/foo/bar/baz/ClassOne.h
2. /home/svalente/build/foo/bar/baz/ClassOne.c
3. /home/svalente/build/foo/bar/baz/ClassTwo.h
4. /home/svalente/build/foo/bar/baz/ClassTwo.c

## Building an application

To build an application, specify all of the Sanka source files on the
command line, and use the `--main` argument and the `--exe` argument.

* For `--main`, specify the name of a class, including its package name.
* For `--exe`, specify the name of the executable file to create.

The `--main` class must have a static method named `main`. For example,
here is hello_world.san:
~~~
package sanka.examples;

class HelloWorld {
    static int main([]String argv) {
        System.println("Hello, world!");
        return 0;
    }
}
~~~
To compile it, run:
~~~
sanka hello_world.san --main sanka.examples.HelloWorld --exe runme
~~~
This will create a build-tree with a `.o` file for each `.c` file:
1. sanka/examples/HelloWorld.h
2. sanka/examples/HelloWorld.c
3. sanka/examples/HelloWorld.o

And it will create the compiled execuable file `runme`.

## Building a library for use by other applications

A library contains a set of compiled Sanka classes in a format that
makes it easy to build other applications that use those
classes. Specifically, a library contains:

* Information about the structure of all of its Sanka classes and
  interfaces. What public field and methods do those classes provide,
  what arguments do they take, what is static, what is abstract,
  etc. This allows the Sanka compiler to do compile-time type-checking
  of code that uses the classes in the library. Note that the library
  does not contain information about the classes' private fields or
  methods, and it does not contain the classes' source code.

* C header files for all of its compiled Sanka classes and interfaces.
  This allows the Sanka compiler to compile the .c files that were
  generated from the Sanka source files that use the library.

* Compiled object files for all of its classes. These files are stored
  in the ".a" format which is used by the C linker. These files are
  architecture-specific (x86_64, arm, etc.) So, like a C library, and
  unlike a Java library, a Sanka library is built specifically for the
  system where it is used.

To build a Sanka library, specify all of the Sanka source files on the
command line, and use the `--create-library` argument. Specify the
full filename for the new library. The compiler does not add any
prefix or suffix to the name. I have been using `.tar` as the filename
suffix (because the library is stored in tar file format). It might be
good to use a double-suffix like ".sanka.tar".

For example, run:
~~~
sanka two_classes.san --create-library two_classes.sanka.tar
~~~
This creates a library for other applications to use ClassOne and ClassTwo.

## Building an application with prebuilt libraries

To build an application with libraries, use the `--lib` argument for
each library. You can also use the `-L` argument to specify
directories where the Sanka compiler should look for libraries (like
with the C linker). For example:
~~~
sanka hello_world.san --lib two_classes.sanka.tar --main sanka.examples.HelloWorld --exe runme
~~~
