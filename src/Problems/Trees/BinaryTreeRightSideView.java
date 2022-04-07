package Problems.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 */

public class BinaryTreeRightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // using BFS
    public List<Integer> rightSideView(TreeNode root) {        
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null) return list;
        
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                
                //last node in the level
                if(i+1 == size) list.add(node.val);
            }
        }
        
        return list;
    }


    // using DFS
    List<Integer> rightSideList = new LinkedList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        postDFS(root, 1);
        return rightSideList;
    }
    private void postDFS(TreeNode root, int level) {
        if (root == null) return;

        if (level > rightSideList.size()) {
            rightSideList.add(root.val);
        }

        postDFS(root.right, level + 1);
        postDFS(root.left, level + 1);
    }

    public static void main(String[] args) {
        
    }
}
