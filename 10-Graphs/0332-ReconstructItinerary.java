import java.util.*;
class ReconstructItinerary {
    public static List<String> findItinerary(
            List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(
                    from,
                    new PriorityQueue<>()
            );
            graph.get(from).offer(to);  }
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;   }
    private static void dfs( String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null
                && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next, graph, itinerary);    }
        itinerary.addFirst(airport);    }
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("MUC", "LHR"));
        tickets.add(List.of("JFK", "MUC"));
        tickets.add(List.of("SFO", "SJC"));
        tickets.add(List.of("LHR", "SFO"));
        List<String> result = findItinerary(tickets);
        System.out.println("Reconstructed Itinerary:");
        System.out.println(result); }   }