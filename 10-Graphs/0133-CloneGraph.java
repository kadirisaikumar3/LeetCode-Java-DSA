import java.util.*;
class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>(); }   }
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;    }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        // Create clone of the starting node
        map.put(node, new Node(node.val));
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                // If neighbor is not cloned yet
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);  }
                // Connect cloned nodes
                map.get(current).neighbors.add(map.get(neighbor));  }   }

        return map.get(node);   }
    public static void main(String[] args) {
        // Create graph:
        // 1 -- 2
        // |    |
        // 4 -- 3
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node clonedGraph = cloneGraph(node1);
        System.out.println(
                "Cloned Graph Starting Node: " + clonedGraph.val);
        System.out.println(
                "Number of Neighbors: " + clonedGraph.neighbors.size()
        );
    }
}