#include <stdlib.h>
#include <stdio.h>

struct Adder {
};

int Adder__operate(struct Adder *this, int x, int y) {
    return x + y;
}

struct Multiplier {
};

int Multiplier__operate(struct Multiplier *this, int x, int y) {
    return x * y;
}

struct Calculator {
    void *object;
    int (*operate)(void *object, int x, int y);
};

void Calculator__init(struct Calculator *this, void *object, int (*operate)(void *object, int x, int y)) {
    this->object = object;
    this->operate = operate;
}

int Calculator__operate(struct Calculator *this, int x, int y) {
    return this->operate(this->object, x, y);
}

void User__operateAndPrint(struct Calculator *calc, int x, int y) {
    printf("value=%d\n", Calculator__operate(calc, x, y));
}

void User__addAndMultiply(void) {
    struct Adder *adder = calloc(1, sizeof(struct Adder));
    struct Calculator c1;
    Calculator__init(&c1, adder, (int (*)(void *, int, int)) Adder__operate);
    User__operateAndPrint(&c1, 4, 5);
    
    struct Multiplier *multiplier = calloc(1, sizeof(struct Multiplier));
    struct Calculator c2;
    Calculator__init(&c2, multiplier, (int (*)(void *, int, int)) Multiplier__operate);
    User__operateAndPrint(&c2, 4, 5);
}
