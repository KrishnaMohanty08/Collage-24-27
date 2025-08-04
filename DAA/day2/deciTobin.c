#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100

void tobinary(int num) {
    if (num == 0) {
        printf("0");
        return;
    }
    if (num > 1)
        tobinary(num / 2);
    printf("%d", num % 2);
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s <filename>\n", argv[0]);
        return 1;
    }

    FILE *file = fopen(argv[1], "r");
    if (!file) {
        perror("Error opening file");
        return 1;
    }

    int arr[MAX_SIZE], n = 0, temp;
    while (fscanf(file, "%d", &temp) == 1 && n < MAX_SIZE) {
        arr[n++] = temp;
        printf("Decimal: %d, Binary: ", temp);
        tobinary(temp);
    }
    
    printf("\n");
    fclose(file);
    return 0;
}
