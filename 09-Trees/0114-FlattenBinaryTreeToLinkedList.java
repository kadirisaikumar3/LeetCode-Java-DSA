class FlattenBinaryTreeToLinkedList {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
}
        flatten(root.left);
        flatten(root.right);
        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;
        // Move left subtree to the right
        root.left = null;
        root.right = leftSubtree;
        // Find the end of the new right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        // Attach original right subtree
        current.right = rightSubtree;
    }
    private static void printFlattenedTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        System.out.println("Flattened Binary Tree:");
        printFlattenedTree(root);
    }
}