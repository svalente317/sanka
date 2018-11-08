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

* When you declare a local variables, you do not need to explicitly
  specify its type. Use the keyword "var" to declare a local
  variable. The first time that the compiler sees an assignment to
  that variable, where the RHS is any value or expression other then
  `null`, the compiler evaluates the type of the RHS, and that is the
  type of `x`.  Then, it is a compile error for `x` to be used as any
  other type.
* When you declare a class, you do not need to explicitly specify what
  interfaces it implements. The compiler determines whether a class
  implements an interface.

**inline keyword**

Sanka does not provide a way to dereference an object and access its
block of memory. It does not provide the `&` and `*` operators that C
and Go provide, because they are a syntactic nightmare. However, the
philosophy says that the language should not be a barrier to efficient
programming. So the `inline` keyword provides the most important
functionality that `&` would provide.

When you define a class, you can define fields as "inline" fields, e.g.:
~~~
class Window {
    inline Point size;
}
~~~

This indicates that the block of memory for the field should be allocated
as part of the block of memory of the containing object. It's the
equivalent of putting a structure inside of another structure in C.

An inline field can be used like a normal field. When you pass the
field as an argument to a function, you pass a reference, just like
any other field. (This is where Sanka simulates C's `&` operator.) The
special rules that apply to inline fields are:

1. When you assign a value to the field, the RHS must use the `new`
keyword. So this is legal:
~~~
this.size = new Point(100, 200);
~~~
But these are compile-time errors:
~~~
this.size = parentWindow.getSize();
this.size = null;
~~~

2. If you access an inline field before you assign it a `new` value,
then the result is undefined.

3. If you store references to the inline field, then they are only
valid as long as the containing object is valid. References to inline
fields do not keep the containing object alive. It could get garbage
collected. Then, if you try to use a reference to the inline field,
the result is undefined. (This is where Sanka simulates C's "you can
shoot yourself in the foot" philosophy.)

To be safe, do not store references to inline fields. Clone the field
if necessary. To be really safe, do not inline public fields. Only
inline private fields, so that no reference can escape.

Also, you can inline local variables. This puts the object's block of
memory on the stack instead of the heap.  The same rules apply: You
can only assign `new` instances to the local variable. You cannot
safely access it before you assign it a value. And you cannot safely
store references to the local variable if the references would live
longer then the variable.

Also, you can inline objects in an array, by putting the `inline`
keyword in the square brackets:
~~~
Point[] pointArray = new Point[inline this.getSize()];
~~~
Of course, the same three rules apply again.

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

(Should the language support exporting specific methods, like `export
person.getName`? Should it support exporting a field and then
overriding one or more of its methods?)

**Dynamic Arrays and Maps**

In Sanka, you can change the size of an array after you create it.  So
you can use an array where Java would force you to use a `List` class.
Arrays have two advantages over `List` classes. (1) The array syntax
is nicer. (2) You can create an array of a primitive type like `int`
without promoting it to a class like `Integer`.

Also, Sanka supports sorted maps as a built-in type using an
array-like syntax.

For more information on all Sanka types, including arrays and maps,
see docs/Builtin-Types.md.

## Open Questions

* Should the language directly support threads and synchronization,
  or should they be supported only by the runtime class library?
* Should the language support slices or channels as defined in Go?
* Are there other constructs in other languages that are worth stealing?
* Even though Sanka is an imperative language, it must support some kind of
  adapter or closure or lambda. What is the best syntax for doing so?
