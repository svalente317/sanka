#include <sanka/io/FileReader.h>
#include <string.h>
#include <errno.h>

int FileReader__open(struct FileReader *this, const char *filename) {
    this->fp = fopen(filename, "r");
    return this->fp != NULL ? 0 : errno;
}

char *FileReader__readline(struct FileReader *this) {
    char buf[256];
    if (fgets(buf, sizeof(buf), this->fp) == NULL) {
        return NULL;
    }
    buf[sizeof(buf)-1] = 0;
    int len = strlen(buf);
    while (len > 0 && (buf[len-1] == '\n' || buf[len-1] == '\r')) {
        len--;
    }
    buf[len] = 0;
    return strdup(buf);
}

int FileReader__close(struct FileReader *this) {
    int status = fclose(this->fp);
    this->fp = NULL;
    return status == 0 ? 0 : errno;
}
