#include <stdio.h>
#include "sanka_header.h"

void PANIC(const char *text) {
    fprintf(stderr, "%s\n", text);
    exit(-1);
}
