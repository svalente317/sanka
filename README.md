# Sanka Programming Language

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

I like this language. It's that simple.

Sanka is in the same class of languages as Go, Rust, C++, and [insert
your favorite compiled language here]. All of those languages are
perfectly fine. I'm not going to tell you that mine is better, or that
you should use mine instead of anything else. I simply like this
language. The syntax and the details and the philosophy all work for
me. If you like it too, that's great. If not, that's fine too.

## Syntax

Sanka uses Java's syntax. For example, here is a program that compiles
and runs in both Java and Sanka:

~~~
class Hello {
    static void main(String[] argv) {
        System.out.println("Hello, world!");
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
* Objects and arrays are mutable.

Here are the Java constructs that Sanka does not provide:

* Sanka does not provide class inheritance or subclasses or abstract classes.
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
arr = new int[]{17, 34};
arr.add(51);
~~~

Arrays have two advantages over `List` classes. (1) The array syntax
is nicer. (2) You can create an array of a primitive type like `int`
without promoting it to a class like `Integer`.

Also, Sanka supports sorted maps as a built-in type. The maps use an
array-like syntax. For example:
~~~
map = new String[class int];
map[2018] = "Hello, world!";
~~~

For more information on all Sanka types, including arrays and maps,
see docs/Builtin-Types.md.

**inline keyword**

Unlike Java, Sanka allows you to create an object as a local variable
on the stack rather then on the heap. To do this, use the `inline`
keyword. For example, if `Point` is a class with two integer fields,
then this code puts a structure with two integer fields on the stack:
~~~
inline var point = new Point(0, 0);
~~~

After the object has been created, Sanka tries to hide the fact that
it's on the stack. You access it just like you would access a
non-inline variable. You can access its fields and methods, pass it as
an argument in a function call, etc. There is no need for operators
like `&` and `->`.

Inline local variables have the same pros and cons in Sanka as they do
in C. The benefit is that the variable is easily cleaned up when the
program exits the stack frame, with no memory fragmentation. The
drawback is that if you store a reference to the variable (in a
non-inline structure or array), and then you try to access the
variable after you have left its stack frame, then the program
dies. The drawback is considerable.

Similarly --

When you define a class, you can define "inline" fields. In other
words, you can define a field such that the class allocates space for
the object, rather then for a reference to the object. For example,
this code defines a class such that the size of the class is the size
of two integers, rather then the size of a single reference:
~~~
class Window {
    inline Point size;
}
~~~

Again, the benefit is that this avoids memory fragmentation.

And finally, you can also inline objects in an array, just like you
can inline objects in a class. For a full discussion of the `inline`
keyword -- the syntax, the limitations, etc. -- see docs/Inline.md,
which has not yet been written.

**export keyword**

The `export` keyword is syntactic sugar to get around the fact that a
Sanka class cannot extend another class. `export` provides the
illusion that a class extends one (or more) of its fields. When you
export a field, the compiler adds copies of all of the field's public
methods to the parent class. For example, say that the class `Person`
has a method with the signature:
~~~
public String getName();
~~~
Then you can define a class `Doctor`:
~~~
class Doctor {
    private Person person;
    export person;
}
~~~
The `export` line tells the compiler to add this method:
~~~
public String getName() {
    return this.person.getName();
}
~~~

This is just syntactic sugar. At runtime, there's no difference
between a method was added by the compiler and one that was explicit
in the source code. Note, for example, that the `Person` object does
not have access to the `Doctor` object, so if `person.getName()` calls
`this.helper()`, then it calls the `Person` helper function,
regardless of whether there exists a `Doctor` helper function.

You can export multiple fields, but if there are any public method
name conflicts, then it is a compile-time error.

Also, you can export specific methods, like `export person.getName`.

*Implicit Interfaces**

When you declare a class, you do not need to explicitly specify what
interfaces it implements. The compiler determines whether a class
implements an interface.

**Less Stuttering**

When you declare a local variables, you do not need to explicitly
specify its type. Use the keyword "var" to declare a local
variable. The first time that the compiler sees an assignment to that
variable, where the RHS is any value or expression other then `null`,
the compiler evaluates the type of the RHS, and that is the type of
`x`.  Then, it is a compile error for `x` to be used as any other
type.

## Open Questions

* Should the language directly support threads and synchronization,
  or should they be supported only by the runtime class library?
* Should the language support slices or channels as defined in Go?
* Are there other constructs in other languages that are worth stealing?
* Even though Sanka is an imperative language, it must support some kind of
  adapter or closure or lambda. What is the best syntax for doing so?
