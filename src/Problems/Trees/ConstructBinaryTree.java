package Problems.Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
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

    Map<Integer, Integer> inorderIndexMap;
    int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }

    public void printInOrder(TreeNode root) {
        if (root == null) return;

        printInOrder(root.left);
        System.out.print(root.val + ", ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTree c = new ConstructBinaryTree();
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
        TreeNode root = c.buildTree(preorder, inorder);

        c.printInOrder(root);
    }
}
