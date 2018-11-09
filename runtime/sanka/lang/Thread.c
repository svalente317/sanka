#include <sanka_header.h>
#include <sanka/lang/Runnable.h>
#include <sanka/lang/Thread.h>

void Thread__Thread(struct Thread *this, struct Runnable *runnable) {
    this->runnable = runnable;
}

int Thread__run(struct Thread *this) {
  return pthread_create(&this->thread, NULL, (void *) this->runnable->run, this->runnable);
}

int Thread__join(struct Thread *this) {
    return pthread_join(this->thread, NULL);
}

struct Thread *Thread__currentThread() {
    return NULL; // TODO
}
