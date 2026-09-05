import java.util.LinkedList;
import java.util.Queue;
class MaximumWidthOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val; }   }
    static class NodeInfo {
        TreeNode node;
        long index;
        NodeInfo(TreeNode node, long index) {
            this.node = node;
            this.index = index; }   }
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;   }
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            long firstIndex = queue.peek().index;
            long lastIndex = firstIndex;
            for (int i = 0; i < size; i++) {
                NodeInfo current = queue.poll();
                long currentIndex = current.index;
                lastIndex = currentIndex;
                // Normalize indices to avoid overflow
                long normalizedIndex =
                        currentIndex - firstIndex;
                if (current.node.left != null) {
                    queue.offer(
                            new NodeInfo(
                                    current.node.left,
                                    2 * normalizedIndex
                            )
                    );  }
                if (current.node.right != null) {
                    queue.offer(
                            new NodeInfo(
                                    current.node.right,
                                    2 * normalizedIndex + 1
                            )
                    );  }   }
            maxWidth = Math.max(
                    maxWidth,
                    (int) (lastIndex - firstIndex + 1)
            );  }
        return maxWidth;    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        int result = widthOfBinaryTree(root);
        System.out.println("Maximum Width of Binary Tree: " + result);  }   }