#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();
   
    if (pid == 0)
     {  
        printf("I am a child\n");
        sleep(5);
        printf("Execution of child is over\n");
    } 
    else if (pid > 0) 
    {  
        printf("I am parent, waiting for child\n");
        wait(NULL);  
        printf("Child terminated\n");
    } 
    else 
    {  
        perror("fork failed");
        return 1;
    }

    return 0;
}