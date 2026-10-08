import java.util.*;

class MinimumHeightTrees {

    public static List<Integer> findMinHeightTrees(
            int n, int[][] edges) {

        if (n == 1) {
            return new ArrayList<>(Collections.singletonList(0));
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all initial leaves
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {

            int leaves = queue.size();

            remainingNodes -= leaves;

            for (int i = 0; i < leaves; i++) {

                int leaf = queue.poll();

                for (int neighbor : graph.get(leaf)) {

                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] edges = {
                {1, 0},
                {1, 2},
                {1, 3}
        };

        List<Integer> result =
                findMinHeightTrees(n, edges);

        System.out.println(
                "Minimum Height Tree Roots: " + result
        );
    }
}