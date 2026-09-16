import java.util.Arrays;
class RedundantConnection {
    static class UnionFind {
        private int[] parent;
        private int[] rank;
        UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }
        // Find the representative of a component
        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }
        // Join two components
        boolean union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            // Both nodes already belong to the same component
            if (root1 == root2) {
                return false;
            }
            // Union by rank
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
            return true;
        }
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // If union fails, this edge creates a cycle
            if (!unionFind.union(u, v)) {
                return edge;
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };
        int[] result = findRedundantConnection(edges);
        System.out.println("Redundant Edge: " + Arrays.toString(result));
    }
}