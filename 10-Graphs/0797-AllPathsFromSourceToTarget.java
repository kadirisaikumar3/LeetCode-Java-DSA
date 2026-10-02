import java.util.*;
class AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget( int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }
    private static void dfs(
            int[][] graph,
            int node,
            List<Integer> path,
            List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int neighbor : graph[node]) {
            path.add(neighbor);
            dfs(graph, neighbor, path, result);
            path.remove(path.size() - 1);   }   }
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };
        List<List<Integer>> result =
                allPathsSourceTarget(graph);
        System.out.println("All Paths:");
        for (List<Integer> path : result) {
            System.out.println(path);
        }   }   }