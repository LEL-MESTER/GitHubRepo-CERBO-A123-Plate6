import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2_GraphFromMatrix {
    private int[][] adjacencyMatrix;
    private int vertices;

    public T2_GraphFromMatrix(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void setAdjacencyMatrix(int[][] matrix) {
        this.adjacencyMatrix = matrix;
    }

    public void listEdges() {
        Map<String, Integer> edgeCount = new HashMap<>();
        
        for (int i = 0; i < vertices; i++) {
            for (int j = i; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCount.put(edge, adjacencyMatrix[i][j]);
                }
            }
        }

        System.out.println("Edges and their occurrences:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println("Edge: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        int[][] matrix = new int[vertices][vertices];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        T2_GraphFromMatrix graph = new T2_GraphFromMatrix(vertices);
        graph.setAdjacencyMatrix(matrix);
        graph.listEdges();

        scanner.close();
    }
}
