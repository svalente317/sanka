Creating Objects, Arrays, and Maps in Sanka
===========================================

## Objects

To create a new object, call `new` with the class name and then the
arguments to pass to the constructor method. For example:
~~~
var socket = new Socket();
var file = new File("Creators.md");
~~~

Often, after creating a new object, you want to assign values to the
object's public fields. As a shorthand for doing this, you can follow
the call to the constructor with curly braces containing a series of
field-value pairs. For example:
~~~
var stats = new FileStats(){
    isFile: true,
    length: 128
};
~~~

Note that this is just shorthand; it is not unique functionality. The
above example is exactly equivalent to:
~~~
var stats = new FileStats();
stats.isFile = true;
stats.length = 128;
~~~

## Arrays

1. The easiest way to create an array is simply `new`, followed by
`[]` which indicates that it's an array, followed by the name of the
class. In this case, do not use parentheses, since this is not a
function call. For example, this creates an empty array of Strings,
and then adds a String to it:
~~~
var arr = new []String;
arr.add("hello");
~~~

2. To create an array containing some null elements, specify the type
of the array, and then the initial size of the array in parentheses.
For example, this creates an array of five Strings, where all of them
are null, and then it sets the first slot in the array to the string
"x5":
~~~
var arr = new []String(5);
arr[0] = "x" + arr.length;
~~~

3. To create an array containg a specific set of elements, specify the
type of the array, and then curly braces containing the elements. For
example, this creates an array with two specific Strings:
~~~
var arr = new []String{"hello", "world"};
~~~

Note that the following three expressions are exactly equivalent to
each other. They all create the exact same zero-element array, which
can be accessed and modified like any other zero-element array:
~~~
arr = new []String;
arr = new []String(0);
arr = new []String{};
~~~

The first way is the preferred way to create an empty array.

4. To create an array containing a specific set of elements, if each
initial element has the exact desired type of the array values, then
as shorthand, you can omit specifying the array type. For example, the
following two expressions are exactly equivalent to each other:
~~~
arr = new []String{"hello", "world"};
arr = {"hello", "world"};
~~~

The shorthand way is preferred whenever possible. (Note that you sometimes must use the verbose syntax. For example, when you want to create an array of type T where T is an interface that the initial elements implement. And certain similar cases involving abstract classes, and shorts/ints/longs, etc.)

## Maps

## Anonymous Classes
