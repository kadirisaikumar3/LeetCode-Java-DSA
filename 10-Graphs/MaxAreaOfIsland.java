public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int area = dfs(grid, row, col);
                    maxArea = Math.max(maxArea, area);  }   }   }

        return maxArea; }
    private static int dfs(int[][] grid, int row, int col) {
        // Boundary check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;   }
        // Mark as visited
        grid[row][col] = 0;
        int area = 1;
        // Explore four directions
        area += dfs(grid, row - 1, col); // Up
        area += dfs(grid, row + 1, col); // Down
        area += dfs(grid, row, col - 1); // Left
        area += dfs(grid, row, col + 1); // Right
        return area;    }
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0}
        };
        int result = maxAreaOfIsland(grid);
        System.out.println("Maximum Area of Island: " + result);
    }
} 
