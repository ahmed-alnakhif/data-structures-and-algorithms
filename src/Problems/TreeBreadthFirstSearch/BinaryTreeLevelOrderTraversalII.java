package Problems.TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the bottom-up level order traversal
 * of its nodes' values. (i.e., from left to right, level by level from leaf to
 * root).
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 */

public class BinaryTreeLevelOrderTraversalII {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return levels;

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                level.add(node.val);
            }
            levels.addFirst(level);
        }

        return levels;
    }

    public static void main(String[] args) {
        
    }
}
