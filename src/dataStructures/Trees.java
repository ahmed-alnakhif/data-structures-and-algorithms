package dataStructures;

import java.util.List;

public class Trees {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static class BinaryTree {
        Node root;

        private Node insertRecursive(Node curr, int value) {
            if (curr == null) {
                return new Node(value);
            }

            if (value <= curr.data) {
                curr.left = insertRecursive(curr.left, value);
            } else if (value > curr.data) {
                curr.right = insertRecursive(curr.right, value);
            }

            return curr;
        }

        public void insert(int value) {
            this.root = insertRecursive(this.root, value);
        }

        private Node deleteRecursive(Node curr, int value) {
            if (curr == null) {
                return null;
            }

            if (value == curr.data) {
                // 1) has no children (leaf node)
                if (curr.left == null && curr.right == null) {
                    return null;
                }

                // 2) has only one child
                if (curr.left == null) {
                    return curr.right;
                }

                if (curr.right == null) {
                    return curr.left;
                }

                // 3 has 2 children => find smallest value in the right sub-tree and assign it
                // to the root value
                int smallestValue = findSmallestValue(curr.right);
                curr.data = smallestValue;
                curr.right = deleteRecursive(curr.right, smallestValue);
            }

            if (value <= curr.data) {
                curr.left = deleteRecursive(curr.left, value);
            }

            if (value > curr.data) {
                curr.right = deleteRecursive(curr.right, value);
            }

            return curr;
        }

        public void delete(int value) {
            this.root = deleteRecursive(this.root, value);
        }

        private int findSmallestValue(Node root) {
            return root.left == null ? root.data : findSmallestValue(root.left);
        }

        public boolean contains(Node curr, int value) {
            if (curr == null) {
                return false;
            }

            if (curr.data == value) {
                return true;
            }

            return value < curr.data
                    ? contains(curr.left, value)
                    : contains(curr.right, value);
        }

        public Node initializeTree(int[] arr) {
            for (int value : arr) {
                insert(value);
            }
            return this.root;
        }

        public void inOrderTraversal(Node curr) {
            if (curr != null) {
                inOrderTraversal(curr.left);
                System.out.print(curr.data + ", ");
                inOrderTraversal(curr.right);
            }
        }

        public void preOrderTraversal(Node curr) {
            if (curr != null) {
                System.out.print(curr.data + ", ");
                preOrderTraversal(curr.left);
                preOrderTraversal(curr.right);
            }
        }

        public void postOrderTraversal(Node curr) {
            if (curr != null) {
                postOrderTraversal(curr.left);
                postOrderTraversal(curr.right);
                System.out.print(curr.data + ", ");
            }
        }

        public void run() {
            int[] arr = { 8, 4, 12, 3, 7, 9, 14 };
            initializeTree(arr);
            inOrderTraversal(this.root);
        }
    }

}
