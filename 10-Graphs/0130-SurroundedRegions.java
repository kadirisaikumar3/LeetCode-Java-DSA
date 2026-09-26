import java.util.*;
class SurroundedRegions {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        // Start DFS from all boundary 'O's.
        // These regions cannot be surrounded.
        for (int row = 0; row < rows; row++) {
            dfs(board, row, 0);
            dfs(board, row, cols - 1);
        }
        for (int col = 0; col < cols; col++) {
            dfs(board, 0, col);
            dfs(board, rows - 1, col);
        }
        // Convert surrounded O's to X's
        // and restore safe O's.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }
    private static void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        // Boundary check
        if (row < 0 || row >= rows
                || col < 0 || col >= cols
                || board[row][col] != 'O') {
            return;
        }
        // Mark this O as safe
        board[row][col] = '#';
        // Explore four directions
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        System.out.println("Final Board:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}