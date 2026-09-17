import java.util.*;
class WordLadder {
    public static int ladderLength(
            String beginWord,
            String endWord,
            List<String> wordList
    ) {
        Set<String> wordSet = new HashSet<>(wordList);
        // If the target word is not present,
        // transformation is impossible.
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process all words at the current BFS level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return level;
                }
                char[] characters = currentWord.toCharArray();
                // Change each character
                for (int j = 0; j < characters.length; j++) {
                    char originalCharacter = characters[j];
                    for (char character = 'a'; character <= 'z'; character++) {
                        if (character == originalCharacter) {
                            continue;
                        }
                        characters[j] = character;
                        String nextWord = new String(characters);
                        // Add only valid and unvisited words
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            // Mark as visited immediately
                            wordSet.remove(nextWord);
                        }
                    }
                    characters[j] = originalCharacter;
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(
                "hot",
                "dot",
                "dog",
                "lot",
                "log",
                "cog"
        );
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest Transformation Length: " + result);
    }
}