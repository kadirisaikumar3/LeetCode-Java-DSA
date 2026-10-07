import java.util.*;
class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;   }   }
        return true;    }
    private static void dfs(
            List<List<Integer>> rooms,
            int room,
            boolean[] visited) {
        if (visited[room]) {
            return; }
        visited[room] = true;
        for (int key : rooms.get(room)) {
            dfs(rooms, key, visited);   }   }
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
        boolean result = canVisitAllRooms(rooms);
        System.out.println("Can Visit All Rooms: " + result);
    }
}