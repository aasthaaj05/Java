import java.util.*;

public class CycleDetectionBFS {
    private int V; // number of vertices
    private LinkedList<Integer>[] adj; // adjacency list

    public CycleDetectionBFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    // Add edge (undirected)
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // BFS-based cycle detection
    public boolean hasCycle() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCycleCheck(i, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean bfsCycleCheck(int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>(); // [node, parent]
        visited[start] = true;
        queue.offer(new int[]{start, -1}); // Start with no parent

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0], parent = pair[1];

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    // Found a back edge (cycle)
                    return true;
                }
            }
        }
        return false;
    }

    // Main function to test
    public static void main(String[] args) {
        CycleDetectionBFS graph = new CycleDetectionBFS(6);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); // ← this creates a cycle

        if (graph.hasCycle())
            System.out.println("Cycle detected.");
        else
            System.out.println("No cycle.");
    }
}
