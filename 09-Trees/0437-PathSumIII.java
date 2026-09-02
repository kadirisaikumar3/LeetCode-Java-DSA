import java.util.HashMap;
import java.util.Map;

class PathSumIII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int pathSum(TreeNode root, int targetSum) {

        Map<Long, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0L, 1);

        return dfs(root, 0L, targetSum, prefixSum);
    }

    private static int dfs(TreeNode node,
                           long currentSum,
                           int targetSum,
                           Map<Long, Integer> prefixSum) {

        if (node == null) {
            return 0;
        }

        currentSum += node.val;

        // Check whether a previous prefix sum creates targetSum
        long requiredSum = currentSum - targetSum;

        int count = prefixSum.getOrDefault(requiredSum, 0);

        prefixSum.put(
                currentSum,
                prefixSum.getOrDefault(currentSum, 0) + 1
        );

        count += dfs(node.left, currentSum, targetSum, prefixSum);
        count += dfs(node.right, currentSum, targetSum, prefixSum);

        // Backtrack
        prefixSum.put(
                currentSum,
                prefixSum.get(currentSum) - 1
        );

        return count;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        int targetSum = 8;

        int result = pathSum(root, targetSum);

        System.out.println("Number of Paths: " + result);
    }
}