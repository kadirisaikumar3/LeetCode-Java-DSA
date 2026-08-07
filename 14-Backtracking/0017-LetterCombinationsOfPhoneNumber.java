import java.util.ArrayList;
import java.util.List;
class LetterCombinationsOfPhoneNumber {
    private static final String[] KEYS = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println("Letter Combinations:");
        for (String word : result) {
            System.out.println(word);
        }
    }
}