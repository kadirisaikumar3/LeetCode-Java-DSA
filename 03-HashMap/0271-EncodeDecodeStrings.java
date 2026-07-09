import java.util.ArrayList;
import java.util.List;
public class EncodeDecodeStrings {
    // Encode a list of strings into a single string
    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str); }
        return encoded.toString(); }
    // Decode the encoded string back into a list
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++; }
            int length = Integer.parseInt(s.substring(i, j));
            String word = s.substring(j + 1, j + 1 + length);
            result.add(word);
            i = j + 1 + length; }
        return result; }
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Java");
        words.add("DSA");
        words.add("LinkedIn");
        words.add("GitHub");
        String encoded = encode(words);
        System.out.println("Encoded String:");
        System.out.println(encoded);
        System.out.println("\nDecoded Strings:");
        List<String> decoded = decode(encoded);
        for (String word : decoded) {
            System.out.println(word);
        }
    } }