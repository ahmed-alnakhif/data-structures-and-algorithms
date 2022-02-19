package Problems.TreeDepthFirstSearch;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * 
 * Each root-to-leaf path in the tree represents a number.
 * 
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so
 * that the answer will fit in a 32-bit integer.
 * 
 * 
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 */

public class SumRootToLeafNumbers {
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

    int totalSum = 0;
    
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return totalSum;
    }

    private void sumNumbers(TreeNode root, int sum) {
        if (root == null) return;

        sum = sum*10 + root.val;
        
        if (root.left == null && root.right == null) {
            totalSum+= sum;
        }
            
        sumNumbers(root.left, sum);
        sumNumbers(root.right, sum);
    }
}
