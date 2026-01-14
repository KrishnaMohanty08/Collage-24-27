import java.util.*;

public class mazeSolverBFS {

    static int maze[][] = {
        {1,1,0},
        {1,1,1},
        {1,0,1}
    };

    static int n = maze.length;
    static int m = maze[0].length;

    public static void main(String[] args) {

        int start = 0;          
        int end = n*m - 1;       

        List<Integer> path = bfsShortestPath(start, end);

        if (path.isEmpty()) {
            System.out.println("No path found");
        } else {
            System.out.print("Shortest Path: ");
            for (int p : path) {
                System.out.print(toChar(p) + " ");
            }
        }
    }

    static List<Integer> bfsShortestPath(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n*m];
        int parent[] = new int[n*m];

        Arrays.fill(parent, -1);

        q.add(start);
        visited[start] = true;

        int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // D U R L

        while (!q.isEmpty()) {
            int curr = q.poll();
            int i = curr / m;
            int j = curr % m;

            if (curr == end) break;

            for (int[] d : directions) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (isValid(ni, nj) && !visited[ni*m + nj]) {
                    int next = ni * m + nj;
                    visited[next] = true;
                    parent[next] = curr;
                    q.add(next);
                }
            }
        }

        return buildPath(parent, start, end);
    }

    static boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m && maze[i][j] == 1;
    }

    static List<Integer> buildPath(int parent[], int start, int end) {
        LinkedList<Integer> path = new LinkedList<>();
        int curr = end;

        while (curr != -1) {
            path.addFirst(curr);
            curr = parent[curr];
        }

        if (path.getFirst() != start) return new ArrayList<>();

        return path;
    }

    static char toChar(int index) {
        return (char) ('a' + index);
    }
}
