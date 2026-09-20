import java.util.*;
class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {
        // distance[i] = cheapest price to reach city i
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        // We can make at most k + 1 flights
        for (int stops = 0; stops <= k; stops++) {
            // Copy previous distances so that we only
            // use routes with the allowed number of flights
            int[] nextDistance = distance.clone();
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                // If 'from' is reachable
                if (distance[from] != Integer.MAX_VALUE) {
                    int newPrice = distance[from] + price;
                    if (newPrice < nextDistance[to]) {
                        nextDistance[to] = newPrice;
                    }
                }
            }
            distance = nextDistance;
        }
        return distance[dst] == Integer.MAX_VALUE
                ? -1
                : distance[dst];
    }
    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        int n = 3;
        int src = 0;
        int dst = 2;
        int k = 1;
        int result = findCheapestPrice(
                n, flights, src, dst, k);
        System.out.println(
                "Cheapest Flight Price: " + result);
    }
}