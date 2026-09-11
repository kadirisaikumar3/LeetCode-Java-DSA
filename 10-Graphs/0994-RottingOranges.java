import java.util.LinkedList;
import java.util.Queue;
class RottingOranges {
    static class Cell {
        int row;
        int col;
        int time;
        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;   }   }
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;
        // Add all initially rotten oranges to the queue
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new Cell(row, col, 0));
                } else if (grid[row][col] == 1) {
                    freshOranges++; }   }   }
        int[][] directions = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
        };
        // Multi-source BFS
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            minutes = Math.max(minutes, current.time);
            for (int[] direction : directions) {
                int newRow = current.row + direction[0];
                int newCol = current.col + direction[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    freshOranges--;
                    queue.offer(
                        new Cell(newRow, newCol, current.time + 1)  );  }   }   }

        return freshOranges == 0 ? minutes : -1;    }
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        int result = orangesRotting(grid);
        System.out.println("Minutes to Rot All Oranges: " + result);
    }
}