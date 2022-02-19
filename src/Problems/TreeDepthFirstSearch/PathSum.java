package Problems.TreeDepthFirstSearch;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the
 * tree has a root-to-leaf path such that adding up all the values along the
 * path equals targetSum.
 * 
 * A leaf is a node with no children
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 */

public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return preOrderDFS(root, 0, targetSum);
    }

    private boolean preOrderDFS(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;

        sum += root.val;

        // sum = target AND is leaf node
        if (root.left == null && root.right == null && sum == targetSum) {
            return true;
        }

        return preOrderDFS(root.left, sum, targetSum) || preOrderDFS(root.right, sum, targetSum);
    }
}
