import java.util.*;

public class midSem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of node :");
        int n = sc.nextInt();
        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <=n; i++)
            adj.add(new ArrayList<>());

        // graph edges
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(5);
        adj.get(2).add(6);
        adj.get(4).add(7);
        adj.get(4).add(8);
        adj.get(5).add(9);
        adj.get(5).add(10);
        adj.get(7).add(11);
        adj.get(7).add(12);

        //BFS
        System.out.println("BFS Traversal:");
        bfs(0, adj);
        System.out.println("DFS Traversal:");
        dfs(0, adj);
        System.out.println("IDDFS Traversal:");
        IDDFS(0, adj, new boolean[n]);

        System.out.println("Greedy Best First Search 8 Puzzle Problem");
        int[][] board = {
            {1, 2, 3},
            {5, 6, 0},
            {7, 8, 4}
        };
        int[][] goal = {
            {1, 2, 3},
            {5, 6, 4},
            {7, 8, 0}
        };
        greedyBestFirstSearch(board, goal);

    }
    static void bfs(int start, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adj.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    static void dfs(int start, List<List<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, adj, visited);
        System.out.println();
        
    }
    static void dfsHelper(int current, List<List<Integer>> adj, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adj.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, adj, visited);
            }
        }
    }
    static void IDDFS(int start, List<List<Integer>> adj, boolean[] visited) {
        Set<Integer> allVisited = new HashSet<>();
        for (int depth = 0; depth < visited.length; depth++) {
            Set<Integer> currentVisited = new HashSet<>();
            DLS(start, adj, currentVisited, depth, allVisited);
        }
        System.out.println();
    }
    static void DLS(int current, List<List<Integer>> adj, Set<Integer> visited, int depth, Set<Integer> allVisited) {
        if (visited.contains(current) || allVisited.contains(current)) {
            return;
        }
        
        visited.add(current);
        System.out.print(current + " ");
        allVisited.add(current);

        if (depth > 0) {
            for (int neighbor : adj.get(current)) {
                if (!allVisited.contains(neighbor)) {
                    DLS(neighbor, adj, visited, depth - 1, allVisited);
                }
            }
        }
    }
    static void greedyBestFirstSearch(int[][] board, int[][] goal) {
        PriorityQueue<State8Puzzle> openSet = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();
        
        State8Puzzle initial = new State8Puzzle(board, goal, null, 0);
        openSet.add(initial);
        
        int statesExplored = 0;
        
        while (!openSet.isEmpty()) {
            State8Puzzle current = openSet.poll();
            statesExplored++;
            
            String boardStr = boardToString(current.board);
            if (visited.contains(boardStr)) {
                continue;
            }
            visited.add(boardStr);
            
            // Check if goal state is reached
            if (isGoalState(current.board, goal)) {
                System.out.println("Goal state reached!");
                System.out.println("States explored: " + statesExplored);
                System.out.println("Path length: " + current.depth);
                printPath(current);
                return;
            }
            
            // Generate next states
            List<int[][]> nextStates = generateNextStates(current.board);
            for (int[][] nextBoard : nextStates) {
                String nextBoardStr = boardToString(nextBoard);
                if (!visited.contains(nextBoardStr)) {
                    State8Puzzle nextState = new State8Puzzle(nextBoard, goal, current, current.depth + 1);
                    openSet.add(nextState);
                }
            }
        }
        
        System.out.println("Goal state not found!");
    }
    
    static class State8Puzzle implements Comparable<State8Puzzle> {
        int[][] board;
        int[][] goal;
        State8Puzzle parent;
        int depth;
        int heuristic;
        
        State8Puzzle(int[][] board, int[][] goal, State8Puzzle parent, int depth) {
            this.board = board;
            this.goal = goal;
            this.parent = parent;
            this.depth = depth;
            this.heuristic = calculateManhattanDistance(board, goal);
        }
        
        @Override
        public int compareTo(State8Puzzle other) {
            return Integer.compare(this.heuristic, other.heuristic);
        }
    }
    
    static int calculateManhattanDistance(int[][] board, int[][] goal) {
        int distance = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = board[i][j];
                if (value != 0) {
                    int[] goalPos = findPosition(goal, value);
                    distance += Math.abs(i - goalPos[0]) + Math.abs(j - goalPos[1]);
                }
            }
        }
        return distance;
    }
    
    static int[] findPosition(int[][] board, int value) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == value) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    static int[] findBlank(int[][] board) {
        return findPosition(board, 0);
    }
    
    static List<int[][]> generateNextStates(int[][] board) {
        List<int[][]> nextStates = new ArrayList<>();
        int[] blankPos = findBlank(board);
        int blankRow = blankPos[0];
        int blankCol = blankPos[1];
        
        // Move up
        if (blankRow > 0) {
            nextStates.add(swapAndCopy(board, blankRow, blankCol, blankRow - 1, blankCol));
        }
        // Move down
        if (blankRow < 2) {
            nextStates.add(swapAndCopy(board, blankRow, blankCol, blankRow + 1, blankCol));
        }
        // Move left
        if (blankCol > 0) {
            nextStates.add(swapAndCopy(board, blankRow, blankCol, blankRow, blankCol - 1));
        }
        // Move right
        if (blankCol < 2) {
            nextStates.add(swapAndCopy(board, blankRow, blankCol, blankRow, blankCol + 1));
        }
        
        return nextStates;
    }
    
    static int[][] swapAndCopy(int[][] board, int row1, int col1, int row2, int col2) {
        int[][] newBoard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        
        int temp = newBoard[row1][col1];
        newBoard[row1][col1] = newBoard[row2][col2];
        newBoard[row2][col2] = temp;
        
        return newBoard;
    }
    
    static boolean isGoalState(int[][] board, int[][] goal) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != goal[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
    
    static void printPath(State8Puzzle state) {
        List<int[][]> path = new ArrayList<>();
        State8Puzzle current = state;
        while (current != null) {
            path.add(0, current.board);
            current = current.parent;
        }
        
        System.out.println("\nSolution Path:");
        for (int i = 0; i < path.size(); i++) {
            System.out.println("Step " + i + ":");
            printBoard(path.get(i));
            System.out.println();
        }
    }
    
    static void printBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
