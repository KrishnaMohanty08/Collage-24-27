import java.util.*;
public class dfs {
    public static void main(String[] args) {
        // adjacency matrix for example graph
        int a[][] = {
            {0,1,1,0,0,0},
            {1,0,0,1,0,0},
            {1,0,0,1,0,0},
            {0,1,1,0,1,1},
            {0,0,0,1,0,0},
            {0,0,0,1,0,0}
        };

        int n = a.length;
        boolean visited[] = new boolean[n];
        Stack<Integer> stack = new Stack<Integer>();

        // Run DFS for each component (handles disconnected graphs)
        for (int s = 0; s < n; s++) {
            if (!visited[s]) {
                stack.push(s);
                while (!stack.isEmpty()) {
                    int v = stack.pop();
                    if (!visited[v]) {
                        visited[v] = true;
                        System.out.print(v + " ");
                        // explore neighbors of v
                        for (int j = n - 1; j >= 0; j--) {
                            if (a[v][j] != 0 && !visited[j]) {
                                stack.push(j);
                            }
                        }
                    }
                }
                System.out.println(); 
            }
        }
    }
}