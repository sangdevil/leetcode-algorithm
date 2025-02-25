package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Kth_Smallest_Element_In_A_BST {

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

    public static int ret = 0;
    public static int count = 0;

    public void dfs(TreeNode node) {
        if (node.left != null) dfs(node.left);
        count--;
        if (count == 0) {
            ret = node.val;
            return;
        }
        if (node.right != null) dfs(node.right);
    }
    public int kthSmallest(TreeNode root, int k) {

        count = k;
        dfs(root);

        return ret;
    }


}
