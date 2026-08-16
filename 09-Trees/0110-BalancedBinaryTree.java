class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val; } }
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; }
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; }
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        boolean result = isBalanced(root);
        System.out.println("Is the tree balanced? " + result);
    }
}