import java.util.LinkedList;

class ConnectedGraph {
  private LinkedList<Integer>[] adj;
  private int V; // number of vertices
  private int E; // number of edges

  int[] compId;
  int count = 0;

  public ConnectedGraph(int nodes) {
    this.V = nodes;
    this.E = 0;
    this.adj = new LinkedList[nodes]; // initializing the array of LinkedList for all vertices
    for (int v = 0; v < V; v++) {
      adj[v] = new LinkedList<>(); // initializes an empty LinkedList for a specific vertex v in the graph
    }

    this.compId = new int[V];

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
        dfs(v, visited, compId, count);
        count++;
      }
    }
  }

  public void dfs(int v, boolean[] visited, int[] compId, int count) {
    visited[v] = true;
    compId[v] = count;

    for (int w : adj[v]) {
      if (!visited[w]) {
        dfs(w, visited, compId, count);
      }
    }
  }

  public int getCount() {
    return count;
  }

  public boolean isConnected(int x, int y) {
    return compId[x] == compId[y];
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

    ConnectedGraph g = new ConnectedGraph(nodes);

    g.addEdge(0, 1); // means 0 and 1 are a edge
    g.addEdge(3, 0);
    g.addEdge(2, 4);

    System.out.println(g);

    g.dfs();

    // get all the connected graphs
    System.out.println("Total connected graphs are: " + g.getCount());

    boolean isConnected1 = g.isConnected(1, 3);
    boolean isConnected2 = g.isConnected(2, 4);
    boolean isConnected3 = g.isConnected(2, 1);

    // check if 1 and 3 are inside a particular connected graph
    System.out.println("1 and 3 connected? " + isConnected1);
    System.out.println("2 and 4 connected? " + isConnected2);
    System.out.println("2 and 1 connected? " + isConnected3);
  }
}
