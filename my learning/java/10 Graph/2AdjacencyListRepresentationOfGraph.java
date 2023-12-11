import java.util.LinkedList;

class AdjacencyListRepresentationOfGraph {
  private LinkedList<Integer>[] adj;
  private int V; // number of vertices
  private int E; // number of edges

  public AdjacencyListRepresentationOfGraph(int nodes) {
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
    AdjacencyListRepresentationOfGraph g = new AdjacencyListRepresentationOfGraph(4);

    g.addEdge(0, 1); // means 0 and 1 are a edge
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 0);

    System.out.println(g);
  }
}
