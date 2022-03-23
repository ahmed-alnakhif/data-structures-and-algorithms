package Problems.Trees;

/**
 * Given the root of a binary tree, return the lowest common ancestor (LCA) of
 * two given nodes, p and q. If either node p or q does not exist in the tree,
 * return null. All values of the nodes in the tree are unique.
 * 
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor
 * of two nodes p and q in a binary tree T is the lowest node that has both p
 * and q as descendants (where we allow a node to be a descendant of itself)". A
 * descendant of a node x is a node y that is on the path from node x to some
 * leaf node.
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
 * Output: null
 * Explanation: Node 10 does not exist in the tree, so return null.
 */

public class LCAInBinaryTreeII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Time: O(N) Space: O(N)
    boolean pFound = false, qFound = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return pFound && qFound ? LCA : null;
    }
    
    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        if(root == p){
            pFound = true;
            return root;
        }
        
        if(root == q){
            qFound = true;
            return root;
        }
        
        
        if(left == null && right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        return root; 
    }
}
