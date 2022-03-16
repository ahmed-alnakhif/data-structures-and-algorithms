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
        String strSequence = "";
        for (int num : sequence) {
            strSequence += num;
        }

        return preOrderDFS(root, "", strSequence);
    }

    private boolean preOrderDFS(TreeNode root, String currPath, String sequence) {
        if (root == null) return false;

        currPath += root.val;

        if (isLeafNode(root) && currPath.equals(sequence)) {
            return true;
        }

        return preOrderDFS(root.left, currPath, sequence) || preOrderDFS(root.right, currPath, sequence);
    }

    private boolean findPathRecursive(TreeNode root, int[] sequence, int index) {

        if (root == null) return false;
    
        if (index >= sequence.length || root.val != sequence[index]) return false;
    
        // if the current node is a leaf, add it is the end of the sequence, we have found a path!
        if (isLeafNode(root) && index == sequence.length - 1) return true;
    
        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return findPathRecursive(root.left, sequence, index + 1)
            || findPathRecursive(root.right, sequence, index + 1);
      }

    private boolean isLeafNode(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        
    }
}
