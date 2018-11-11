#include <sanka_header.h>
#include <sanka/lang/Condition.h>
#include <sanka/lang/Mutex.h>

void Condition__Condition(struct Condition *this) {
    pthread_cond_init(&this->condition, NULL);
}

int Condition__wait(struct Condition *this, struct Mutex *mutex) {
    return pthread_cond_wait(&this->condition, &mutex->mutex);
}

int Condition__signal(struct Condition *this) {
    return pthread_cond_signal(&this->condition);
}

int Condition__broadcast(struct Condition *this) {
    return pthread_cond_broadcast(&this->condition);
}
