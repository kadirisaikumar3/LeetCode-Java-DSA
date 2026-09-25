import java.util.*;
class Matrix01 {
    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // Add all 0 cells as starting points.
        // Their distance is already 0.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                } else {
                    // Mark 1 cells as unvisited.
                    mat[row][col] = -1;
                }
            }
        }
        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < rows
                        && newCol >= 0 && newCol < cols
                        && mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] =
                            mat[row][col] + 1;
                    queue.offer(new int[]{
                            newRow,
                            newCol
                    });
                }
            }
        }
        return mat;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] result = updateMatrix(matrix);
        System.out.println("Distance Matrix:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}