package Problems.TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the next
 * level and alternate between).
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 */

public class BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return levels;

        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (reverse) {
                    level.addFirst(node.val);
                } else {
                    level.add(node.val);
                }
            }

            levels.add(level);
            reverse = !reverse;
        }

        return levels;
    }

    public static void main(String[] args) {
        
    }
}
