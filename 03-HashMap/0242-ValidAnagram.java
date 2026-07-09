import java.util.HashMap;
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // Count frequency of characters in first string
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // Reduce frequency using second string
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);

            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s1 = "listen";
        String t1 = "silent";

        String s2 = "hello";
        String t2 = "world";

        System.out.println("listen & silent : " + isAnagram(s1, t1));

        System.out.println("hello & world : " + isAnagram(s2, t2));
    }
}