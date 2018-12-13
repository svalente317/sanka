## Sanka Garbage Collection

Sanka uses the Boehm-Demers-Weiser Garbage Collector (libgc, bdwgc, boehm-gc).

https://www.hboehm.info/gc/
https://github.com/ivmai/bdwgc

As far as I know, libgc supports everything that Sanka requires:

* It's fast and mature.

* It's extremely easy to use.

* It supports a multi-threaded environment.

* It supports everything you expect. You can create small and large
  objects; you can reallocate blocks; you can keep pointers to live
  objecs on the stack as well as in libgc allocated blocks; you can
  keep a block alive with a pointer into the middle of that block;
  you can mark strings as not containing pointers to other blocks,
  etc.
