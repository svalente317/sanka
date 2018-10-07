#include "sanka_header.h"
#include <sanka/examples/User.h>

int main(int argc, char **argv) {
    struct array arr;
    arr.data = argv;
    arr.length = argc;
    User__main(&arr);
    return 0;
}
