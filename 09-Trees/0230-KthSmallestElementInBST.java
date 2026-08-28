import java.util.Stack;
class KthSmallestElementInBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val; }   }
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            // Go as far left as possible
            while (current != null) {
                stack.push(current);
                current = current.left; }
            // Visit the next smallest element
            current = stack.pop();
            k--;
            if (k == 0) {
                return current.val; }
            // Move to the right subtree
            current = current.right;    }   }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int k = 3;
        int result = kthSmallest(root, k);
        System.out.println("Kth Smallest Element: " + result);
    }
}