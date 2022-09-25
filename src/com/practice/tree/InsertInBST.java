package com.practice.tree;

public class InsertInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.data) {
            root.left = insertIntoBST(root.left, val);
        }
        if (val > root.data) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
