## How to create single and multi-dimensional arrays

As documented in Builtin-Types.md:

Say that you want to create a two-dimensional array, meaning that you
want to create an array of arrays. You want the outer array to have
three elements, where each element is an array. In Java, the syntax
is:
~~~
    int[][] matrix = new int[3][];
    matrix[0] = new int[...];
~~~

In Sanka, the syntax is:
~~~
    var matrix = new int[][3];
    matrix[0] = new int[...];
~~~

The difference is that in Java, you specify the size of the outer
array in the _first_ set of brackets, and in Sanka, you specify it in
the _last_ set of brackets. This is confusing.

To remove this ambiguity, I propose a new syntax, where you don't
specify the size of the array in any of the brackets. Instead, you
specify it in parentheses:
~~~
    var array_of_five_ints = new int[](5);
    var array_of_two_arrays = new int[][](2);
    var array_of_three_maps = new int[String][](3);
~~~

In all cases, the expression `new Type[](x)` is an alias for
`new Type[x]`. Each of those expressions creates an array of `x`
elements where each element has type Type.

The new syntax has the pleasant feature that you see the type
_exactly_ as you would see it in a type declaration. For example, if a
function is defined as:

~~~
    void methodOnMatrix(int[][] matrix)
~~~
then you could call it as:
~~~
    var matrix = new int[][](3);
    methodOnMatrix(matrix);
~~~

In both the method signature and the `new` expression, you see the
text `int[][]`.

The new syntax also has the pleasant feature that the "parenthesis"
syntax matches the "curly brace" syntax. For example, say that you
want to create two one-dimensional arrays. The first array has three
empty slots, and the second array has three slots with the values "1,
2, 3". Note the similarity in these two statements:
~~~
    var arr1 = new int[](3);
    var arr2 = new int[]{1, 2, 3};
~~~
