package leetcode;

public class leet104 {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int leftDepth = root.left != null ? maxDepth(root.left) : 0;
        int rightDepth = root.right != null ? maxDepth(root.right) : 0;

        return Math.max(leftDepth, rightDepth) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
