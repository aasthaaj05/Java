import java.util.*;

public class bfs{
    // Number of vertices
    private int V;
    
    // Adjacency list
    private LinkedList<Integer>[] adj;

    // Constructor
    public bfs(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v].add(w); // For undirected graph: also add adj[w].add(v);
    }

    // BFS traversal from a given source s
    public void BFS(int s) {
        boolean[] visited = new boolean[V]; // Mark all the vertices as not visited
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        System.out.print("BFS Traversal starting from node " + s + ": ");

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    // Main function
    public static void main(String[] args) {
        bfs graph = new bfs(6);

        // Creating a sample undirected graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        // Perform BFS from node 0
        graph.BFS(0);
    }
}
