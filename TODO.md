* Support static fields and static methods

* support const variable declaration and generation

* Translate CONTINUE statement

* generate correct code for "b[0][0] = value;"

* type checking for equals binary ops

* type checking in ternary op

* Error if two classes have same qualified name

* Calculate which primitive types are compatible

* Support new array with values - parse and translate

* Support char literals - evaluate and translate

* Support complex literals - evaluate and translate

* allow inline classes to be null.

* make strings and arrays inline classes.

* Support import

* Support interface

* Support parameterized types

* Support class field and method with same name?

* Correctly import String class

* Move arrayClassDefinition from ClassDefinition to Builtins

* Allow multiple constructors with different signatures?

* Support inline fields:
  1. Evaluate pass - check restrictions in var def and assign
  2. Translate pass - everywhere

* Support dot-dot-dot functions:
  1. Evaluate pass - check types
  2. Translate pass - generate code in function definition
  3. Translate pass - generate code when calling function

* Support switch statements - byte, char, short, int, String

* support enhanced for statement

* Support expressions with class name (local)

* Support expressions with class name (qualified)

* Support "new" with class body - adapter statements

* Support character arithmetic

* Support character comparisons

* Support initialization of 2d array

* Support "var x, y;"
