import java.util.*;

public class TopologicalSortDFS {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj;

    public TopologicalSortDFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    // Add directed edge from u to v (u → v)
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // Main function to do topological sort
    public void topologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Perform DFS from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // Print topological order
        System.out.print("Topological Sort (DFS): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // Recursive DFS utility
    private void dfs(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }

        // Push to stack after visiting all neighbors
        stack.push(node);
    }

    public static void main(String[] args) {
        TopologicalSortDFS graph = new TopologicalSortDFS(6);

        // Directed edges (u → v)
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort();
    }
}
