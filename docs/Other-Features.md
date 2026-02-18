# Sanka Features

The main Sanka documentation is in the top-level
[README.md](../README.md) file. Please read that file first.

The second most importand Sanka documentation is in the file
[Builtin-Types.md](Builtin-Types.md). Please read that file second.

Here are some other Sanka features that were not important enough to
mention in those two documents.

### Initializing Object, Arrays, and Maps

Sanka supports a bit of syntax which was inspired by Python. In
Python, it is easy to create a map with values, such as
`{"key":"value}`, and to create an array with values, such as `[1, 2,
3]`. In Sanka (as in Java), it's not always quite that terse, because
Sanka is a strongly-typed language, so sometimes you need to
explicitly specify types. But in the common case, Sanka support quick
and easy (terse) creation of objects, arrays, and maps with
values. See [Creators.md](Creators.md).

### Anonymous Classes

To create an object of an anonymous class, use the syntax `new {}`.

An anonymous class can have public and private methods. For example:
~~~
var x = new {
    void run() {
        this.doRun();
    }

    private void doRun() {
        ...
    }
}
~~~
In this example, `x` is an object with a public `run` method, so `x`
implements the `Runnable` interface.

An anonymous class cannot have a constructor method. The object is
constructed immediately.

The word "new" can be followed by the keyword "with" and then a list
of local variables which are assigned to public fields with those
names in the new anonymous object. For example:

~~~
Runnable make(String name) {
    return new with name {
        void run() {
            System.println("Hello, " + this.name);
        }
    };
}
~~~

The methods in an anonymous class can use the keyword "@this" to
reference the the variable "this" of the context where the anonymous
object was created.

### typeswitch

TODO. Document this.

### "serializable" and "singleton" class modifiers

TODO. Document this.

### Auto Constructors

TODO. Document this.

### Inline Fields in Objects

TODO. Implement and document this.
