import java.util.ArrayList;
import java.util.List;

class BinaryTreePreorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;  }
    private static void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; }
        // Root
        result.add(node.val);
        // Left
        preorder(node.left, result);
        // Right
        preorder(node.right, result);   }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = preorderTraversal(root);
        System.out.println("Preorder Traversal:");
        System.out.println(result);
    }
}