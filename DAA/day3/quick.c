#include <stdio.h>
#include <stdlib.h>

void quickSort(int *arr, int low, int high){
    if(low<high){
        int pos = partition(arr, low, high);
        quickSort(arr, low, pos - 1);
        quickSort(arr, pos + 1, high);
    }
}
int partition(int *arr, int lb, int ub){
    int pivot = arr[lb];
    int start = lb;
    int end = ub;
    while(start < end){
        while(arr[start] <= pivot && start < ub) start++;
        while(arr[end] > pivot) end--;
        if(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    arr[lb] = arr[end];
    arr[end] = pivot;
    return end;
}

int main(int argc, char *argv[]) {

    FILE *fin = fopen(argv[1], "r");
    FILE *fout = fopen(argv[2], "w");

    if (!fin || !fout) {
        printf("Error in file handling\n");
        return 1;
    }

    int n;
    scanf("%d", &n); 
    int arr[n];
    for (int i = 0; i < n; i++) {
        fscanf(fin, "%d", &arr[i]);
    }

    quickSort(arr, 0, n - 1);

    for (int i = 0; i < n; i++) {
        fprintf(fout, "%d ", arr[i]);
    }

    fclose(fin);
    fclose(fout);
}
