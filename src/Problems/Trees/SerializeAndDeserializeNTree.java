package Problems.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */

public class SerializeAndDeserializeNTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public String serialize(Node root) {
        String result = serializeBFS(root);
        return result;
    }

    public Node deserialize(String data) {
        if (data.length() == 0)
            return null;
        System.out.println(data);
        String[] levelOrderArr = data.split(",");
        return deserializeBFS(levelOrderArr);
    }

    private String serializeBFS(Node root) {
        if (root == null) return "";

        StringBuilder strBuilder = new StringBuilder();
        Queue<Node> queue = new LinkedList<Node>();
        strBuilder.append(String.valueOf(root.val));

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node child : node.children) {
                queue.add(child);
                strBuilder.append("," + child.val);
            }

            strBuilder.append(",#");
        }

        return strBuilder.toString();
    }

    private Node deserializeBFS(String[] arr) {
        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(Integer.parseInt(arr[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            List<Node> children = new LinkedList<>();
            while (!arr[i].equals("#")) {
                Node child = new Node(Integer.parseInt(arr[i]));
                children.add(child);
                queue.add(child);
                i++;
            }
            i++;
            parent.children = children;
        }

        return root;
    }

    public void run() {

    }
}
