package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Lowest_Common_Ancestor_Of_A_Binary_Search_Tree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
