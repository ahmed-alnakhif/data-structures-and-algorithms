package Problems.Trees;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */

public class SerializeAndDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeDFS(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserializeDFS(nodes);
    }

    private String serializeDFS(TreeNode root) {
        if (root == null) return "null";

        String left = serializeDFS(root.left);
        String right = serializeDFS(root.right);

        return root.val + "," + left + "," + right;

    }
    
    private int index = 0;
    private TreeNode deserializeDFS(String[] nodes) {
        if (nodes[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        root.left = deserializeDFS(nodes);
        root.right = deserializeDFS(nodes);

        return root;
    }

    public static void main(String[] args) {
        
    }
}
