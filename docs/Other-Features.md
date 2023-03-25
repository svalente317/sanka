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

An anonymous class can have public fields. The syntax is `fieldName:
value;`, where `value` is evaluated immediately in the current
context. The anonymous class methods do not have access to the context
in which the object was created. (The methods may run long after that
context has been destroyed.) So the public fields are the only way to
preserve values from the current context for use by the methods. For
example, here is a function that returns a Runnable object where the
`run` method will output "Hello, {name}"
~~~
Runnable make(String nameParam) {
    return new {
        name: nameParam;
        
        void run() {
            System.println("Hello, " + this.name);
        }
    };
}
~~~

### typeswitch

TODO. Document this.

### "serializable" and "singleton" class modifiers

TODO. Document this.

### Auto Constructors

TODO. Document this.

### Inline Fields in Objects

TODO. Implement and document this.
