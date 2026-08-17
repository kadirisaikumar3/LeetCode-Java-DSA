class SubtreeOfAnotherTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;        } }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;    }
        if (root == null) {
            return false;   }
        if (isSameTree(root, subRoot)) {
            return true;    }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);  }
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;    }
        if (p == null || q == null) {
            return false;   }
        if (p.val != q.val) {
            return false;   }
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        boolean result = isSubtree(root, subRoot);
        System.out.println("Is Subtree: " + result); } }