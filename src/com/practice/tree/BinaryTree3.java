package com.practice.tree;

public class BinaryTree3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        System.out.println(diameterOfBinaryTree(root));
    }

    //O(N2)
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int dLeft = diameterOfBinaryTree(root.left);
        int dRight = diameterOfBinaryTree(root.right);
        int curr = height(root.left) + height(root.right) + 1;
        return Math.max(curr, Math.max(dLeft, dRight));
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }



}
