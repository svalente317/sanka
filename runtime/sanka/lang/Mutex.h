#ifndef sanka_lang_Mutex_h_INCLUDED
#define sanka_lang_Mutex_h_INCLUDED 1

#include <pthread.h>

struct Mutex {
    pthread_mutex_t mutex;
};
void Mutex__Mutex(struct Mutex *this);
int Mutex__lock(struct Mutex *this);
int Mutex__unlock(struct Mutex *this);

#endif
