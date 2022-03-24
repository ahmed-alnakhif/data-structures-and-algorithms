package Problems.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the vertical order traversal of its
 * nodes' values. (i.e., from top to bottom, column by column).
 * 
 * If two nodes are in the same row and column, the order should be from left to
 * right.
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
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

class Pair {
    TreeNode node;
    Integer col;

    Pair(TreeNode node, Integer col) {
        this.node = node;
        this.col = col;
    }
}


public class BinaryTreeVerticalOrder {
   

    //T: O(N), S: O(N)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        int col = 0, min = 0, max = 0;

        queue.offer(new Pair(root, col));
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            col = pair.col;

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, col + 1));
            }

            min = Math.min(min, col);
            max = Math.max(max, col);
        }

        for (int i = min; i <= max; i++) {
            output.add(map.get(i));
        }

        return output;
    }

}
