package com.practice.tree;

import java.util.HashSet;
import java.util.Set;

public class BST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private static int minValue(TreeNode root) {
        int minVal = root.data;
        while (root.left != null) {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

    public static boolean isBSTUsingRange(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(TreeNode root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if (root.data < minValue || root.data > maxValue)
            return false;

        return isBSTUtil(root.left, minValue, root.data - 1) &&
                isBSTUtil(root.right, root.data + 1, maxValue);
    }

    /*
    For BST inorder traversal should be sorted
     */
    TreeNode prev;

    public boolean isBSTUsingInOrderTraversal(TreeNode root) {
        if (root != null) {
            if (!isBSTUsingInOrderTraversal(root.left))
                return false;

            if (prev != null && root.data <= prev.data)
                return false;

            prev = root;
            isBSTUsingInOrderTraversal(root.right);
        }
        return true;
    }

    /*
    Floor of a key in BST
    The Largest value in BST which is smaller than key
     */
    public static int floor(TreeNode root, int key) {
        int ans = Integer.MAX_VALUE;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            }
            if (root.data > key) {
                root = root.left;
            } else {
                ans = root.data;
                root = root.right;
            }
        }
        return ans;
    }

    public static int ceil(TreeNode root, int key) {
        int ans = Integer.MIN_VALUE;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            }
            if (root.data > key) {
                ans = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }

    /*
    Find pair with given target sum in BST
     */
    public static int isPairPresent(TreeNode root, int target) {
        Set<Integer> set = new HashSet<>();
        return util(root, target, set) ? 1 : 0;
    }

    private static boolean util(TreeNode root, int sum, Set<Integer> set) {
        if (root == null)
            return false;
        if (util(root.left, sum, set)) {
            return true;
        }
        if (set.contains(sum - root.data)) {
            return true;
        }
        set.add(root.data);
        return util(root.right, sum, set);
    }
}
