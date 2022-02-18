package Problems.TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its
 * children is 2, and so on.
 * 
 * Return the smallest level x such that the sum of all the values of nodes at
 * level x is maximal.
 * 
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 */

public class MaximumLevelSumOfBinaryTree {
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

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return 0;

        int max = Integer.MIN_VALUE;
        int level = 0, maxLevel = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                sum += node.val;
            }
            if(sum > max){
                max = sum;
                maxLevel = level;
            }
        }

        return maxLevel;  
    }

    public void run() {

    }
}
