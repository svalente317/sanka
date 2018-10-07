#include <sanka/lang/System.h>
#include <stdio.h>
#include <string.h>

void System__print(char *text) {
  fputs(text, stdout);
}

void System__println(char *text) {
    puts(text);
}

char *System__strerror(int errno) {
    return strerror(errno);
}

