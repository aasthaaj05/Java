import java.util.*;

public class DFSIterative {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    public DFSIterative(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    // Add edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w); // For undirected graph: adj[w].add(v);
    }

    // Iterative DFS without reversal
    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        System.out.print("DFS traversal (iterative): ");

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

                // Push neighbors in order 
                for (int neighbor : adj[node]) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DFSIterative graph = new DFSIterative(6);

        // Constructing a sample graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        graph.DFS(0); // Start DFS from node 0
    }
}
