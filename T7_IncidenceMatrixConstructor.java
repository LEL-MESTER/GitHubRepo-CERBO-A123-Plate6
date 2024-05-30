import java.util.*;

public class T7_IncidenceMatrixConstructor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        int[][] incidenceMatrix = new int[numVertices][numEdges];

        System.out.println("Enter the edges (vertex1 vertex2 multiplicity):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int multiplicity = scanner.nextInt();

            // Undirected graph, so add edge to both vertices
            incidenceMatrix[vertex1][i] = multiplicity;
            incidenceMatrix[vertex2][i] = multiplicity;
        }

        System.out.println("Incidence Matrix:");
        printMatrix(incidenceMatrix);
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