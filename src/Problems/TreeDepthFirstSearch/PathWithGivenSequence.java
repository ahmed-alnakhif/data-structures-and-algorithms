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

    public boolean findPath(TreeNode root, int[] sequence) {
        return dfs(root, sequence, 0);
    }

    private boolean dfs(TreeNode root, int[] seq, int index){
        if(root == null) return false;
        if(seq[index] != root.val) return false;
        if(index == seq.length-1 && !isLeafNode(root)) return false;
        if(index == seq.length-1) return true;
        
        return dfs(root.left, seq, index + 1) || dfs(root.right, seq, index + 1);
      }

    private boolean isLeafNode(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        
    }
}
