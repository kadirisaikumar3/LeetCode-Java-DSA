import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class PacificAtlanticWaterFlow {
    private static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        // Start DFS from Pacific Ocean borders.
        for (int col = 0; col < cols; col++) {
            dfs(0, col, heights, pacific);
            dfs(rows - 1, col, heights, atlantic);
        }
        for (int row = 0; row < rows; row++) {
            dfs(row, 0, heights, pacific);
            dfs(row, cols - 1, heights, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));    }   }   }

        return result;  }
    private static void dfs(int row, int col, int[][] heights, boolean[][] visited) {
        int rows = heights.length;
        int cols = heights[0].length;
        if (visited[row][col]) {
            return; }
        visited[row][col] = true;
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                continue;   }
            // Reverse flow:
            // Move to a cell with equal or greater height.
            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, heights, visited);  }   }   }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> result = pacificAtlantic(heights);
        System.out.println("Cells flowing to both oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);   }   }   }