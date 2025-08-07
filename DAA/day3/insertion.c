#include <stdio.h>

void insertionSort(int arr[], int n) {
    
    for(int i = 1; i < n; i++) {
        int key = arr[i]; 
        int j = i - 1; 
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]; 
            j = j - 1; 
        }
        arr[j + 1] = key;
    }

}

int main(int argc,char *argv[]){
    FILE *fin= fopen(argv[1],"r");
    FILE *fout=fopen(argv[2],"w");

    if(fin==NULL || fout==NULL){
        printf("error occured getting the file");
        return 1;
    }

    int n;
    scanf("%d", &n);
    int arr[n];
    for(int i = 0; i < n; i++){
        fscanf(fin,"%d", &arr[i]);
    }
    insertionSort(arr,n);
    for(int i = 0; i < n; i++){
        fprintf(fout,"%d ", arr[i]);
    }
    return 0;
}
