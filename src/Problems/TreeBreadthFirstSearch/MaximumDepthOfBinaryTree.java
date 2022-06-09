package Problems.TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 */

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

public class MaximumDepthOfBinaryTree {
    // bfs
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        int minDepth = 0;

        queue.add(root);

        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return minDepth;
    }


    //dfs
    int max = 0;
    
    public int maxDepthDFS(TreeNode root) {
        dfs(root, 0);
        return max;
    }
    
    private void dfs(TreeNode root, int depth){
        if(root == null) return;
        
        depth += 1;
        
        max = Math.max(max, depth);
        
        dfs(root.left, depth);
        dfs(root.right, depth);
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maxDepth = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth.maxDepthBFS(root));
        System.out.println(maxDepth.maxDepthDFS(root));
    }
}
