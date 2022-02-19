package Problems.TreeDepthFirstSearch;

/**
 * Given a binary tree and a number sequence, find if the sequence is present as
 * a root-to-leaf path in the given tree.
 * 
 * 
 * Sequence: [1, 9, 9]
 * Output: true
 * Explanation: The tree has a path 1 -> 9 -> 9
 * 
 * Sequence: [1, 0, 7]
 * Output: false
 * Explanation: The tree does not have a path 1 -> 0 -> 7
 */

public class PathWithGivenSequence {
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

    public static boolean findPath(TreeNode root, int[] sequence) {
        String strSequence = "";
        for (int num : sequence) {
            strSequence += num;
        }

        return preOrderDFS(root, "", strSequence);
    }

    private static boolean preOrderDFS(TreeNode root, String currPath, String sequence) {
        if (root == null) return false;

        currPath += root.val;

        if (root.left == null && root.right == null && currPath.equals(sequence)) {
            return true;
        }

        return preOrderDFS(root.left, currPath, sequence) || preOrderDFS(root.right, currPath, sequence);

    }
}
