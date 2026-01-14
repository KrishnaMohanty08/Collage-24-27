import java.util.ArrayList;

public class mazeSolverDFS {

    static int maze[][] = {
        {1,1,0},
        {1,1,1},
        {1,0,1}
    };

    static int n = maze.length;
    static int m = maze[0].length;
    static int solution[][] = new int[n][m];
    static ArrayList<String> path = new ArrayList<>();

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) {
        System.out.println("Original Maze (1 = path, 0 = wall):");
        printMaze(maze);
        
        if (solveMazeDFS(0, 0)) {
            System.out.println("\nPath found:");
            for (String step : path) {
                System.out.print(step);
                if (path.indexOf(step) < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.println("\nNo solution exists!");
        }
    }

    static boolean solveMazeDFS(int x, int y) {
        if (x == n - 1 && y == m - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            path.add("(" + x + "," + y + ")");
            return true;
        }

        if (isSafe(x, y)) {
            solution[x][y] = 1;
            path.add("(" + x + "," + y + ")");

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (solveMazeDFS(newX, newY)) {
                    return true;
                }
            }

            solution[x][y] = 0;
            path.remove(path.size() - 1);
            return false;
        }

        return false;
    }

    static boolean isSafe(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && 
               maze[x][y] == 1 && solution[x][y] == 0;
    }

    static void printMaze(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
