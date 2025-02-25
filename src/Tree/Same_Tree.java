package Tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Same_Tree {

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

    public String bfs(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            sb.append(depth);
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    sb.append(node.left.val).append("l");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sb.append(node.right.val).append("r");
                }
                size--;
            }
        }
        return sb.toString();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {


        return bfs(p).equals(bfs(q));

    }

}
