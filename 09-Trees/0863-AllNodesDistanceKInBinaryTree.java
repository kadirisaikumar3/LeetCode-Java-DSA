import java.util.*;
class AllNodesDistanceKInBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;     }      }
    public static List<Integer> distanceK(TreeNode root,TreeNode target,int k) {
        // Store parent of every node
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMap(root, null, parent);
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);   }
                return result;  }
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                // Left
                if (current.left != null
                        && visited.add(current.left)) {
                    queue.offer(current.left);  }
                // Right
                if (current.right != null
                        && visited.add(current.right)) {
                    queue.offer(current.right);     }
                // Parent
                TreeNode parentNode = parent.get(current);
                if (parentNode != null
                        && visited.add(parentNode)) {
                    queue.offer(parentNode);       }    }
            distance++;     }
        return result;      }
    private static void buildParentMap(TreeNode node,TreeNode parentNode,Map<TreeNode, TreeNode> parent) {
        if (node == null) {
            return;
        }
        parent.put(node, parentNode);
        buildParentMap(node.left, node, parent);
        buildParentMap(node.right, node, parent);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode target = root.left;
        int k = 2;
        List<Integer> result = distanceK(root, target, k);
        System.out.println("Nodes at Distance " + k + ":");
        System.out.println(result);
    }
}