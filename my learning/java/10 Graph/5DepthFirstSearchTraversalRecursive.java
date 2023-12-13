import java.util.LinkedList;
import java.util.Stack;

class DepthFirstSearchTraversal {
  private LinkedList<Integer>[] adj;
  private int V; // number of vertices
  private int E; // number of edges

  public DepthFirstSearchTraversal(int nodes) {
    this.V = nodes;
    this.E = 0;
    this.adj = new LinkedList[nodes]; // initializing the array of LinkedList for all vertices
    for (int v = 0; v < V; v++) {
      adj[v] = new LinkedList<>(); // initializes an empty LinkedList for a specific vertex v in the graph
    }
  }

  public void addEdge(int u, int v) {
    // adding value to linked list array element

    adj[u].add(v); // we add the edge as value to represent that there is an edge between two
                   // vertices v and u
    adj[v].add(u); // since the graph is unidirection we add value to both edge array element
    E++; // counting the number of edges
  }

  public void dfs() {
    boolean[] visited = new boolean[V];

    for (int v = 0; v < V; v++) {
      if (!visited[v]) {
        dfs(v, visited);
      }
    }
  }

  public void dfs(int v, boolean[] visited) {
    visited[v] = true;

    System.out.print(v + " ");

    for (int w : adj[v]) {
      if (!visited[w]) {
        dfs(w, visited);
      }
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(V + " vertices, " + E + " edges " + "\n");

    for (int v = 0; v < V; v++) {
      sb.append(v + ": ");

      for (int w : adj[v]) {
        sb.append(w + " ");
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    int nodes = 5;

    DepthFirstSearchTraversal g = new DepthFirstSearchTraversal(nodes);

    g.addEdge(0, 1); // means 0 and 1 are a edge
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 0);
    g.addEdge(2, 4);

    System.out.println(g);

    g.dfs();
  }
}
