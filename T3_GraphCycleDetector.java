import java.util.Scanner;

public class T3_GraphCycleDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        boolean hasCycle = hasCycle(adjacencyMatrix);

        if (hasCycle) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }
    }

    public static boolean hasCycle(int[][] adjacencyMatrix) {
        int numVertices = adjacencyMatrix.length;
        boolean[] visited = new boolean[numVertices];
        boolean[] recursionStack = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, adjacencyMatrix, visited, recursionStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasCycleUtil(int vertex, int[][] adjacencyMatrix, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[vertex]) {
            return true;
        }

        if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] > 0) {
                if (hasCycleUtil(i, adjacencyMatrix, visited, recursionStack)) {
                    return true;
                }
            }
        }

        recursionStack[vertex] = false;
        return false;
    }
}