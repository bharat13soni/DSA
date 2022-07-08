package com.practice.tree;

import java.util.*;

public class BinaryTree3 {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        System.out.println(diameterOfBinaryTree(root));
    }

    //O(N2)
    public static int diameterOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        int dLeft = diameterOfBinaryTree(root.left);
        int dRight = diameterOfBinaryTree(root.right);
        int curr = height(root.left) + height(root.right) + 1;
        return Math.max(curr, Math.max(dLeft, dRight));
    }

    private static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public Node lowestCommonAncestor(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;

        Node left = lowestCommonAncestor(root.left, n1, n2);
        Node right = lowestCommonAncestor(root.right, n1, n2);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

}
