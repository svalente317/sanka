#include <stdio.h>
#include "sanka_header.h"

const char *NULL_POINTER_ERROR = "null pointer error";
const char *DIVISION_BY_ZERO_ERROR = "division by zero error";

void PANIC(const char *text) {
    fprintf(stderr, "%s\n", text);
    exit(-1);
}
