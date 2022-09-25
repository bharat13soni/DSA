package com.practice.tree;

public class IsValidBST {
    /**
     * A Valid BST must be satisfied all root.left values are less than root.val
     * && all root.right values are greater than root.val.
     * <p>
     * In order words, there is a must condition to set: max > root.val > min
     * <p>
     * As traversing the left tree nodes, the maximum value is root.val,
     * none of the left tree nodes' value could be greater than root.val.
     * <p>
     * Similarly, as traversing the right tree nodes, the minimum value is root.val,
     * none of the right tree nodes' value could be less than root.val.
     */
    public static boolean isValidBST(TreeNode root) {
        return isBSTUtil(root, null, null);
    }

    public static boolean isBSTUtil(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        if (min != null && root.data <= min.data) return false;
        if (max != null && root.data >= max.data) return false;

        return isBSTUtil(root.left, min, root)
                && isBSTUtil(root.right, root, max);
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);*/
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean validBST = isValidBST(root);
        System.out.println("validBST ->" + validBST);
    }
}
