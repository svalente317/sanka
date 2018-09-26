#include "sanka_header.h"
#include <sanka/examples/WordMap.h>

int main(int argc, char **argv) {
    struct array arr;
    arr.data = calloc(argc-1, sizeof(char *));
    for (int i = 1; i < argc; i++) {
      ((char **)arr.data)[i-1] = argv[i];
    }
    arr.length = argc-1;
    WordMap__main(&arr);
    return 0;
}
