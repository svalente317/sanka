# Null Protection in Sanka

## Variables

Variables of user-defined types cannot be null. They must reference objects.

For example, here's a user-defined class, and a global function that uses it:
~~~
class Circle {
    int radius;
}

static void printRadius(Circle circle) {
    System.println("radius is " + circle.radius);
}
~~~
Now we can create a variable of this type, and call `printRadius`:
~~~
var c = new Circle();
printRadius(c);
~~~
However, this would be a compile-time error:
~~~
printRadius(null);
~~~
And so would this:
~~~
var c = new Circle();
c = null;
~~~
Therefore, the function `printRadius` will never cause a null-pointer
exception. It is completely safe for that function to access
`circle.radius`.

But sometimes, it's useful to have a variable that may or may not
reference an object. To support this, Sanka has "nullable types". This
is a concrete type followed by a question-mark. A nullable type can be
used anywhere that a type is specified: As a function parameter, as a
function return value, as a field type in an object, etc.

For example, since we have defined the class `Circle`, there is also a
nullable type `Circle?`. These are distinct types. A `Circle` is not a
`Circle?`, and vice versa. They have different methods, different
fields, etc. (In fact, the type `Circle?` has no methods or fields.)
But a concrete type can be (automatically) converted to a nullable
type, and a nullable type can be (safely) converted to a concrete
type.

For example, here's the definition of a function that takes a nullable
type:
~~~
static void maybePrintRadius(Circle? circle)
~~~
And here are two legal ways to call that function:
~~~
maybePrintRadius(new Circle());
maybePrintRadius(null);
~~~

Nullable types have no fields or methods, so this would be a
compile-time error:
~~~
static void maybePrintRadius(Circle? circle) {
    System.println("radius is " + circle.radius);
}
~~~
One way to look inside such a variable is with the special syntax `if
[variable]`. Note that nullable types are not booleans. They can
not be used in boolean values in most expressions. The `if
[variable]` is special syntax for nullable types. This syntax makes it legal
to use the variable as its concrete type inside of the `if` block. For example:
~~~
static void maybePrintRadius(Circle? circle) {
    if circle {
        System.println("radius is " + circle.radius);
        printRadius(circle);
    }
}
~~~
Also, Sanka recognizes the boolean expressions `v == null` and `v !=
null`.

* With `if v != null`, we can dereference `v` in the `if` block.
* With `if v == null`, we can dereference `v` in the `else` block.
* With `if v == null`, if the final statement of the `if` block is a
  `return` statement, then we can dereference `v` in the rest of the
  outer block.

For example:
~~~
static void maybePrintRadius(Circle? circle) {
    if circle == null {
        System.println("bad circle");
        return;
    }
    System.println("radius is " + circle.radius);
    printRadius(circle);
}
~~~

## Fields

Given a user-defined class, if all of its fields (public and private)
are either primitive types or nullable types, then the class does not
need to have an explicit constructor. It can have an implicit
constructor. All of the primitive type fields will be initialized to
zero, and the nullable type fields will be initialized to null.

However, if a class has any concrete types among its fields, then the
class must have a constructor, and the constructor must assign initial
values to those fields. This is necessary for Sanka to guarantee that
there cannot be a null pointer exception at runtime.

The concrete type fields should not be initialized inside of `if`
blocks or any other logical constructs. For each such field, the
constructor must contain a top-level statement in the form:
~~~
this.[field] = [expression that evaluates to the concrete type];
~~~
The compiler audits the constructor, and rejects any code that
could possibly access `this.[field]` before its initialization
statement. So, the constructor cannot directly access `this.field`, or
call any `this.` methods, or pass `this` as an argument to any
function, until the concrete fields are all initialized. If the
constructor cannot handle this burden, then the field(s) must be
defined as nullable.

To convert a field from a nullable type to a concrete type, use a
local variable. For example, say that we have this class:
~~~
Class Shapes {
    Circle? circle;
}
~~~
And say that we have a variable `Shapes shapes`. In this case,
this would be a compile-time error:
~~~
if shapes.circle {
    System.println("radius is " + shapes.circle.radius);
}
~~~
The problem is that we cannot temporarily change the type of an
object's field for a single block. So, use a local variable:
~~~
var c = shapes.circle;
if c {
    System.println("radius is " + c.radius);
}
~~~

## Arrays

Sanka supports arrays of concrete types and arrays of nullable
types. For arrays of concrete types, we can only add elements of the
type, such as:
~~~
var arr = new Circle[];
arr.add(new Circle());
~~~
or
~~~
var circle = new Circle();
var arr = new Circle[]{circle};
~~~

For arrays of nullable types, we can use the above patterns, or we can
create a new array with a specified number of null elements, such as:
~~~
var size = 17;
var arr = new Circle?[](size);
~~~

## Maps

TODO
