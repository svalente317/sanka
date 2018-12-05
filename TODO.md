# TODO

## High Level Design Issues

* Garbage collection

* Support classes with the same name in different packages

* Parameterized types

## Unimplemented features

* support inline fields

* support "exports" keyword

* string to array and array to string

* Improve support for char literals and complex literals?

* float to double promotion and demotion

* Allow multiple constructors with different signatures

* Support expressions with qualified class name or classes in the current
  package (in ED.evaluatePrimary)

* Support "new" with class body - adapter statements

* Support 2d arrays - initialization and code generation

* Support static field initialized to literal array

* what if map changes during iteration?

* Error if two classes have same qualified name

* Implement "x == y" where x or y is an interface

* Allow class constants to be accessed as local variables

* Implement ArrayUtils "addAll" and Map "clear"

* Support MAP[IDX]++ in StatementDefinition.translateMapAssignment

* Serializable classes

* Add byte to string as character

* json library: escape quotes in strings,
* json library: JsonObject needs "set" functions
* json library: add JsonArray
* json library: implement parse()
