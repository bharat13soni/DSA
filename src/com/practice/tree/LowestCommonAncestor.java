package com.practice.tree;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, n1, n2);
        TreeNode right = lowestCommonAncestor(root.right, n1, n2);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.data < p.data && root.data < q.data)
//             right call
            return lowestCommonAncestor(root.right, p, q);

        if (root.data > p.data && root.data > q.data)
//             left call
            return lowestCommonAncestor(root.left, p, q);

        return root;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode treeNode = lowestCommonAncestor(root, 2, 4);
        TreeNode treeNode1 = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println("lowestCommonAncestor ->" + treeNode.data);
        System.out.println("lowestCommonAncestor1 ->" + treeNode1.data);
    }
}
