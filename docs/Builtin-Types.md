# Sanka Builtin Types

Sanka has ten builtin types:
* 1 boolean
* 4 integral
* 2 floating point
* 3 classes

The first seven (1 boolean, 4 integral, and 2 floating point) are called
the primitive types. Also called the scalar types.

## Boolean

The type `boolean` can have values `false` and `true`. Boolean is a
distinct type; it is not an alias for `int`. There is no automatic
conversion from `int` to `boolean` or vice-versa. In an `if` statement
or a `while` or `for` statement, the condition must be a boolean
expression.

## Integral Types

There are four integral types: `byte`, `short`, `int`, and `long`.
They are signed types of 8, 16, 32, and 64 bits, respectively.

The arithmetic operators are the four obvious ones: `+`, `-`, `*`,
`/`. And also remainder `%` and the three bitwise operators `<<`,
`>>`, `~`.

`byte` and `short` are not useful for arithmetic. These values are
automatically promoted to `int` when they are used in an arithmetic
expression. For example, this is a compile-time error:
~~~
short doArithmetic(short s1, short s2) {
    return s1 + s2;
}
~~~

The problem is that `s1` and `s2` are converted to `int` for addition,
so the return value must be an `int`. Or you can cast the result back
to a short. This is fine:
~~~
short doArithmetic(short s1, short s2) {
    return (short)(s1 + s2);
}
~~~

TODO: I don't like casting. I want Sanka to feel familiar to C and
Java programmers, but I'm considering dropping casts from the
language, and using this syntax instead:
~~~
    return new short(s1 + s2);
~~~

Of course, in any arithmetic operation, if one of the operands is a
`long`, then the other one is promoted to `long`, and the result is
`long`.

Note that `byte`, `short`, and `int` values will be promoted as
necessary to match method argument types and return types. For
example, this recursive function will compile and run:
~~~
void promoter(byte b, short s, int i, long lg) {
    if (lg > 0) {
        promoter(0, b, s, i);
    }
}
~~~

## Floating Point Types

There are two floating point types: `float` and `double`. They are
signed 32 and 64 bit types that work as they do in C. Something about
two's complement? And I think that floats are promoted to double for
arithmetic? I should care more about this.

## Character Type

Sanka does not have a character type. However, it does recognize ascii
characters as integer literals. For example, this statement:
~~~
    var v = 'a';
~~~
is equivalent to this statement:
~~~
    var v = (byte) 65;
~~~

## Class Types

Sanka has three builtin non-scalar types. All three of these blur the
line between "language features" and "class-library features". All
three act like user-defined classes:

* The classes have public fields and methods
* Instances of these types can match interfaces
* Variables of these types can be `null`

However, all three are partially built into the language. (There is
special code in the translator for them.) Thus, these classes have
power and efficiency that they could not have if they were built
entirely in the class library.

## String

A `String` is an immutable sequence of bytes. A String can be
initialized from a series of ascii characters in quotes:
~~~
    var s = "Hello, world!";
~~~

To create a String with bytes that do not have corresponding ascii
characters, use a more complex form of string literal. (This has not
been defined yet. Please define it if you like.) Or, use an array of
bytes:
~~~
    var arr = new byte[]{1, 2, 3};
    var s = new String(arr);
~~~

An application may choose to interpret these bytes as ASCII, UTF-8,
etc., but this support is not built into the language.

Since `String` is builtin to the language, it supports the comparison
operators `==`, `<`, `>`, etc. These work by doing a byte-by-byte
comparison between two Strings. The bytes have no particular meaning
as characters or letters. They are compared as integers.

If `s1` and `s2` are the same sequence of bytes, then `s1 == s2`.

The `+` operator joins two strings into a new string. If a string is
added to a primitive numeric type, then that number is converted to a
string (in base 10) and added to the string.

The `String` class has these methods:
* `int length()` Return the number of bytes in the string
* `byte byteAt(int n)` Return the n'th byte in the string
* `int indexOf(byte b)` Return the index of the first occurrence of `b`
* `int find(String s)` Return the index of the first occurrence of `s`
* `boolean startsWith(String s)` Return true if this string starts with `s`
* `boolean endsWith(String s)` Return true if this string ends with `s`
* `String substring(int beginIndex, int endIndex)` Return a substring

## Array

An array is a mutable sequence of items of a type. As in C and Java,
arrays support primitive types, and builtin and user-defined classes:
~~~
    var arr1 = new int[7];
    var arr2 = new String[8];
    var arr3 = new UserDefinedClass[9];
~~~

The array elements are initialzed to zero for numeric types, and null
for class types. (And false for boolean. Note that boolean arrays are
not very space efficient.)

An array can be initialized with a number of items or with a sequence
of items:
~~~
    var arr1 = new String[1];
    var arr2 = new String[]{"hello", "world", thirdString()};
