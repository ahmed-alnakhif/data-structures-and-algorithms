package Problems.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 */

public class BinaryTreeRightSideView {
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

    List<TreeNode> duplicateList = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    List<Integer> list = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        traverse(root, 1);
        return list;
    }

    private void traverse(TreeNode root, int depth) {
        if (root == null)
            return;

        if (depth > list.size()) {
            list.add(root.val);
        }

        traverse(root.right, depth + 1);
        traverse(root.left, depth + 1);
    }

    public void run() {

    }
}
