package Problems.TreeDepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * 
 * A leaf is a node with no children.
 * 
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 */

public class BinaryTreePaths {
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

    List<String> allPaths = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return allPaths;
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        int originalLength = path.length();

        path.append(root.val);

        if (isLeafNode(root)) {
            allPaths.add(path.toString());
        } else {
            path.append("->");
        }

        dfs(root.left);
        dfs(root.right);

        // backtrack to the previous path
        path.setLength(originalLength);
    }

    private boolean isLeafNode(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        
    }
}
