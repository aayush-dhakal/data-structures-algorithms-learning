import java.util.LinkedList;
import java.util.Queue;

class BreadthFirstSearchTraversal {
  private LinkedList<Integer>[] adj;
  private int V; // number of vertices
  private int E; // number of edges

  public BreadthFirstSearchTraversal(int nodes) {
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

  // The Breadth First Search (BFS) algorithm is used to search a graph data
  // structure for a node that meets a set of criteria. It starts at the root of
  // the graph and visits all nodes at the current depth level before moving on to
  // the nodes at the next depth level.
  // It uses an vistied array to keep track of the nodes that is already
  // traversed. And uses queue to traverse the child nodes.
  public void bfs(int s) {
    // s is a starting node for traversal
    boolean[] visited = new boolean[V];
    Queue<Integer> q = new LinkedList<>();

    visited[s] = true;
    q.offer(s);

    while (!q.isEmpty()) {
      int u = q.poll();
      System.out.print(u + " ");

      for (int v : adj[u]) {
        if (!visited[v]) {
          visited[v] = true;
          q.offer(v);
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
    BreadthFirstSearchTraversal g = new BreadthFirstSearchTraversal(5);

    g.addEdge(0, 1); // means 0 and 1 are a edge
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 0);
    g.addEdge(2, 4);

    g.bfs(0); // giving source node as 0
  }
}
