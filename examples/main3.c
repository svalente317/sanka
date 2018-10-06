#include "sanka_header.h"
#include <sanka/examples/HeapTest.h>

int main(int argc, char **argv) {
    struct array arr;
    arr.data = argv;
    arr.length = argc;
    HeapTest__main(&arr);
    return 0;
}
