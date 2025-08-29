#include <stdio.h>
#include <stdlib.h>

// Heapify is an algorithmic process used to rearrange a binary tree (usually represented as an array) to ensure it satisfies the heap property. This means, for a max-heap, every parent node is greater than or equal to its child nodes; for a min-heap, every parent node is less than or equal to its child nodes.

void heapify(int *arr, int n, int i) {
    int largest = i; //make it root node 
    int left = 2 * i + 1; //add up left node 
    int right = 2 * i + 2; //add up right node

    if (left < n && arr[left] > arr[largest]) //if root is not largest then mark left as largest
        largest = left;
    if (right < n && arr[right] > arr[largest]) //if root is not largest then mark right as largest
        largest = right;
    if (largest != i) { //if root is not largest the swap with largest 
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, n, largest); //
    }
}

void heapSort(int *arr, int n) {
    for (int i = n/2-1; i>=0; i--) //mid to start iterate and assume the element to be largest
        heapify(arr, n, i);
    for (int i = n-1; i>0; i--) { //end to start iterate and swap then heapify
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }
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

    heapSort(arr, n);

    for (int i = 0; i < n; i++) {
        fprintf(fout, "%d ", arr[i]);
    }

    fclose(fin);
    fclose(fout);
}
