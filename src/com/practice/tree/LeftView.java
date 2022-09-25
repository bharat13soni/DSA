package com.practice.tree;

import java.util.HashMap;

public class LeftView {
    // traverse nodes in pre-order way
    public static void leftViewUtil(TreeNode root, int level, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        // if you are visiting the level for the first time
        // insert the current node and level info to the map
        if (!map.containsKey(level)) {
            map.put(level, root.data);
        }
        leftViewUtil(root.left, level + 1, map);
        leftViewUtil(root.right, level + 1, map);
    }

    // to print left view of binary tree
    public static void leftView(TreeNode root) {
        // create an empty HashMap to store first node of each level
        HashMap<Integer, Integer> map = new HashMap<>();
        // traverse the tree and find out the first nodes of each level
        leftViewUtil(root, 1, map);
        // iterate through the HashMap and print the left view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(9);
        leftView(root);
        //output -> 4,2,1,9
    }
}
