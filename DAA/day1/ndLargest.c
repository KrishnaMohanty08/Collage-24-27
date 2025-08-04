#include <stdio.h>
// int main(){
//     int arr[5]={2,3,5,1,9};
//     int max=arr[0],min=arr[0];
//     int ndMax=arr[0],ndMin=arr[0];

//     for(int i=0;i<5;i++){
//         if(max<arr[i]){
//             max=arr[i];          
//         }
//         if(min>arr[i]){
//             min=arr[i];
//         }
//     }
//     printf("max:%d \n min:%d",max,min);
//     return 0;

// }

int main(){
	int n;
	scanf("%d",&n);
    int arr[n];
    printf("Enter the elements\n");
    for(int i=0;i<n;i++){
    scanf("%d",&arr[i]);
    }
    int max=arr[0],min=arr[0];
    int ndMax=arr[0],ndMin=arr[0];

    for(int i=0;i<n;i++){
        if(max<arr[i]){
            ndMax=max; 
            max=arr[i];        
        }
        else if(arr[i]>ndMax && arr[i]!=max){
                ndMax=arr[i];
         }
        if(min>arr[i]){
            ndMin=min;
            min=arr[i];
        
        }else if(arr[i]<ndMin && arr[i]!=min){
                ndMax=arr[i];
           }
    }
    printf("2nd max:%d \n2nd min:%d",ndMax,ndMin);
    return 0;
}
