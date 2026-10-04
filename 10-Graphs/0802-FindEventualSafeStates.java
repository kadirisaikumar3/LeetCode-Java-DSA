import java.util.*;
class FindEventualSafeStates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 0 = unvisited
        // 1 = visiting
        // 2 = safe
        // 3 = unsafe
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            if (dfs(graph, node, state)) {
                result.add(node);   }   }
        return result;  }
    private static boolean dfs( int[][] graph, int node, int[] state) {
        // Currently visiting -> cycle found
        if (state[node] == 1) {
            return false;   }
        // Already determined
        if (state[node] == 2) {
            return true;    }
        if (state[node] == 3) {
            return false;   }
        // Mark as currently visiting
        state[node] = 1;
        for (int neighbor : graph[node]) {
            if (!dfs(graph, neighbor, state)) {
                state[node] = 3;
                return false;   }   }
        // No cycle reachable from this node
        state[node] = 2;
        return true;    }
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        List<Integer> result = eventualSafeNodes(graph);
        System.out.println( "Eventual Safe Nodes: " + result ); }   }