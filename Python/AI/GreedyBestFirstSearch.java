import java.util.*;

class GreedyBestFirstSearch {

    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> heuristic = new HashMap<>();

    public static void greedyBestFirstSearch(String start, String goal) {

        PriorityQueue<String> openList =
                new PriorityQueue<>(Comparator.comparingInt(heuristic::get));

        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        List<String> expandedNodes = new ArrayList<>();

        openList.add(start);
        parent.put(start, null);

        while (!openList.isEmpty()) {
            String current = openList.poll();

            if (visited.contains(current))
                continue;

            visited.add(current);
            expandedNodes.add(current);

            if (current.equals(goal))
                break;

            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    openList.add(neighbor);
                    parent.putIfAbsent(neighbor, current);
                }
            }
        }

        // Display Expanded Nodes
        System.out.print("Expanded Nodes: ");
        System.out.println(String.join(" → ", expandedNodes));

        // Reconstruct Path
        List<String> path = new ArrayList<>();
        String node = goal;

        while (node != null) {
            path.add(node);
            node = parent.get(node);
        }

        Collections.reverse(path);

        // Display Path
        System.out.print("Path Found: ");
        System.out.println(String.join(" → ", path));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of nodes
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Heuristic values
        System.out.println("Enter node and its heuristic value:");
        for (int i = 0; i < n; i++) {
            String node = sc.next();
            int h = sc.nextInt();
            heuristic.put(node, h);
        }

        // Number of edges
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < e; i++) {
            String u = sc.next();
            String v = sc.next();

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
        }

        // Start and Goal
        System.out.print("Enter Start Node: ");
        String start = sc.next();

        System.out.print("Enter Goal Node: ");
        String goal = sc.next();

        // Perform Greedy Best-First Search
        greedyBestFirstSearch(start, goal);

        sc.close();
    }
}
