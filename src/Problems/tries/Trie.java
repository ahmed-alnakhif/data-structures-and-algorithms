package Problems.tries;

class Node {
    char c;
    boolean isWord;
    Node[] children;

    Node(char c) {
        this.c = c;
        isWord = false;
        children = new Node[26];
    }
}

public class Trie {

    private Node root;

    public Trie() {
        this.root = new Node('#');
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }

    public static void main(String[] args) {

    }
}
