import java.util.*;

public class T5_BipartiteGraphDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        List<int[]> edges = new ArrayList<>();

        System.out.println("Enter the edges (vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges.add(new int[]{vertex1, vertex2});
        }

        boolean isBipartite = isBipartite(edges, numVertices);

        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }

    public static boolean isBipartite(List<int[]> edges, int numVertices) {
        int[] colors = new int[numVertices];
        Arrays.fill(colors, -1);

        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            if (colors[vertex1] == -1 && colors[vertex2] == -1) {
                colors[vertex1] = 0;
                colors[vertex2] = 1;
            } else if (colors[vertex1] == -1) {
                colors[vertex1] = 1 - colors[vertex2];
            } else if (colors[vertex2] == -1) {
                colors[vertex2] = 1 - colors[vertex1];
            } else if (colors[vertex1] == colors[vertex2]) {
                return false;
            }
        }

        return true;
    }
}