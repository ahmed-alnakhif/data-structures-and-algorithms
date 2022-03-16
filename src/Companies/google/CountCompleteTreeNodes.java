package Companies.google;

/**
 * Given the root of a complete binary tree, return the number of the nodes in
 * the tree.
 * 
 * According to Wikipedia, every level, except possibly the last, is completely
 * filled in a complete binary tree, and all nodes in the last level are as far
 * left as possible. It can have between 1 and 2h nodes inclusive at the last
 * level h.
 * 
 * Design an algorithm that runs in less than O(n) time complexity.
 */

public class CountCompleteTreeNodes {
    class TreeNode {
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

    //T: O(N), S:(log(N))
    int count;
    public int countNodes(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        count += 1;

        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        
    }
}
