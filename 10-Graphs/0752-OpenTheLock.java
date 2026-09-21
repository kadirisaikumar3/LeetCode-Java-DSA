import java.util.*;
class OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        // Starting combination is blocked
        if (dead.contains("0000")) {
            return -1;
        }
        // Already at target
        if (target.equals("0000")) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                char[] wheels = current.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char original = wheels[j];
                    // Turn wheel forward
                    wheels[j] = original == '9'
                            ? '0'
                            : (char) (original + 1);
                    String next = new String(wheels);
                    if (next.equals(target)) {
                        return moves;
                    }
                    if (!dead.contains(next)
                            && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                    // Turn wheel backward
                    wheels[j] = original == '0'
                            ? '9'
                            : (char) (original - 1);
                    next = new String(wheels);
                    if (next.equals(target)) {
                        return moves;
                    }
                    if (!dead.contains(next)
                            && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                    // Restore original digit
                    wheels[j] = original;
                }   }   }
        return -1;  }
    public static void main(String[] args) {
        String[] deadends = {
                "0201",
                "0101",
                "0102",
                "1212",
                "2002"
        };
        String target = "0202";
        int result = openLock(deadends, target);
        System.out.println("Minimum Moves: " + result);
    }
}