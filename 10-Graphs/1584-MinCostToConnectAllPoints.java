import java.util.*;
class MinCostToConnectAllPoints {
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // Track whether a point is already included in MST
        boolean[] visited = new boolean[n];
        // Minimum cost to connect each point to the MST
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        // Start from point 0
        minCost[0] = 0;
        int totalCost = 0;
        // Prim's Algorithm
        for (int count = 0; count < n; count++) {
            // Find unvisited point with minimum connection cost
            int currentPoint = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i]
                        && (currentPoint == -1
                        || minCost[i] < minCost[currentPoint])) {
                    currentPoint = i;
                }
            }
            // Add this point to MST
            visited[currentPoint] = true;
            totalCost += minCost[currentPoint];
            // Update costs of remaining points
            for (int nextPoint = 0; nextPoint < n; nextPoint++) {
                if (!visited[nextPoint]) {
                    int distance =
                            Math.abs(points[currentPoint][0]
                                    - points[nextPoint][0])
                            + Math.abs(points[currentPoint][1]
                                    - points[nextPoint][1]);
                    minCost[nextPoint] =
                            Math.min(minCost[nextPoint], distance);
                }
            }
        }
        return totalCost;
    }
    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };
        int result = minCostConnectPoints(points);
        System.out.println("Minimum Cost to Connect All Points: " + result);
    }
}