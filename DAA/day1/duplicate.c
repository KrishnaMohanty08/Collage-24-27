#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_SIZE 100


void duplicate_num(int arr[], int n) {
    bool printed[MAX_SIZE] = {false}; 

    printf("Duplicates: ");
    for (int i = 0; i < n; i++) {
        if (printed[i]) {
            continue; 
        }
        bool is_duplicate = false;
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                is_duplicate = true;
                break;
            }
        }
        if (is_duplicate) {
            printf("%d ", arr[i]);
            for (int k = i; k < n; k++) {
                if (arr[k] == arr[i]) {
                    printed[k] = true;
                }
            }
        }
    }
    printf("\n");
}

void duplicates(int arr[],int n){
	int dupliCount=1;
	for(int i=0;i<n;i++){
		int isDuplicate = 0;
		for(int j=i+1;j<n;j++){
			if(arr[i]==arr[j]){
				dupliCount=1;
				break;
			}
		}
		if (isDuplicate) continue;
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                dupliCount++;
                break;
            }
        }
	}
	printf("%d",dupliCount);
}

int main(int argc, char* argv[]) {
    FILE *file = fopen(argv[1], "r");
    if (!file) {
        perror("Error opening file");
        return 1;
    }
    int arr[MAX_SIZE], n = 0, temp;
    while (fscanf(file, "%d", &temp) == 1 && n < MAX_SIZE) {
        arr[n++] = temp;
        printf("%d ", arr[n-1]);
    }
    fclose(file);
	printf("\n");
	duplicate_num(arr,n);
	duplicates(arr,n);
    return 0;
}
