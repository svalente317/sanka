#include <stdlib.h>
#include <string.h>
#include "sanka_header.h"

const char *ARRAY_BOUNDS_ERROR = "array bounds error";

struct array *NEW_ARRAY(int length, int size) {
    struct array *this = GC_MALLOC(sizeof(struct array));
    this->data = size < sizeof(void*) ? GC_MALLOC_ATOMIC(length * size) :
        GC_MALLOC(length * size);
    this->length = length;
    this->alloced = length;
    return this;
}

void GROW_ARRAY(struct array *this, int size) {
    NULLCHECK(this);
    if (this->length == this->alloced) {
        this->alloced = this->alloced == 0 ? 4 :
            this->alloced + this->alloced;
        this->data = GC_REALLOC(this->data, this->alloced * size);
    }
    this->length++;
}

void GROW_AND_MOVE_ARRAY(struct array *this, int idx, int size) {
    if (idx != 0) {
        BOUNDSCHECK(this, idx-1);
    }
    GROW_ARRAY(this, size);
    memmove(((char *) this->data) + ((idx+1) * size),
            ((char *) this->data) + (idx * size),
            (this->length-idx-1) * size);
}

void SHRINK_ARRAY(struct array *this, int idx, int count, int size) {
    BOUNDSCHECK(this, idx);
    if (count < 0 || count > (this->length - idx)) {
        PANIC(ARRAY_BOUNDS_ERROR);
    }
    memmove(((char *) this->data) + (idx * size),
            ((char *) this->data) + ((idx+count) * size),
            (this->length - (idx+count)) * size);
    this->length -= count;
}

void SET_ARRAY_LENGTH(struct array *this, int length, int size) {
    NULLCHECK(this);
    if (this->length >= length) {
        this->length = length;
        return;
    }
    this->data = GC_REALLOC(this->data, length * size);
    memset(((char *) this->data) + (this->length * size), 0,
           (length - this->length) * size);
    this->length = length;
    this->alloced = length;
}

void ADD_ALL_ARRAY(struct array *this, struct array *that, int size) {
    NULLCHECK(this);
    NULLCHECK(that);
    int newlen = this->length + that->length;
    if (newlen >= this->alloced) {
        this->alloced = newlen;
        this->data = GC_REALLOC(this->data, this->alloced * size);
    }
    memmove(((char *) this->data) + (this->length * size),
            (char *) that->data, that->length * size);
    this->length = newlen;
}

char *NEW_STRING(struct array *bytes) {
    NULLCHECK(bytes);
    char *str = GC_MALLOC_ATOMIC(bytes->length+1);
    memcpy(str, bytes->data, bytes->length);
    str[bytes->length] = 0;
    return str;
}
