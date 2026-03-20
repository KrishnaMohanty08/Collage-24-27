import java.util.*;
public class testBIDFS {

    static boolean bidirectionalDFS(int start, int goal, List<List<Integer>> adj) {

        Set<Integer> visitedStart = new HashSet<>();
        Set<Integer> visitedGoal = new HashSet<>();

        boolean found = dfsStart(start, goal, adj, visitedStart, visitedGoal) ||
                        dfsGoal(goal, start, adj, visitedGoal, visitedStart);
        
        if (found) {
            // Find the intersecting point
            for (int node : visitedStart) {
                if (visitedGoal.contains(node)) {
                    System.out.println("Intersecting point: " + node);
                    break;
                }
            }
        }
        
        return found;
    }
               static boolean dfsStart(int node, int goal,
                            List<List<Integer>> adj,
                            Set<Integer> visitedStart,
                            Set<Integer> visitedGoal) {

        visitedStart.add(node);

        // Check meeting point
        if (visitedGoal.contains(node))
            return true;

        for (int neighbor : adj.get(node)) {
            if (!visitedStart.contains(neighbor)) {
                if (dfsStart(neighbor, goal, adj, visitedStart, visitedGoal))
                    return true;
            }
        }
        return false;
    }

    static boolean dfsGoal(int node, int start,
                           List<List<Integer>> adj,
                           Set<Integer> visitedGoal,
                           Set<Integer> visitedStart) {

        visitedGoal.add(node);

        // Check meeting point
        if (visitedStart.contains(node))
            return true;

        for (int neighbor : adj.get(node)) {
            if (!visitedGoal.contains(neighbor)) {
                if (dfsGoal(neighbor, start, adj, visitedGoal, visitedStart))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int n = 8;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        // edges
        adj.get(0).add(1);
        adj.get(0).add(2);uu
        adj.get(1).add(3);
        adj.get(2).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(7);
        adj.get(6).add(7);

        int start = 0, goal = 5;

        System.out.println(bidirectionalDFS(start, goal, adj));
    }
}
