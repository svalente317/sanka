#ifndef FILEREADER_H_INCLUDED
#define FILEREADER_H_INCLUDED 1

struct FileReader {
};

int FileReader__open(struct FileReader *this, const char *filename);
const char *FileReader__readline(struct FileReader *this);
int FileReader__close(struct FileReader *this);

#endif
