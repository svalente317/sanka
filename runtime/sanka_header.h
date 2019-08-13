#include <gc.h>
#include <rb.h>

/* Part 1: panic.c -- primitive types, pointers */

extern void PANIC(const char *);
extern const char *NULL_POINTER_ERROR;
extern const char *DIVISION_BY_ZERO_ERROR;

static inline void NULLCHECK(const void *vp) {
    if (vp == NULL) PANIC(NULL_POINTER_ERROR);
}

static inline void DIVISIONCHECK(long d) {
    if (d == 0) PANIC(DIVISION_BY_ZERO_ERROR);
}

/* Part 2: string_add.c */

extern int STRING_EQUALS(const char *, const char *);
extern char *STRING_ADD(const char **, int);
extern void INT_TO_STRING(int, char *);
extern void LONG_TO_STRING(long, char *);
extern void DOUBLE_TO_STRING(double, char *);
extern char *STRING_SUBSTRING(const char *, int, int);

/* Part 3: array.c */

struct array {
    void *data;
    int length;
    int alloced;
};

extern struct array *NEW_ARRAY(int length, int size);
extern void GROW_ARRAY(struct array *this, int size);
extern void GROW_AND_MOVE_ARRAY(struct array *this, int idx, int size);
extern void SHRINK_ARRAY(struct array *this, int idx, int count, int size);
extern void SET_ARRAY_LENGTH(struct array *this, int length, int size);
extern void ADD_ALL_ARRAY(struct array *this, struct array *that, int size);
extern char *NEW_STRING(struct array *bytes);
extern const char *ARRAY_BOUNDS_ERROR;

static inline void BOUNDSCHECK(struct array *a, int idx) {
    NULLCHECK(a);
    if (idx < 0 || idx >= a->length) PANIC(ARRAY_BOUNDS_ERROR);
}

#define ARRCAST(e, t) ((t*)e->data)
