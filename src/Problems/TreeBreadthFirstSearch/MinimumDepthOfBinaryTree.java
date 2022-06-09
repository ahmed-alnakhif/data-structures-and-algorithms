package Problems.TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 */

public class MinimumDepthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        int minDepth = 0;

        queue.add(root);

        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isLeafNode(node)) return minDepth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return minDepth;
    }

    //DFS
    int min = Integer.MAX_VALUE;
    public int minDepthDFS(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return min;
    }
    
    private void dfs(TreeNode root, int depth){
        if(root == null) return;
        
        depth+=1;
        
        if(isLeafNode(root)){
            min = Math.min(min, depth);
        }
        
        dfs(root.left, depth);
        dfs(root.right, depth);
    }

    private boolean isLeafNode(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        
    }
}
