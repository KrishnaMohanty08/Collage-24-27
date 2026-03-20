import java.util.*;

class Node {
    int id;
    int h; // heuristic value

    Node(int id, int h) {
        this.id = id;
        this.h = h;
    }
}

public class GreedyBestFirstSearch {

    static void greedyBestFirstSearch(
            int start,
            int goal,
            List<List<Integer>> adj,
            Map<Integer, Integer> heuristic) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator.comparingInt(n -> n.h)
        );

        Set<Integer> visited = new HashSet<>();

        pq.add(new Node(start, heuristic.get(start)));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited.contains(current.id))
                continue;

            visited.add(current.id);
            System.out.print(current.id + " ");

            if (current.id == goal) {
                System.out.println("\nGoal reached!");
                return;
            }

            for (int neighbor : adj.get(current.id)) {
                if (!visited.contains(neighbor)) {
                    pq.add(new Node(neighbor, heuristic.get(neighbor)));
                }
            }
        }
        System.out.println("\nGoal not reachable");
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        // graph edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);
        adj.get(4).add(5);

        // heuristic values (straight-line distance)
        Map<Integer, Integer> heuristic = new HashMap<>();
        heuristic.put(0, 10);
        heuristic.put(1, 8);
        heuristic.put(2, 5);
        heuristic.put(3, 7);
        heuristic.put(4, 3);
        heuristic.put(5, 0);

        greedyBestFirstSearch(0, 5, adj, heuristic);
    }
}
