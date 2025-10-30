#include <stdio.h>
#define INF 9999
#define MAX 10

int n;
int dist[MAX][MAX], next[MAX][MAX];

// Function to print path between two vertices
void printPath(int u, int v) {
    if (next[u][v] == -1) {
        printf("No path");
        return;
    }
    printf("%d", u + 1);
    while (u != v) {
        u = next[u][v];
        printf("-->%d", u + 1);
    }
    printf("\n");
}

// Function implementing Floyd-Warshall Algorithm
void floydWarshall() {
    int i, j, k;

    for (k = 0; k < n; k++) {
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    next[i][j] = next[i][k];
                }
            }
        }
    }
}

int main() {
    FILE *fp;
    int i, j;
    int src, dest;

    fp = fopen("input.txt", "r");
    if (fp == NULL) {
        printf("Error opening file.\n");
        return 1;
    }

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            fscanf(fp, "%d", &dist[i][j]);
            if (i != j && dist[i][j] == 0)
                dist[i][j] = INF;
            if (dist[i][j] != INF)
                next[i][j] = j;
            else
                next[i][j] = -1;
        }
    }
    fclose(fp);
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            
                printf("%d ", dist[i][j]);
        }    
        printf("\n");
    }

    floydWarshall();

    printf("\nAll Pairs Shortest Path Weight Matrix:\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            if (dist[i][j] == INF)
                printf("%4s", "INF");
            else
                printf("%4d", dist[i][j]);
        }
        printf("\n");
    }

    printf("\nEnter source and destination vertex: ");
    scanf("%d %d", &src, &dest);
    src--; dest--;

    if (dist[src][dest] == INF)
        printf("\nNo path exists from %d to %d\n", src + 1, dest + 1);
    else {
        printf("\nShortest Path from vertex %d to vertex %d: ", src + 1, dest + 1);
        printPath(src, dest);
        printf("Path weight: %d\n", dist[src][dest]);
    }

    return 0;
}