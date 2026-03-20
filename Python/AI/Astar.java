import java.util.*;
public class Astar {

    static class Edge {
        String target;
        int cost;
        
        Edge(String target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
    
    static class Node implements Comparable<Node> {
        String vertex;
        int g; // actual cost from start
        int h; // heuristic cost to goal
        int f; // f = g + h
        
        Node(String vertex, int g, int h) {
            this.vertex = vertex;
            this.g = g;
            this.h = h;
            this.f = g + h;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.f, other.f);
        }
    }
    
    // Heuristic function (can be customized)
    static Map<String, Integer> heuristic = new HashMap<String, Integer>() {{
        put("A", 7);
        put("B", 6);
        put("C", 2);
        put("D", 1);
        put("E", 0);
    }};
    
    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Edge("B", 1), new Edge("C", 5)));
        graph.put("B", Arrays.asList(new Edge("D", 2)));
        graph.put("C", Arrays.asList(new Edge("D", 1)));
        graph.put("D", Arrays.asList(new Edge("E", 3)));
        graph.put("E", new ArrayList<>());
        
        aStar(graph, "A", "E");
    }
    
    static void aStar(Map<String, List<Edge>> graph, String start, String goal) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<String, Integer> gScore = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();
        
        pq.add(new Node(start, 0, heuristic.get(start)));
        gScore.put(start, 0);
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.vertex.equals(goal)) {
                printPath(parent, start, goal, current.g);
                return;
            }
            
            if (visited.contains(current.vertex)) continue;
            visited.add(current.vertex);
            
            for (Edge edge : graph.get(current.vertex)) {
                int newG = current.g + edge.cost;
                
                if (!gScore.containsKey(edge.target) || newG < gScore.get(edge.target)) {
                    gScore.put(edge.target, newG);
                    parent.put(edge.target, current.vertex);
                    int h = heuristic.getOrDefault(edge.target, 0);
                    pq.add(new Node(edge.target, newG, h));
                }
            }
        }
        
        System.out.println("No path found.");
    }
    
    static void printPath(Map<String, String> parent, String start, String goal, int cost) {
        List<String> path = new ArrayList<>();
        String current = goal;
        
        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }
        
        Collections.reverse(path);
        System.out.println("Shortest Path: " + path);
        System.out.println("Total Cost: " + cost);
    }
}
