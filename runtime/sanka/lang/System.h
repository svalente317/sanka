#ifndef SYSTEM_H_INCLUDED
#define SYSTEM_H_INCLUDED 1

void System__print(char *);
void System__println(char *);
char *System__strerror(int);
long long System__currentTimeMillis(void);
void System__sleep(int);
int System__random(int);

#endif
