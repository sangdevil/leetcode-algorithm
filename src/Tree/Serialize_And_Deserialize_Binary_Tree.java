package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_And_Deserialize_Binary_Tree {

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

        TreeNode(int val) {
            this.val = val;
        }

    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("#,");
                } else {
                    sb.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            System.out.println(sb.toString());
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) {
                return null;
            }
            String[] nodeStringList = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodeStringList[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            for (int i = 1; i < nodeStringList.length; i++) {
                TreeNode parent = queue.poll();
                if (!nodeStringList[i].equals("#")) {
                    TreeNode left = new TreeNode(Integer.parseInt(nodeStringList[i]));
                    queue.offer(left);
                    parent.left = left;
                }
                i++;
                if (!nodeStringList[i].equals("#")) {
                    TreeNode right = new TreeNode(Integer.parseInt(nodeStringList[i]));
                    queue.offer(right);
                    parent.right = right;
                }
            }
            return root;
        }
    }

}
