package com.practice.tree;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        int remaining = k - root.data;
        if (set.contains(remaining)) {
            return true;
        }
        set.add(root.data);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        boolean target = new TwoSumBST().findTarget(root, 9);
        System.out.println("target ->" + target);
    }
}
