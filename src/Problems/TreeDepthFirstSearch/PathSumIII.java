package Problems.TreeDepthFirstSearch;

import java.util.HashMap;

/**
 * Given the root of a binary tree and an integer targetSum, return the number
 * of paths where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 */

public class PathSumIII {
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

    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0, 1);
        subPathSumDFS(root, 0, targetSum);
        return count;
    }

    private void subPathSumDFS(TreeNode root, int currSum, int targetSum) {
        if (root == null) return;

        currSum += root.val;

        if (map.containsKey(currSum - targetSum)) {
            count += map.get(currSum - targetSum);
        }

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        subPathSumDFS(root.left, currSum, targetSum);
        subPathSumDFS(root.right, currSum, targetSum);

        // decrement current sum, so it doesn't affect other subtrees paths
        map.put(currSum, map.get(currSum) - 1);
    }
}
