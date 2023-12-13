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

  // Depth-first search is an algorithm for traversing or searching tree or graph
  // data structures. The algorithm starts at the root node (selecting some
  // arbitrary node as the root node in the case of a graph) and explores as far
  // as possible along each branch before backtracking.
  // It uses an vistied array to keep track of the nodes that is already
  // traversed. And uses stack to traverse all the associated nodes beginning from
  // a particular node.
  public void dfs(int s) {
    // s is a starting node for traversal
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();

    stack.push(s);

    while (!stack.isEmpty()) {
      int u = stack.pop();

      if (!visited[u]) {
        visited[u] = true;
        System.out.print(u + " ");

        for (int v : adj[u]) {
          if (!visited[v]) {
            stack.push(v);
          }
        }
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
    DepthFirstSearchTraversal g = new DepthFirstSearchTraversal(5);

    g.addEdge(0, 1); // means 0 and 1 are a edge
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 0);
    g.addEdge(2, 4);

    System.out.println(g);

    g.dfs(0); // giving source node as 0
  }
}
