import java.util.ArrayList;
import java.util.List;

class BinaryTreeInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    private static void inorder(TreeNode node,List<Integer> result) {
        if (node == null) {
            return; }
        // Left
        inorder(node.left, result);
        // Root
        result.add(node.val);
        // Right
        inorder(node.right, result);    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = inorderTraversal(root);
        System.out.println("Inorder Traversal:");
        System.out.println(result);
    }
}