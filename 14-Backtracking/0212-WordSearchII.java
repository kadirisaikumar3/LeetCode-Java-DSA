import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class WordSearchII {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; }
    private static final int[][] DIRECTIONS = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        Set<String> found = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dfs(board, row, col, root, found);
            }  }
        return new ArrayList<>(found); }
    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode(); }
                current = current.children[index]; }
            current.word = word; }
        return root;}
    private static void dfs(char[][] board,
                            int row,
                            int col,
                            TrieNode node,
                            Set<String> found) {
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return; }
        char ch = board[row][col];
        if (ch == '#') {
            return;
        }
        TrieNode next = node.children[ch - 'a'];
        if (next == null) {
            return;
        }
        if (next.word != null) {
            found.add(next.word);
        }
        board[row][col] = '#';
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(board, newRow, newCol, next, found);
        }
        board[row][col] = ch;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {  "oath", "pea", "eat", "rain"};
        List<String> result = findWords(board, words);
        System.out.println("Words Found:");
        for (String word : result) {
            System.out.println(word);  } } }