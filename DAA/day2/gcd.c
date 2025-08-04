// Aim of the program: Write a program in C to find GCD of two numbers using recursion. Read all pair of numbers from a file and store the result in a separate file. 
#include <stdio.h>
#include <stdlib.h>

// Recursive function to calculate GCD
int gcd(int a, int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

int main(int argc, char *argv[]) {
    FILE *fin, *fout;
    int num1, num2, res;

    // Check for correct number of command-line arguments
    if (argc != 3) {
        printf("Usage: %s <source_file> <destination_file>\n", argv[0]);
        return 1;
    }

    // Open input file
    fin = fopen(argv[1], "r");
    if (fin == NULL) {
        printf("Error opening input file.\n");
        return 1;
    }

    // Open output file
    fout = fopen(argv[2], "w");
    if (fout == NULL) {
        printf("Error opening output file.\n");
        fclose(fin);
        return 1;
    }

    // Read pairs and compute GCD
    while (fscanf(fin, "%d %d", &num1, &num2) == 2) {
        res = gcd(num1, num2);
        fprintf(fout, "The GCD of %d and %d is %d\n", num1, num2, res);
    }

    fclose(fin);
    fclose(fout);

    // Display output file content
    fout = fopen(argv[2], "r");
    if (fout == NULL) {
        printf("Error opening output file.\n");
        return 1;
    }
    char line[100];
    while (fgets(line, sizeof(line), fout)) {
        printf("%s", line);
    }
    fclose(fout);

    return 0;
}
