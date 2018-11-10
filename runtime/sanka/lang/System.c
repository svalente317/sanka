#include <sanka/lang/System.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>

void System__print(char *text) {
  fputs(text, stdout);
}

void System__println(char *text) {
    puts(text);
}

char *System__strerror(int errno) {
    return strerror(errno);
}

long long System__currentTimeMillis(void) {
    struct timeval now;
    gettimeofday(&now, NULL);
    return ((long long) now.tv_sec) * 1000 + (now.tv_usec / 1000);
}

void System__sleep(int millis) {
    usleep(millis * 1000);
}

int System__random(int max) {
    return random() % max;
}
