package Problems.Trees;

/**
 * Given two nodes of a binary tree p and q, return their lowest common ancestor
 * (LCA).
 * 
 * Each node will have a reference to its parent node. The definition for Node
 * is below:
 * 
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node parent;
 * }
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor
 * of two nodes p and q in a tree T is the lowest node that has both p and q as
 * descendants (where we allow a node to be a descendant of itself).
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 */

public class LCAInBinaryTreeIII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    //Time: O(H), Space: O(N)
    public Node lowestCommonAncestor(Node p, Node q) {
        Node currP = p, currQ = q;
        while(currP != currQ){
            currP = currP.parent == null ? q : currP.parent;
            currQ = currQ.parent == null ? p : currQ.parent;
        }
        return currP; 
    }

    // Time: O(H) Space: O(N)
    public Node lowestCommonAncestor2(Node p, Node q) {
        Node root = p;
        
        while(root.parent != null){
            root = root.parent;
        }
        
        return LCA(root, p, q);
    }
    
    public Node LCA(Node root, Node p, Node q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        
        Node left = LCA(root.left, p, q);
        Node right = LCA(root.right, p, q);
        
        if(left == null && right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

}
