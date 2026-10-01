import java.util.*;
class EvaluateDivision {
    public static double[] calcEquation(
            List<List<String>> equations,double[] values,List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(new Edge(b, value));
            graph.get(b).add(new Edge(a, 1.0 / value)); }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
                continue;   }
            if (start.equals(end)) {
                result[i] = 1.0;
                continue;   }
            Set<String> visited = new HashSet<>();
            result[i] = dfs(
                    graph,
                    start,
                    end,
                    1.0,
                    visited
            );  }
        return result;  }
    private static double dfs(Map<String, List<Edge>> graph,String current,String target,double product,Set<String> visited) {
        if (current.equals(target)) {
            return product; }
        visited.add(current);
        for (Edge edge : graph.get(current)) {
            if (visited.contains(edge.node)) {
                continue;
            }
            double result = dfs(graph,edge.node,target,product * edge.value,visited);
            if (result != -1.0) {
                return result;
            }   }
        return -1.0;    }
    static class Edge {
        String node;
        double value;
        Edge(String node, double value) {
            this.node = node;
            this.value = value; }   }
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "b"));
        equations.add(List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a", "c"));
        queries.add(List.of("b", "a"));
        queries.add(List.of("a", "e"));
        queries.add(List.of("a", "a"));
        queries.add(List.of("x", "x"));
        double[] result =calcEquation(equations, values, queries);
        System.out.println("Results:");
        for (double value : result) {
            System.out.println(value);  }   }   }