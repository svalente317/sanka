#include <string.h>
#include "sanka_header.h"

char *STRING_ADD(char **arr, int size) {
    int length, idx;
    char *cp;
    int lens[size];

    length = 0;
    for (idx = 0; idx < size; idx++) {
        lens[idx] = strlen(arr[idx]);
        length += lens[idx];
    }
    cp = malloc(length + 1);
    length = 0;
    for (idx = 0; idx < size; idx++) {
        strcpy(cp + length, arr[idx]);
        length += lens[idx];
    }
    return cp;
}

static inline void reverse_string(char *str, int len) {
    str[len] = 0;
    int half = len >> 1;
    len--;
    for (int x = 0; x < half; x++) {
        char t = str[x];
        str[x] = str[len-x];
        str[len-x] = t;
    }
}

void INT_TO_STRING(int i, char *str) {
    int negative = 0;
    int len = 0;
    if (i < 0) {
        negative = 1;
        i = -i;
    }
    if (i == 0) {
        str[0] = '0';
        str[1] = 0;
        return;
    }
    while (i > 0) {
        str[len] = '0' + (i % 10);
        len++;
        i = (int)(i / 10);
    }
    if (negative) {
        str[len] = '-';
        len++;
    }
    reverse_string(str, len);
}

void LONG_TO_STRING(long i, char *str) {
    int negative = 0;
    int len = 0;
    if (i < 0) {
        negative = 1;
        i = -i;
    }
    if (i == 0) {
        str[0] = '0';
        str[1] = 0;
        return;
    }
    while (i > 0) {
        str[len] = '0' + (i % 10);
        len++;
        i = (long)(i / 10);
    }
    if (negative) {
        str[len] = '-';
        len++;
    }
    reverse_string(str, len);
}

struct array *SANKA_ARRAY(int argc, char **argv) {
    struct array *arr = malloc(sizeof(struct array));
    arr->data = calloc(argc-1, sizeof(char *));
    for (int i = 1; i < argc; i++) {
      ((char **)arr->data)[i-1] = argv[i];
    }
    arr->length = argc-1;
    return arr;
}
