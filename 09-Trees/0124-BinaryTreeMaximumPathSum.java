class BinaryTreeMaximumPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    private static int maxSum;
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;  }
    private static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;   }
        // Ignore negative contributions
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));
        // Path passing through the current node
        int currentPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPath);
        // Return the maximum one-side contribution
        return node.val + Math.max(leftGain, rightGain);    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int result = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result);
    }
}