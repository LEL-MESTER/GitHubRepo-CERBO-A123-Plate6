import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T4_VertexDegreeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        Map<Integer, Integer> vertexDegrees = new HashMap<>();

        System.out.println("Enter the edges (vertex1 vertex2):");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            vertexDegrees.put(vertex1, vertexDegrees.getOrDefault(vertex1, 0) + 1);
            vertexDegrees.put(vertex2, vertexDegrees.getOrDefault(vertex2, 0) + 1);
        }

        System.out.println("Vertex degrees:");
        for (Map.Entry<Integer, Integer> entry : vertexDegrees.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " has degree " + entry.getValue());
        }
    }
}