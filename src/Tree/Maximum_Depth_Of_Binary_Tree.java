package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Depth_Of_Binary_Tree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
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


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            while (size > 0) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                size--;
            }
        }
        return depth;
    }

}
