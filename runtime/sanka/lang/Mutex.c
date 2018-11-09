#include <sanka_header.h>
#include <sanka/lang/Mutex.h>

void Mutex__Mutex(struct Mutex *this) {
    pthread_mutex_init(&this->mutex, NULL);
}

int Mutex__lock(struct Mutex *this) {
    return pthread_mutex_lock(&this->mutex);
}

int Mutex__unlock(struct Mutex *this) {
    return pthread_mutex_unlock(&this->mutex);
}
