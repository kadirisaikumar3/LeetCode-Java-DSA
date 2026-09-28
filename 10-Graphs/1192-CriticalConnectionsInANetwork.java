import java.util.ArrayList;
import java.util.List;
class CriticalConnectionsInANetwork {
    private static int time;
    private static int[] discovery;
    private static int[] low;
    private static List<List<Integer>> graph;
    private static List<List<Integer>> result;
    public static List<List<Integer>> criticalConnections(
            int n,
            List<List<Integer>> connections) {
        graph = new ArrayList<>();
        result = new ArrayList<>();
        discovery = new int[n];
        low = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        time = 0;
        dfs(0, -1);
        return result;
    }
    private static void dfs(int node, int parent) {
        discovery[node] = low[node] = ++time;
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (discovery[neighbor] == 0) {
                dfs(neighbor, node);
                low[node] = Math.min(
                        low[node],
                        low[neighbor]
                );
                if (low[neighbor] > discovery[node]) {
                    List<Integer> connection = new ArrayList<>();
                    connection.add(node);
                    connection.add(neighbor);
                    result.add(connection);
                }
            } else {
                low[node] = Math.min(
                        low[node],
                        discovery[neighbor]
                );  }   }   }
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(List.of(0, 1));
        connections.add(List.of(1, 2));
        connections.add(List.of(2, 0));
        connections.add(List.of(1, 3));
        List<List<Integer>> result =
                criticalConnections(n, connections);
        System.out.println("Critical Connections:");
        for (List<Integer> connection : result) {
            System.out.println(connection); }   }   }