package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Subtree_Of_Another_Tree {

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

        long merkle;
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

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return root == subRoot;

        if (root.val != subRoot.val) return false;

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

}
