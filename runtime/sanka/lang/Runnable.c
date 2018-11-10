#include <sanka_header.h>
#include <sanka/lang/Runnable.h>

void Runnable__Runnable(struct Runnable *this, void *object, void *run) {
    this->object = object;
    this->run = run;
}

void Runnable__run(struct Runnable *this) {
    this->run(this->object);
}

void *Runnable__threadrun(void *p) {
    struct Runnable *this = (struct Runnable *) p;
    this->run(this->object);
    return 0;
}
