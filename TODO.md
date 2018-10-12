# TODO

## High Level Design Issues

* Garbage collection

* Support classes with the same name in different packages

## Unimplemented features

* support inline fields

* support "exports" keyword

* support "switch" statement

* Unary and binary ops:
  * type checking and promotion
  * special code for string comparison, etc.
  * special promotion rules for literals
  * literal folding

* finish implementing string, array, and map builtin methods

* iterate over strings

* Support new array with values

* type checking in ternary op

* Do not access "this" or instance method in LHS or RHS in static method

* Improve support for char literals and complex literals

* Support parameterized types

* Allow multiple constructors with different signatures

* Support expressions with qualified class name

* Support "new" with class body - adapter statements

* Support initialization of 2d array

* generate correct code for "b[0][0] = value;"

* Support "var x, y;"

* Support fields "int x, y;"

* Support static field initialized to literal array

* static fields without initial values should be initialized to zero

* const fields (not local variables)

* const local variables (not fields)

* translate float and double in strings

* what if map changes during iteration?

* Error if two classes have same qualified name
