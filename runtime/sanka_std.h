#ifdef WIN32
#include <io.h>
#define srandom(x) srand(x)
#define random31() random31_from_15()
#define random15() rand()
#define getuid() 0
#define lstat(x, y) stat(x, y)
#define S_ISLNK(m) 0
#define makedirectory(p, m) mkdir(p)
#define fsync(x) _commit(x)
#else
#define random31() random()
#define random15() (random() & 0x7FFF)
#define makedirectory(p, m) mkdir(p, m)
#endif
