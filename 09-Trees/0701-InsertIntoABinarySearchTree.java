class InsertIntoABinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }   }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);   }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);    }

        return root;    }
    private static void inorder(TreeNode root) {
        if (root == null) {
            return; }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int value = 5;
        root = insertIntoBST(root, value);
        System.out.println("Inorder Traversal After Insertion:");
        inorder(root);
    }
}