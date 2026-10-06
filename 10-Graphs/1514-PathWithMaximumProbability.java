import java.util.*;

class PathWithMaximumProbability {

    public static double maxProbability(
            int n,
            int[][] edges,
            double[] succProb,
            int start,
            int end) {

        List<List<double[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double probability = succProb[i];

            graph.get(u).add(new double[]{v, probability});
            graph.get(v).add(new double[]{u, probability});
        }

        double[] maxProbability = new double[n];
        maxProbability[start] = 1.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b[1], a[1])
        );

        pq.offer(new double[]{start, 1.0});

        while (!pq.isEmpty()) {

            double[] current = pq.poll();

            int node = (int) current[0];
            double probability = current[1];

            if (node == end) {
                return probability;
            }

            if (probability < maxProbability[node]) {
                continue;
            }

            for (double[] neighbor : graph.get(node)) {

                int nextNode = (int) neighbor[0];
                double edgeProbability = neighbor[1];

                double newProbability =
                        probability * edgeProbability;

                if (newProbability > maxProbability[nextNode]) {

                    maxProbability[nextNode] = newProbability;

                    pq.offer(new double[]{
                            nextNode,
                            newProbability
                    });
                }
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };

        double[] succProb = {
                0.5,
                0.5,
                0.2
        };

        int start = 0;
        int end = 2;

        double result = maxProbability(
                n,
                edges,
                succProb,
                start,
                end
        );

        System.out.println(
                "Maximum Probability: " + result
        );
    }
}