#ifndef sanka_lang_Runnable_h_INCLUDED
#define sanka_lang_Runnable_h_INCLUDED 1


struct Runnable {
    void *object;
    void (*run)(void *object);
};

void Runnable__Runnable(struct Runnable *this, void *object, void *run);
void Runnable__run(struct Runnable *this);
void *Runnable__threadrun(void *p);

#endif
