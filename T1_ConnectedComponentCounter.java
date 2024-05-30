import java.util.*;

public class T1_ConnectedComponentCounter {
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

        int numComponents = countConnectedComponents(edges, numVertices);

        if (numComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected. It has " + numComponents + " connected components.");
        }
    }

    public static int countConnectedComponents(List<int[]> edges, int numVertices) {
        boolean[] visited = new boolean[numVertices];
        int numComponents = 0;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(edges, visited, i);
                numComponents++;
            }
        }

        return numComponents;
    }

    public static void dfs(List<int[]> edges, boolean[] visited, int vertex) {
        visited[vertex] = true;

        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            if (vertex1 == vertex && !visited[vertex2]) {
                dfs(edges, visited, vertex2);
            } else if (vertex2 == vertex && !visited[vertex1]) {
                dfs(edges, visited, vertex1);
            }
        }
    }
}