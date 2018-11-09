#include <sanka_header.h>
#include <sanka/lang/Runnable.h>

void Runnable__Runnable(struct Runnable *this, void *object, void *run) {
    this->object = object;
    this->run = run;
}

void Runnable__run(struct Runnable *this) {
    this->run(this->object);
}
