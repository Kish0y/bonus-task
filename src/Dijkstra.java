import java.util.*;

class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    private int vertices;
    private List<List<Edge>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(dest, weight));
        adjList.get(dest).add(new Edge(src, weight));
    }

    public void dijkstra(int start) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int u = minDistance(dist, visited);
            if (u == -1) break;

            visited[u] = true;

            for (Edge edge : adjList.get(u)) {
                int v = edge.destination;
                int w = edge.weight;

                if (!visited[v] && dist[u] != Integer.MAX_VALUE
                        && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        printResult(start, dist);
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && dist[v] <= minDist) {
                minDist = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printResult(int src, int[] dist) {
        System.out.println("=== Dijkstra's Algorithm ===");
        System.out.println("Source vertex: " + src);
        System.out.println("-----------------------");
        System.out.printf("%-10s %-15s%n", "Vertex", "Distance");
        System.out.println("-----------------------");
        for (int i = 0; i < vertices; i++) {
            String distance = (dist[i] == Integer.MAX_VALUE) ? "Unreachable" : String.valueOf(dist[i]);
            System.out.printf("%-10d %-15s%n", i, distance);
        }
        System.out.println("-----------------------");
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 6);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 3);
        graph.addEdge(4, 5, 5);

        graph.dijkstra(0);
    }
}