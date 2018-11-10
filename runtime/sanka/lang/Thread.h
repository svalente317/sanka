#ifndef sanka_lang_Thread_h_INCLUDED
#define sanka_lang_Thread_h_INCLUDED 1

#include <sanka/lang/Runnable.h>
#include <pthread.h>

struct Thread {
    pthread_t thread;
};
void Thread__Thread(struct Thread *this, struct Runnable *runnable);
int Thread__join(struct Thread *this);

#endif
