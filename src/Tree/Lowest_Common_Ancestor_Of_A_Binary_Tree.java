package Tree;

public class Lowest_Common_Ancestor_Of_A_Binary_Tree {

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

        if (root == null ||root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

}
