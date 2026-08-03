class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                } } }
        return false; }
    private static boolean dfs(char[][] board,
                               String word,
                               int row,
                               int col, int index) {
        if (index == word.length()) {
            return true; }
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false; }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found =
                dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row, col + 1, index + 1) ||
                dfs(board, word, row, col - 1, index + 1);
        board[row][col] = temp;
        return found; }
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'} };
        String word = "ABCCED";
        System.out.println("Word Exists: " + exist(board, word)); } }