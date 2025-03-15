#include <stdio.h>

struct Process {
    int pid;
	int AT;
	int BT;
	int CT;
	int remT;
	int Tat;
	int WT;
	};

void roundRobin(struct Process processes[],int n,int TimeQuantum){
    int time=0,completed=0;

    while(completed<n){
        int idle=1;
        for(int i=0;i<n;i++){
            
            if(processes[i].remT>0 && processes[i].AT<=time){
                idle=0;
                if(processes[i].remT>TimeQuantum){
                    time+=TimeQuantum;
                    processes[i].remT-=TimeQuantum;
                }
                else{
                    time+=processes[i].remT;
                    processes[i].CT=time;
                    processes[i].remT=0;
                    completed++;
                }
            }
            
        }if(idle)time++;
    }
    for(int i=0;i<n;i++){
        processes[i].Tat=processes[i].CT-processes[i].AT;
        processes[i].WT=processes[i].Tat-processes[i].BT;
    }
    printf("**************The Chart*****************\n");
    printf("PID\tAT\tBT\tCT\tTAT\tWT\n");
    for(int i=0;i<n;i++){
        printf("%d\t%d\t%d\t%d\t%d\t%d\n",processes[i].pid,processes[i].AT,processes[i].BT,processes[i].CT,processes[i].Tat,processes[i].WT);
    }
    
    
};
void main(){
    int n,TimeQuantum;
    printf("Enter the number of processes: ");
    scanf("%d",&n);
    printf("Enter the Time Quantum: ");
    scanf("%d",&TimeQuantum);
    
    struct Process processes[n];
    
    for(int i =0;i<n;i++){
        
        printf("Enter the Arrival Time and Burst time respectively:");
        scanf("%d %d",&processes[i].AT,&processes[i].BT);
        processes[i].pid=i;
        processes[i].remT=processes[i].BT;
    }
    roundRobin(processes,n,TimeQuantum);

}