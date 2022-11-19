package com.practice.tree;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * <p>
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountNoOfNodesInCompleteBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        int nodes = countNodes(root);
        System.out.println("Total nodes -> " + nodes);
    }

    /**
     * Naive Approach: The simple approach to solve the given tree is to perform the DFS Traversal on the given tree
     * and count the number of nodes in it. After traversal, print the total count of nodes obtained.
     * <p>
     * Time Complexity: O(N) as in traversal all the nodes are visited
     * Auxiliary Space: O(1)
     * <p>
     * Efficient Approach: A complete binary tree can have at most (2^h – 1) nodes in total
     * where h is the height of the tree (This happens when all the levels are completely filled).
     * <p>
     * Follow the steps below to solve the problem:
     * <p>
     * 1) Define a function left_height(root) and find the left height of the given Tree by traversing in the root’s left direction and store it in a variable, say leftHeight.
     * 2) Define a function right_height(root) and find the right height of the given Tree by traversing in the root’s right direction and store it in a variable, say rightHeight.
     * 3) Find the left and the right height of the given Tree for the current root value and if it is equal then return the value of (2^height – 1) as the resultant count of nodes.
     * 4) Otherwise, recursively call for the function for the left and right sub-trees and return the sum of them + 1 as the resultant count of nodes.
     */

    public static int countNodes(TreeNode root) {
        // Base Case
        if (root == null)
            return 0;

        // Find the left height and the
        // right heights
        int lh = leftHeight(root);
        int rh = rightHeight(root);

        // If left and right heights are
        // equal return 2^height(1<<height) -1
        if (lh == rh)
            return (1 << lh) - 1;

        // Otherwise, recursive call
        return 1 + countNodes(root.left)
                + countNodes(root.right);
    }

    private static int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private static int rightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
