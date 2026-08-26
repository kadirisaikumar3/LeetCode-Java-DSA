import java.util.ArrayList;
import java.util.List;

class BinaryTreePostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;  }
    private static void postorder(TreeNode node,List<Integer> result) {
        if (node == null) {
            return; }
        // Left
        postorder(node.left, result);
        // Right
        postorder(node.right, result);
        // Root
        result.add(node.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = postorderTraversal(root);
        System.out.println("Postorder Traversal:");
        System.out.println(result);
    }
}