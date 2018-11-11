#ifndef STRING_H_INCLUDED
#define STRING_H_INCLUDED 1

#include <sanka/lang/String.h>

int String__length(char *this);
char String__byteAt(char *this, int n);
int String__indexOf(char *this, char b);
int String__find(char *this, char *s);
int String__startsWith(char *this, char *s);
int String__endsWith(char *this, char *s);
char *String__substring(char *this, int beginIndex, int endIndex);

#endif
