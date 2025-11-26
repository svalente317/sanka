#include <stdio.h>
#include <stdlib.h>
#include "sanka_header.h"

const char *NULL_POINTER_ERROR = "null pointer error";
const char *DIVISION_BY_ZERO_ERROR = "division by zero error";

void PANIC(const char *text) {
    fprintf(stderr, "%s\n", text);
    exit(-1);
}

void _nop_init(void) {}

void *_malloc_and_zero(int x) {
    void *p = malloc(x);
    memset(p, 0, x);
    return p;
}
