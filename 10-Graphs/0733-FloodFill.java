class FloodFill {
    public static int[][] floodFill(int[][] image,int sr,int sc,int color) {
        int originalColor = image[sr][sc];
        // If the color is already the target color
        if (originalColor == color) {
            return image;   }
        dfs(image, sr, sc, originalColor, color);
        return image;   }
    private static void dfs(int[][] image,int row,int col,int originalColor,int newColor) {
        // Check boundaries
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return; }
        // Stop if the cell has a different color
        if (image[row][col] != originalColor) {
            return;     }
        // Change the current cell
        image[row][col] = newColor;
        // Explore four directions
        dfs(image, row - 1, col, originalColor, newColor); // Up
        dfs(image, row + 1, col, originalColor, newColor); // Down
        dfs(image, row, col - 1, originalColor, newColor); // Left
        dfs(image, row, col + 1, originalColor, newColor); // Right
        }
    public static void main(String[] args) {
        int[][] image = { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] result = floodFill(image, sr, sc, color);
        System.out.println("Flood Filled Image:");
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();   }   }   }