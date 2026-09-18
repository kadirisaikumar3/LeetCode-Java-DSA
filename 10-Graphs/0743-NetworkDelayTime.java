import java.util.*;
class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int weight = time[2];

            graph[source].add(new int[]{destination, weight});
        }
        // Distance array
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        // Priority Queue: {node, distance}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDistance = current[1];
            // Ignore outdated entries
            if (currentDistance > distance[node]) {
                continue;
            }
            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDistance = currentDistance + weight;
                if (newDistance < distance[nextNode]) {
                    distance[nextNode] = newDistance;
                    pq.offer(new int[]{nextNode, newDistance});
                }
            }
        }
        // Find maximum shortest distance
        int maximumTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maximumTime = Math.max(maximumTime, distance[i]);
        }
        return maximumTime;
    }
    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4;
        int k = 2;
        int result = networkDelayTime(times, n, k);
        System.out.println("Network Delay Time: " + result);
    }
}