~~~

Arrays use square bracket notation on the left-hand-side to set an
element, and on the right-hand-side to get an element.
~~~
    arr[0] = "new string";
    var s = arr[1];
~~~

The array class has a `length` field, and these methods:
* `void add(T item)` Add item to the array
* `void insert(int n, T item)` Add item as the n'th item in the array.
   The rest of the array is shifted to the right.
* `void delete(int n, int count)` Delete items from the array, from the
  n'th item. The rest of the array is shifted left.
* `T pop()` Delete the last item from the array, and return it.
* `void setLength(int n)` If the array is shorter then n, then add items
  with the default value. If the array is longer then n, then truncate it.
* `void addAll(T[] arr)` Add the items in arr to the end of this.

Initially, an array is allocated with the exact amount of memory that
you specify. But all of the array methods may allocate a little extra
memory if it may make the program more efficient. For example:
~~~
var arr = new int[3];
arr.add(17);
~~~

Initially, `arr` is the three element array `{0, 0, 0}`, and no
further memory has been allocated. After the call to add(), it is the
four element array `{0, 0, 0, 17}`. And there may be a little extra
memory at the end of the array, so that the next call to add() can
be processed efficiently.

Of course, the arithmetic operators and the comparison operators are
meaningless on arrays, just as they are on user-defined classes.

## Map

The builtin map class is a lot like the builtin array class. A map is
also a mutable collection of items of a type (primitive type or class
type). The difference is that a map is indexed by non-sequential
integers or strings.

To initialize a map, use the same notation as an array, except that
instead of a number of items, specify `int` or `String`:
~~~
    var map1 = new double[String];
    var map2 = new String[int];
    var map3 = new UserDefinedClass[int];
~~~

Maps use square bracket notation on the left-hand-side to set an
element, and on the right-hand-side to get an element.
~~~
    var map = new String[String];
    map["hello"] = "world";
    var s = arr["hello"];
~~~

Why does the builtin map restrict keys to `int` and `String` types,
instead of allowing user-defined types? Because the map sorts its
keys. `int` and `String` are good keys because they are immutable and
fully-ordered.

The `Map` class has these methods:
* `int size()` Return the number of keys in the map
* `boolean contains(K key)` Return true if the key is in the map
* `boolean remove(K key)` Remove the key from the map. Return true
  if key was found and removed.
* `void clear()` Remove all keys from the map

## Errors

When you try to access a field of any object that is null, whether the
object's type is a String or an array or a user-defined type or etc.,
the program dies with a Null Pointer Exception. For example:
~~~
    var s = "hello";   // "s" is of type String
    s = null;          // Valid assignment for type String
    System.println(s.length());   // Compiler accepts this. Dies at runtime.
~~~

If you have two strings that may or may not be null, then you can
compare them for equality. Obviously, `null` equals `null`, and `null`
does not equal any non-null string, including the empty string.
However, the less-then and greater-then operators are undefined for
`null`. For example, consider this function:
~~~
boolean compareStrings(String s1, String s2) {
    return s1 < s2;
}
~~~

The call `compareStrings("hello", null)` will die with a Null Pointer
Exception.

If you access past the end of an array, then it will die with an Out
Of Bounds Exception. For example:
~~~
    var arr = new int[2]; // valid indexes are [0] and [1]
    var value = arr[2];   // Dies at runtime.
    var value2 = arr[-1]; // Also dies at runtime.
~~~

If you define a map with String as the key type, and you add a key of
null, then it will die with a Null Pointer Exception, since the map
must be able to compare the key to the other keys.

However, other then `null`, a map is spans the entire domain of its
key type (int or String). So, if you access a key that is not in the
map, then the map returns the "default" value, which is the value of
new elements in a new array. For example:
~~~
    var map1 = new int[int];
    var value1 = map1[17];   // Now value1 == 0

    var map2 = new String[String];
    var value2 = map["seventeen"];  // Now value2 == null
~~~

## Multi-Dimensional Arrays

Sanka does not support creating two-dimensional arrays (matrices) as a
single contiguous block of memory. Instead, create an array of arrays.
~~~
    var matrix = new int[][3];
    matrix[0] = new int[7];
    matrix[1] = new int[7];
    matrix[2] = new int[7];
~~~

The first line reads as: "matrix is an array with three elements where
each element has type `int[]`."

This syntax may seem backwards to you. You may expect the 3 to be in
the first set of brackets (as it is in Java) rather then the
last. However, consider that Sanka supports maps of arrays of maps of
arrays of maps, etc. For example:
~~~
   var x = new int[][int][][String][3];
~~~

This reads as: "x is an array with three elements where each element
is a map. The map has key type String and value type
`int[][int][]`. That value type is an array where each element has
type `int[][int]`. That value type is a map... etc."

Just strip off the components from right to left.
