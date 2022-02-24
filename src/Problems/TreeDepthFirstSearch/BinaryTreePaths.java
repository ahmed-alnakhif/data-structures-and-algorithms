package Problems.TreeDepthFirstSearch;

import java.util.LinkedList;
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

    List<String> result = new LinkedList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        preOrderDFS(root);
        return result;
    }

    private void preOrderDFS(TreeNode root) {
        if (root == null) return;

        list.add(String.valueOf(root.val));

        if (isLeafNode(root)) {
            result.add(serialize(list));
        } else {
            preOrderDFS(root.left);
            preOrderDFS(root.right);
        }

        list.removeLast();
    }

    private boolean isLeafNode(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }

    private String serialize(List<String> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
            if (i + 1 != list.size()) {
                str += "->";
            }
        }
        return str;
    }
}
