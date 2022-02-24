package Problems.TreeDepthFirstSearch;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all
 * root-to-leaf paths where the sum of the node values in the path equals
 * targetSum. Each path should be returned as a list of the node values, not
 * node references.
 * 
 * A root-to-leaf path is a path starting from the root and ending at any leaf
 * node. A leaf is a node with no children.
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 */

public class PathSumII {
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

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preOrderDFS(root, 0, targetSum);
        return result;
    }

    private void preOrderDFS(TreeNode root, int sum, int targetSum) {
        if (root == null) return;

        sum += root.val;

        list.add(root.val);

        if (isLeafNode(root) && sum == targetSum) {
            result.add(new LinkedList<>(list));
        } else {
            preOrderDFS(root.left, sum, targetSum);
            preOrderDFS(root.right, sum, targetSum);
        }

        list.removeLast();
    }

    private boolean isLeafNode(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }
}
