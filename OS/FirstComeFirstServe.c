#include <stdio.h>
#include <stdlib.h>

struct process{
        int p_id;
        int Arrival_time;
        int Burst_time;
        float Waiting_time;
        float completionTime;
        float tat;
};

void Tat(struct process processes[],int num){
        for(int i=0;i<num;i++){
                processes[i].tat=processes[i].completionTime-processes[i].Arrival_time;
                
        }
}
void Waiting_time(struct process processes[],int num){
        for(int i=0;i<num;i++){
                processes[i].Waiting_time=processes[i].tat-processes[i].Burst_time;
        }
}
void checker(struct process processes[],int num){
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if (processes[i].Arrival_time < processes[j].Arrival_time) {
                struct process temp = processes[i];
                processes[i] = processes[j];
                processes[j] = temp;
                }
            }
                
        }
}
void ct(struct process processes[],int num){
        for(int i=0;i<num;i++){
            processes[i].completionTime=processes[i].Burst_time+processes[i].Arrival_time+(processes[i-1].completionTime==0?0:processes[i-1].completionTime);
        }
}
void main(){
        int num=0;

        printf("Enter the number of program");
        scanf("%d",&num);

        struct process processes[num];

        for(int i=0;i<num;i++){
                printf("Enter the number:");
                
                scanf("%d",&processes[i].p_id);
                printf("Enter the arrival time");
                scanf("%d",&processes[i].Arrival_time);
                printf("Enter the burst time");
                scanf("%d",&processes[i].Burst_time);
        }
        checker(processes,num);
        ct(processes,num);
        Tat(processes,num);
        Waiting_time(processes,num);
        
        for(int i=0;i<num;i++){
                printf("\n");
                
                printf("The Completion time of %d is :%.2f\t",processes[i].p_id,processes[i].completionTime);
                
                printf("The Turn around time of %d time is :%.2f\t",processes[i].p_id,processes[i].tat);
                
                printf("The Waiting time of %d is :%.2f\t",processes[i].p_id,processes[i].Waiting_time);
                printf("\n");
                
        };
        
}
