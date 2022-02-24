package Problems.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given the root of a binary tree, return all duplicate subtrees.
 * 
 * For each kind of duplicate subtrees, you only need to return the root node of
 * any one of them.
 * 
 * Two trees are duplicate if they have the same structure with the same node
 * values.
 */

public class FindDuplicateSubtrees {
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrderDFS(root);
        return duplicateList;
    }

    private String postOrderDFS(TreeNode root) {
        if (root == null) return "null";

        String left = postOrderDFS(root.left);
        String right = postOrderDFS(root.right);
        String curr = left + "," + right + ","+ root.val;

        map.put(curr, map.getOrDefault(curr, 0) + 1);

        if (map.get(curr) == 2) {
            duplicateList.add(root);
        }

        return curr;
    }

    public void run() {

    }
}
