package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Maximum_Path_Sum {

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

    public int maxVal = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int funVal = root.val + left + right;
        maxVal = Math.max(maxVal, funVal);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return maxVal;
    }

}
