#include <stdio.h>
#include <stdlib.h>

struct process {
    int p_id;             
    int Arrival_time;     
    int Burst_time;       
    int Completion_time;  
    int Turnaround_time;  
    int Waiting_time;     
};

void sortByArrivalTime(struct process processes[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (processes[j].Arrival_time > processes[j + 1].Arrival_time) {
                struct process temp = processes[j];
                processes[j] = processes[j + 1];
                processes[j + 1] = temp;
            }
        }
    }
}

void sjfScheduling(struct process processes[], int n) {
    int completed = 0, currentTime = 0, shortestIndex;
    int isVisited[n];
    
    for (int i = 0; i < n; i++) {
        isVisited[i] = 0; 
    }

    while (completed < n) {
        shortestIndex = -1;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i] && processes[i].Arrival_time <= currentTime) {
                if (shortestIndex == -1 || processes[i].Burst_time < processes[shortestIndex].Burst_time) {
                    shortestIndex = i;
                }
            }
        }

        if (shortestIndex != -1) {
            currentTime += processes[shortestIndex].Burst_time;
            processes[shortestIndex].Completion_time = currentTime;
            processes[shortestIndex].Turnaround_time = currentTime - processes[shortestIndex].Arrival_time;
            processes[shortestIndex].Waiting_time = processes[shortestIndex].Turnaround_time - processes[shortestIndex].Burst_time;
            isVisited[shortestIndex] = 1;
            completed++;
        } else {
            currentTime++;
        }
    }
}

void displayProcesses(struct process processes[], int n) {
    printf("\nPID\tArrival\tBurst\tCompletion\tTAT\tWT\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t%d\t%d\t%d\t\t%d\t%d\n",
               processes[i].p_id,
               processes[i].Arrival_time,
               processes[i].Burst_time,
               processes[i].Completion_time,
               processes[i].Turnaround_time,
               processes[i].Waiting_time);
    }
}

int main() {
    int n;

    printf("Enter the number of processes: ");
    scanf("%d", &n);

    struct process processes[n];

    for (int i = 0; i < n; i++) {
        printf("\nProcess %d:\n", i + 1);
        printf("Enter Arrival Time: ");
        scanf("%d", &processes[i].Arrival_time);
        printf("Enter Burst Time: ");
        scanf("%d", &processes[i].Burst_time);
        processes[i].p_id = i + 1;
    }

    sortByArrivalTime(processes, n);
    sjfScheduling(processes, n);
    displayProcesses(processes, n);

    return 0;
}
