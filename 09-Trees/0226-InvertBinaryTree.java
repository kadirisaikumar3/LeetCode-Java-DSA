class InvertBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val; }  }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null; }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root; }
    public static void printTree(TreeNode root) {
        if (root == null) {
            return; }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right); }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println("Original Tree (Preorder):");
        printTree(root);
        invertTree(root);
        System.out.println();
        System.out.println("Inverted Tree (Preorder):");
        printTree(root); } }