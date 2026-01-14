import java.util.*;

public class BiDirectionalBFS {

    static int V;

    public static void main(String[] args) {

        int[][] graph = {
                {0,1,1,0,0,0},
                {1,0,0,1,0,0},
                {1,0,0,1,0,0},
                {0,1,1,0,1,1},
                {0,0,0,1,0,0},
                {0,0,0,1,0,0}
        };

        V = graph.length;

        int src = 0;
        int dest = 5;

        List<Integer> path = bidirectionalBFS(graph, src, dest);

        if (path != null)
            System.out.println("Path: " + path);
        else
            System.out.println("No path found");
    }

    static List<Integer> bidirectionalBFS(int[][] graph, int src, int dest) {

        boolean[] visitedSrc = new boolean[V];
        boolean[] visitedDest = new boolean[V];

        int[] parentSrc = new int[V];
        int[] parentDest = new int[V];

        Arrays.fill(parentSrc, -1);
        Arrays.fill(parentDest, -1);

        Queue<Integer> qSrc = new LinkedList<>();
        Queue<Integer> qDest = new LinkedList<>();

        qSrc.add(src);
        qDest.add(dest);

        visitedSrc[src] = true;
        visitedDest[dest] = true;

        int meetingNode = -1;

        while (!qSrc.isEmpty() && !qDest.isEmpty()) {

            meetingNode = expand(graph, qSrc, visitedSrc, visitedDest, parentSrc);
            if (meetingNode != -1) break;

            meetingNode = expand(graph, qDest, visitedDest, visitedSrc, parentDest);
            if (meetingNode != -1) break;
        }

        if (meetingNode == -1) return null;

        return buildPath(parentSrc, parentDest, meetingNode, src, dest);
    }

    static int expand(int[][] graph, Queue<Integer> queue,
                      boolean[] visitedThis,
                      boolean[] visitedOther,
                      int[] parent) {

        int size = queue.size();

        while (size-- > 0) {
            int node = queue.poll();

            for (int i = 0; i < V; i++) {
                if (graph[node][i] == 1 && !visitedThis[i]) {

                    parent[i] = node;
                    visitedThis[i] = true;

                    if (visitedOther[i])
                        return i; 

                    queue.add(i);
                }
            }
        }
        return -1;
    }

    static List<Integer> buildPath(int[] parentSrc,
                                   int[] parentDest,
                                   int meet,
                                   int src,
                                   int dest) {

        List<Integer> path = new ArrayList<>();

        int curr = meet;
        while (curr != -1) {
            path.add(curr);
            curr = parentSrc[curr];
        }
        Collections.reverse(path);
        curr = parentDest[meet];
        while (curr != -1) {
            path.add(curr);
            curr = parentDest[curr];
        }

        return path;
    }
}
