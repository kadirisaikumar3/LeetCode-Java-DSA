import java.util.*;

class VerticalOrderTraversalOfABinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static class NodeInfo {
        TreeNode node;
        int row;
        int col;
        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        // Sort by column, then row, then value
        nodes.sort((a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col);
            }
            if (a.row != b.row) {
                return Integer.compare(a.row, b.row);
            }
            return Integer.compare(a.node.val, b.node.val);
        });
        List<List<Integer>> result = new ArrayList<>();
        int previousColumn = Integer.MIN_VALUE;
        for (NodeInfo info : nodes) {
            if (info.col != previousColumn) {
                result.add(new ArrayList<>());
                previousColumn = info.col;
            }
            result.get(result.size() - 1).add(info.node.val);
        }
        return result;
    }
    private static void dfs(TreeNode node,int row,int col,List<NodeInfo> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new NodeInfo(node, row, col));
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = verticalTraversal(root);
        System.out.println("Vertical Order Traversal:");
        System.out.println(result);
    }
}