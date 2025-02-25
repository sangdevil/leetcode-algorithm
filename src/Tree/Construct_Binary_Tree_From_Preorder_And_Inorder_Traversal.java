package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int[] seq = new int[6001];

        int current_seq = 0;
        for (int i = 0; i < inorder.length; i++) {
            seq[inorder[i] + 3000] = current_seq++;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode before = new TreeNode(preorder[0]);
        stack.push(before);
        TreeNode ret = before;

        for (int i = 1; i < preorder.length; i++) {
            if (seq[before.val + 3000] > seq[preorder[i] + 3000]) {
                TreeNode left = new TreeNode(preorder[i]);
                before.left = left;
                stack.push(left);
                before = left;
            } else {
                while (!stack.isEmpty() && seq[stack.peek().val + 3000] < seq[preorder[i] + 3000]) {
                    before = stack.pop();
                }
                TreeNode right = new TreeNode(preorder[i]);
                before.right = right;
                stack.push(right);
                before = right;
            }
        }

        return ret;

    }

}
