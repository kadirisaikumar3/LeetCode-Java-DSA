import java.util.*;
class IsGraphBipartite {
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // -1 means the node is not colored yet
        int[] color = new int[n];
        Arrays.fill(color, -1);
        // The graph may be disconnected,
        // so check every node.
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean bfs(
            int start,
            int[][] graph,
            int[] color)
             {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                // If neighbor is not colored,
                // assign the opposite color.
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[current];
                    queue.offer(neighbor);
                }
                // If adjacent nodes have the same color,
                // the graph is not bipartite.
                else if (color[neighbor] == color[current]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        boolean result = isBipartite(graph);
        System.out.println("Is the graph bipartite? " + result);
    }
}