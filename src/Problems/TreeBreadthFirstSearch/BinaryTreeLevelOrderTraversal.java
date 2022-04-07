package Problems.TreeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */

public class BinaryTreeLevelOrderTraversal {
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

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                level.add(node.val);
            }
            levels.add(level);
        }

        return levels;
    }

    // dfs
    List<List<Integer>> levels;

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        levels = new ArrayList<>();
        dfs(root, 0);
        return levels;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;

        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {

    }
}
