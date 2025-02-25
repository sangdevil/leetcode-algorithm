package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Validate_Binary_Search_Tree {

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

    public boolean validate(TreeNode node, long lower_bound, long higher_bound) {
        if (node == null) return true;
        if (node.val <= lower_bound || node.val >= higher_bound) return false;

        return validate(node.left, lower_bound , Math.min(higher_bound, node.val))
                && validate(node.right, Math.max(lower_bound, node.val), higher_bound);
    }

    public boolean isValidBST(TreeNode root) {


        return validate(root.left, Long.MIN_VALUE, root.val) && validate(root.right, root.val, Long.MAX_VALUE);


    }

}
