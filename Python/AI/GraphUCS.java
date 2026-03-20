import java.util.*;

public class GraphUCS {
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
        int cost;
        
        Node(String vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Edge("B", 1), new Edge("C", 5)));
        graph.put("B", Arrays.asList(new Edge("D", 2)));
        graph.put("C", Arrays.asList(new Edge("D", 1)));
        graph.put("D", Arrays.asList(new Edge("E", 3)));
        graph.put("E", new ArrayList<>());
        
        ucs(graph, "A", "E");
    }
    
    static void ucs(Map<String, List<Edge>> graph, String start, String goal) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        
        pq.add(new Node(start, 0));
        distance.put(start, 0);
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.vertex.equals(goal)) {
                printPath(parent, start, goal, current.cost);
                return;
            }
            
            for (Edge edge : graph.get(current.vertex)) {
                int newCost = current.cost + edge.cost;
                
                if (!distance.containsKey(edge.target) || newCost < distance.get(edge.target)) {
                    distance.put(edge.target, newCost);
                    parent.put(edge.target, current.vertex);
                    pq.add(new Node(edge.target, newCost));
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