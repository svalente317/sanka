#include <sanka_header.h>
#include <sanka/lang/String.h>
#include <string.h>

int String__length(char *this) {
    return strlen(this);
}

char String__byteAt(char *this, int n) {
    return this[n];
}

int String__indexOf(char *this, char b) {
    for (int idx = 0; this[idx] != 0; idx++) {
        if (this[idx] == b) {
            return idx;
        }
    }
    return -1;
}

int String__find(char *this, char *s) {
    char *cp = strstr(this, s);
    return cp == NULL ? -1 : (cp - this);
}

int String__startsWith(char *this, char *s) {
    return strncmp(this, s, strlen(s)) == 0;
}

int String__endsWith(char *this, char *s) {
    int n1 = strlen(this);
    int n2 = strlen(s);
    return (n1 >= n2) && strcmp(this+(n1-n2), s) == 0;
}

char *String__substring(char *this, int beginIndex, int endIndex) {
    if (beginIndex < 0 || endIndex < 0) {
        return NULL;
    }
    int n = strlen(this);
    if (endIndex == 0 || endIndex > n) {
        endIndex = n;
    }
    if (beginIndex > endIndex) {
        beginIndex = endIndex;
    }
    n = endIndex - beginIndex;
    char *that = malloc(n + 1);
    strncpy(that, this+beginIndex, n);
    that[n] = 0;
    return that;
}
