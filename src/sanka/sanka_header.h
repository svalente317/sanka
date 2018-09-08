#include <stdlib.h>
#include <string.h>

struct String {
    char *data;
    int length;
};

struct array {
    void *data;
    int length;
};

static inline struct String *STRINGLITERAL(char *cp) {
    struct String *s = malloc(sizeof(struct String));
    s->data = cp;
    s->length = strlen(cp);
    return s;
}

static inline struct array *NEWARRAY(int length, int size) {
    struct array *a = malloc(sizeof(struct array));
    a->data = calloc(length, size);
    a->length = length;
    return a;
}

extern void PANIC(const char *);

static inline void NULLCHECK(void *vp) {
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

