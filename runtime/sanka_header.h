#include <stdlib.h>
#include "rb.h"

struct array {
    void *data;
    int length;
};

static inline struct array *NEWARRAY(int length, int size) {
    struct array *a = malloc(sizeof(struct array));
    a->data = calloc(length, size);
    a->length = length;
    return a;
}

extern void PANIC(const char *);
extern char *STRING_ADD(char **, int);
extern void INT_TO_STRING(int, char *);
extern void LONG_TO_STRING(long, char *);
extern struct array *SANKA_ARRAY(int, char **);

static inline void NULLCHECK(const void *vp) {
    if (vp == NULL) PANIC("null pointer error");
}

static inline void DIVISIONCHECK(long d) {
    if (d == 0) PANIC("division by zero error");
}

static inline void BOUNDSCHECK(struct array *a, int idx) {
    NULLCHECK(a);
    if (idx < 0 || idx >= a->length) PANIC("array bounds error");
}

#define ARRCAST(e, t) ((t*)e->data)
