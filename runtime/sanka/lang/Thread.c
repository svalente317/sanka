#include <sanka_header.h>
#include <sanka/lang/Runnable.h>
#include <sanka/lang/Thread.h>

void Thread__Thread(struct Thread *this, struct Runnable *runnable) {
    pthread_create(&this->thread, NULL, Runnable__threadrun, runnable);
}

int Thread__join(struct Thread *this) {
    return pthread_join(this->thread, NULL);
}
