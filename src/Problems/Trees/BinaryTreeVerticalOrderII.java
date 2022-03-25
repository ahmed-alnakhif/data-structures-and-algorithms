package Problems.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of
 * the binary tree.
 * 
 * For each node at position (row, col), its left and right children will be at
 * positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of
 * the tree is at (0, 0).
 * 
 * The vertical order traversal of a binary tree is a list of top-to-bottom
 * orderings for each column index starting from the leftmost column and ending
 * on the rightmost column. There may be multiple nodes in the same row and same
 * column. In such a case, sort these nodes by their values.
 * 
 * Return the vertical order traversal of the binary tree
 * 
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 * 1 is at the top, so it comes first.
 * 5 and 6 are at the same position (2, 0), so we order them by their value, 5
 * before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 */



public class BinaryTreeVerticalOrderII {
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
    
    class Node {
        TreeNode node;
        int row;
        int col;
    
        Node(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    // T: O(N*log(N)), S: O(N)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        Map<Integer, List<Node>> colMap = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        int min = 0, max = 0;

        queue.offer(new Node(root, 0, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (!colMap.containsKey(curr.col)) {
                colMap.put(curr.col, new ArrayList<>());
            }
            colMap.get(curr.col).add(curr);

            if (curr.node.left != null) queue.offer(new Node(curr.node.left, curr.row + 1, curr.col - 1));
            if (curr.node.right != null) queue.offer(new Node(curr.node.right, curr.row + 1, curr.col + 1));

            min = Math.min(min, curr.col);
            max = Math.max(max, curr.col);
        }

        for (int i = min; i <= max; i++) {
            List<Node> colNodes = new ArrayList<>(colMap.get(i));

            Collections.sort(colNodes, (a, b) -> a.row == b.row ? a.node.val - b.node.val : a.row - b.row);

            List<Integer> colValues = new ArrayList<>();
            for (Node node : colNodes) {
                colValues.add(node.node.val);
            }
            output.add(colValues);
        }

        return output;
    }

}
