import java.util.*;
class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1];
            // Original direction: from -> to, costs 1 to reverse
            graph.get(from).add(new int[]{to, 1});
            // Reverse traversal: to -> from, costs 0
            graph.get(to).add(new int[]{from, 0});
        }
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }
    private static int dfs(
            int city,
            List<List<int[]>> graph,
            boolean[] visited) {
        visited[city] = true;
        int changes = 0;
        for (int[] neighbor : graph.get(city)) {
            int nextCity = neighbor[0];
            int cost = neighbor[1];
            if (!visited[nextCity]) {
                changes += cost;
                changes += dfs(nextCity, graph, visited);
            }
        }
        return changes;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };
        System.out.println( "Minimum Reorders: " + minReorder(n, connections) );    }   }