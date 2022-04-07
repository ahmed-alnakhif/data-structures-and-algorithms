package Problems.TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following
 * definitio
 * 
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function
 * should populate each next pointer to point to its next right node, just like
 * in Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 */

public class PopulatingNextRightPointers {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if (root == null) return root;

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) node.next = queue.peek(); // point to the next node in the same level
                if (node.left != null)  queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return root;
    }

    public void run() {

    }
}
