#include <stdio.h>
#include <limits.h>

void printOptimalParenthesis(int i, int j, int n, int s[10][10]) {
    if (i == j)
        printf("A%d", i);
    else {
        printf("(");
        printOptimalParenthesis(i, s[i][j], n, s);
        printOptimalParenthesis(s[i][j] + 1, j, n, s);
        printf(")");
    }
}

int main() {
    int n, i, j, k, l, q;
    int p[10], m[10][10], s[10][10];
    
    printf("Enter number of matrices: ");
    scanf("%d", &n);
    
    int row, col;
    printf("Enter row and col size of A1: ");
    scanf("%d %d", &row, &col);
    p[0] = row;
    p[1] = col;
    
    for (i = 2; i <= n; i++) {
        printf("Enter row and col size of A%d: ", i);
        scanf("%d %d", &row, &col);
        if (p[i - 1] != row) {
            printf("Matrix dimension mismatch! Exiting.\n");
            return 1;
        }
        p[i] = col;
    }

    for (i = 1; i <= n; i++)
        m[i][i] = 0;

    for (l = 2; l <= n; l++) {
        for (i = 1; i <= n - l + 1; i++) {
            j = i + l - 1;
            m[i][j] = INT_MAX;
            for (k = i; k <= j - 1; k++) {
                q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                if (q < m[i][j]) {
                    m[i][j] = q;
                    s[i][j] = k;
                }
            }
        }
    }

    printf("\nM Table:\n");
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            if (i > j)
                printf("0\t");
            else
                printf("%d\t", m[i][j]);
        }
        printf("\n");
    }

    printf("\nS Table:\n");
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            if (i > j)
                printf("0\t");
            else
                printf("%d\t", s[i][j]);
        }
        printf("\n");
    }

    printf("\nOptimal parenthesization: ");
    printOptimalParenthesis(1, n, n, s);
    printf("\nThe optimal ordering of the given matrices requires %d scalar multiplications.\n", m[1][n]);

    return 0;
}