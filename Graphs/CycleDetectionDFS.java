import java.util.*;

public class CycleDetectionDFS {
    private int V;
    private LinkedList<Integer>[] adj;

    public CycleDetectionDFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    // Add edge to undirected graph
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // DFS-based cycle detection for all components
    public boolean hasCycle() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycleCheck(i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    // Recursive DFS function
    private boolean dfsCycleCheck(int current, int parent, boolean[] visited) {
        visited[current] = true;

        for (int neighbor : adj[current]) {
            if (!visited[neighbor]) {
                if (dfsCycleCheck(neighbor, current, visited))
                    return true;
            } else if (neighbor != parent) {
                // Visited node and not coming back to parent → cycle
                return true;
            }
        }
        return false;
    }

    // Main
    public static void main(String[] args) {
        CycleDetectionDFS graph = new CycleDetectionDFS(6);

        // Edges that form a cycle
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); // This creates a cycle

        if (graph.hasCycle())
            System.out.println("Cycle detected.");
        else
            System.out.println("No cycle.");
    }
}
