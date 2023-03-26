Sanka Programming Language
==========================

svalente@mit.edu

## Overview

Sanka is a general purpose programming language. It is compiled,
strongly typed, and imperative. Its philosophy is defined as much by
what it rejects then by what it provides. The tenets are:

* What appears to be true at compile-time should remain true at run-time.
* Variables should have well-defined types.
* Types should have well-defined fields.
* Function calls should be explicit.
* Language constructs (function calls, etc.) should be lightweight.
  The language should not be a barrier to efficient code.
* Imperative programming is nice, and functional programming is nice, but
  a language should not try to be both.

## Advocacy

I like this language.

I wrote this language because: After using C++ and Java, I wanted a
language that was as easy to use as Java, and as close to the hardware
as C++. I wanted the best of both worlds. And I thought that designing
and implementing my own language would be fun. And I was right about
that.

Sanka is in the same class of languages as Go, Rust, C++, and [insert
your favorite compiled language here]. All of those languages are
fine. I doubt that I could convince you that Sanka is the best of the
bunch. But personally, I like this language a lot. The syntax and the
details and the philosophy all work for me. If you like it too, that's
great. If not, that's fine too.

## Syntax

Sanka's syntax is based strongly on Java's syntax. For example, here
is a Sanka program which looks like a Java program:

~~~
class Hello {
    static void main(String[] argv) {
        System.println("Hello, world!");
    }
}
~~~

Sanka has the following things in common with Java:

* All code is written in terms of classes with fields and methods.
* Function calls are technically pass-by-value, but the "value" of an
  object is a reference to that object, so the language is effectively
  pass-by-reference except for numeric types.
* The numeric types are byte, short, int, long, float, double.
* The language provides garbage collection.
* Fields can be public or private, and classes can be public or private.
* Many keywords work as they do in Java, such as `if`, `for`, `while`,
  `break`, `continue`, `case`.
* The `var` keyword defines local variables, as introduced in Java 10.
* Objects and arrays are mutable.
* Support for interfaces and abstract classes.

Here are the Java constructs that Sanka does not provide:

* Sanka classes are either abstract or final. Either a class is abstract
  and it can be subclassed (but not instantiated), or it is concrete and it
  can be instantiated (but not subclassed).
* Classes are a compile-time abstraction. They basically don't exist at
  runtime. I can declare variables of type `Foo`, but there is no `Foo.class`
  object accessable at runtime.
* Exceptions cannot be thrown or caught.
* Runtime exceptions (null pointer, division by zero, array out of bounds,
  etc.) kill the application.
* There is no reflection.
* There is no base Object class.
* There are no base methods like wait(), notify(), hashCode(), etc. Types
  only have the methods that you define.
* Generic objects cannot be used as synchronization monitors.
* There are no `static {}` blocks.
* There is no implicit reference to instance variables. To access the `foo`
  field, explicitly write `this.foo`.

That's what Sanka takes away. Here's what it adds:

**Fast**

Sanka is basically just a set of simple translations on top of C. And
C, of course, is basically just a set of simple translations on top of
machine code. There's no hidden complexity anywhere. Sanka code knows
at compile-time exactly where to find all fields, exactly how to call
all methods, etc. So it should be possible to write blazingly fast,
optimized Sanka programs.

**Dynamic Arrays and Maps**

In Sanka, you can change the size of an array after you create it.  So
you can use an array where Java would force you to use a `List` class.
For example:
~~~
arr = {17, 34};
arr.add(51);
~~~

Arrays have two advantages over `List` classes. (1) The array syntax
is nicer. (2) You can create an array of a primitive type like `int`
without promoting it to a class like `Integer`.

Also, Sanka supports sorted maps as a built-in type. The maps use an
array-like syntax. For example:
~~~
map = new map[int]String;
map[2018] = "Hello, world!";
~~~

For more information on all Sanka types, including arrays and maps,
see [docs/Builtin-Types.md](docs/Builtin-Types.md).

**Implicit Interfaces**

When you declare a class, you do not need to explicitly specify what
interfaces it implements. The compiler determines whether a class
implements an interface.

**Other Features**

Sanka supports several other syntax constructs that Java does not.
They are documented in [docs/Other-Features.md](docs/Other-Features.md).

## Projects

Since Sanka is intended for server-side development, the first Sanka
project is an infrastructure for creating micro web services:
[Restful Sanka](https://github.com/svalente317/restful-sanka)
