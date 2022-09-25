package com.practice.tree;

public class SearchInBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.data == val) {
            return root;
        }
        if (root.data < val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }

    public static TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null) {
            if (root.data == val) return root;
            root = root.data < val ? root.right : root.left;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode node = searchBSTIterative(root, 2);
        System.out.println(node);
    }
}
