#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    int i;
    for (i = 0; i < 3; i++) {
        pid_t t;
        t = fork();
        if (t == 0)
            break;
        printf("PID: %d, PPID: %d\n", getpid(), getppid());
    }
    return 0;
}