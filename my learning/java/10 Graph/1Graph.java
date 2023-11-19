class Graph {
  private int V; // number of vertices in graph
  private int E; // number of edges in graph
  private int[][] adjMatrix;

  public Graph(int nodes) {
    this.V = nodes;
    this.E = 0;
    this.adjMatrix = new int[nodes][nodes];
  }

  public void addEdge(int u, int v) {
    // we put 1 to represent the edge
    adjMatrix[u][v] = 1;
    adjMatrix[v][u] = 1; // putting 1 here too coz it is undirected graph
    E++; // keeps track of total number of edges in the graph
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(V + " vertices, " + E + " edges " + "\n");

    for (int v = 0; v < V; v++) {
      sb.append(v + ": "); // printing vertixes

      for (int w : adjMatrix[v]) {
        sb.append(w + " "); // printing row of each vertix
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 0);

    System.out.println(g);

  }
}