import java.util.*;

public class bfs {
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
		Queue<Integer> q = new LinkedList<Integer>();

		// Run BFS for each component (handles disconnected graphs)
		for (int s = 0; s < n; s++) {
			if (!visited[s]) {
				visited[s] = true;
				q.add(s);
				while (!q.isEmpty()) {
					int v = q.remove();
					System.out.print(v + " ");
					// explore neighbors of v
					for (int j = 0; j < n; j++) {
						if (a[v][j] != 0 && !visited[j]) {
							visited[j] = true;
							q.add(j);
						}
					}
				}
				System.out.println(); 
			}
		}
	}
}
