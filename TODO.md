# TODO

## High Level Design Issues

* Garbage collection

* Support classes with the same name in different packages

## Unimplemented features

* support inline fields

* support "exports" keyword

* iterate over strings

* implement map builtin methods

* type checking in ternary op

* Do not access "this" or instance method in LHS or RHS in static method

* Improve support for char literals and complex literals

* float to double promotion and demotion

* Support parameterized types

* Allow multiple constructors with different signatures

* Support expressions with qualified class name or classes in the current
  package (in ED.evaluatePrimary)

* Support "new" with class body - adapter statements

* Support 2d arrays - initialization and code generation

* Support "var x, y;"

* Support fields "int x, y;"

* Support static field initialized to literal array

* what if map changes during iteration?

* Error if two classes have same qualified name

* Implement "x == y" where x or y is an interface

* Allow class constants to be accessed as local variables

* Implement ArrayUtils "addAll"

* Support MAP[IDX]++ in StatementDefinition.translateMapAssignment
