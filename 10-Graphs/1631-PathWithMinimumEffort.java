import java.util.*;
class PathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effort = new int[rows][cols];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // {effort, row, col}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);
        effort[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentEffort = current[0];
            int row = current[1];
            int col = current[2];
            // Destination reached with minimum effort
            if (row == rows - 1 && col == cols - 1) {
                return currentEffort;
            }
            // Ignore outdated entries
            if (currentEffort > effort[row][col]) {
                continue;
            }
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow < 0 || newRow >= rows
                        || newCol < 0 || newCol >= cols) {
                    continue;
                }
                int currentHeight = heights[row][col];
                int nextHeight = heights[newRow][newCol];
                int edgeEffort =
                        Math.abs(currentHeight - nextHeight);
                // The path effort is the maximum edge
                // difference encountered so far.
                int newEffort =
                        Math.max(currentEffort, edgeEffort);
                if (newEffort < effort[newRow][newCol]) {
                    effort[newRow][newCol] = newEffort;
                    pq.offer(new int[]{
                            newEffort,
                            newRow,
                            newCol
                    }); }   }   }
        return 0;
    }
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int result = minimumEffortPath(heights);
        System.out.println("Minimum Effort: " + result);    }   }