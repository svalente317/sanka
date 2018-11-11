#ifndef sanka_lang_Condition_h_INCLUDED
#define sanka_lang_Condition_h_INCLUDED 1

#include <sanka/lang/Mutex.h>
#include <pthread.h>

struct Condition {
    pthread_cond_t condition;
};
void Condition__Condition(struct Condition *this);
int Condition__wait(struct Condition *this, struct Mutex *mutex);
int Condition__signal(struct Condition *this);
int Condition__broadcast(struct Condition *this);

#endif
