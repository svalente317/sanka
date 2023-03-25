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

1. To create an empty array, call `new`, followed by the name of the
class, followed by `[]` which indicates that it's an array, In this
case, do not use parentheses, since this is not a function call. For
example, this creates an empty String array:
~~~
var arr = new String[];
~~~
Then you can add a String to it:
~~~
arr.add("hello");
~~~

2. To create an array containing some null elements, specify the type
of the array, and then the initial size of the array in parentheses.
For example, this creates a String array with five slots:
~~~
var arr = new String[](5);
~~~
Here, `arr.length == 5`. You can read and write the values as
`arr[i]`, as well as calling `arr.add()`, etc.

3. To create an array containg a specific set of elements, specify the
type of the array, and then curly braces containing the elements. For
example:
~~~
var arr = new String[]{"hello", "world"};
~~~
Here, `arr.length == 2` and `arr[0] == "hello"`.

4. Note that the following three expressions are exactly equivalent to
each other. They all create the exact same zero-element array, which
can be accessed and modified like any other zero-element array:
~~~
arr = new String[];
arr = new String[](0);
arr = new String[]{};
~~~
The first way is preferred to create an empty array.

5. To create an array containing a specific set of elements, if each
initial element has the exact desired type of the array values, then
as shorthand, you can omit specifying the array type. For example, the
following two expressions are equivalent to each other:
~~~
arr = new String[]{"hello", "world"};
arr = {"hello", "world"};
~~~

The shorthand way is preferred whenever possible. (Note that
sometimes, you must use the verbose syntax. For example, when you want
to create an array of type T where T is an interface that the elements
implement. And certain similar cases involving abstract classes, and
shorts/ints/longs, etc.)

## Maps

1. To create an empty map, call `new map` followed by the key type
which is `[int]` or `[String]`, followed by the map value type. For
example, this creates an empty map from String keys to Thread values:
~~~
var threads = new map[String]Thread;
~~~

2. Often, after creating a new map, you want to add key value pairs to
the map. As a shorthand for doing this, you can follow the `new` call
with curly braces containing a set of key-value pairs. For example:
~~~
var names = new map[String]int{
    "one": 1,
    "seventeen": 17,
    "hundred": 100
}
~~~

Note that this is just shorthand; it is not unique functionality. The
above example is exactly equivalent to:
~~~
var names = new map[String]int;
names["one"] = 1;
names["seventeen"] = 17;
names["hundred"] = 100;
~~~

3. If each key and value has the exact desired type for the map,
then as shorthand, you can omit specifying the map types. For
example:
~~~
var names = {"one": 1, "seventeen": 17};
~~~
The shorthand is preferred whenever possible.
