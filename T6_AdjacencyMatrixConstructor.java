import java.util.*;

public class T6_AdjacencyMatrixConstructor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        System.out.println("Enter the edges (vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // Handle loops, multiple edges, and directed edges
            if (vertex1 == vertex2) {
                // Loop, increment diagonal element
                adjacencyMatrix[vertex1][vertex2]++;
            } else {
                // Directed edge, increment element in both directions
                adjacencyMatrix[vertex1][vertex2]++;
                adjacencyMatrix[vertex2][vertex1]++;
            }
        }

        System.out.println("Adjacency Matrix:");
        printMatrix(adjacencyMatrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}