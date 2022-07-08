package com.practice.tree;

import java.util.HashSet;
import java.util.Set;

public class BST {
    public static Node deleteNode(Node root, int key) {
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

    private static int minValue(Node root) {
        int minVal = root.data;
        while (root.left != null) {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

    public static boolean isBSTUsingRange(Node root) {
        return isBSTUtil(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean isBSTUtil(Node root, int maxValue, int minValue) {
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
    Node prev;

    public boolean isBSTUsingInOrderTraversal(Node root) {
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
    public static int floor(Node root, int key) {
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

    public static int ceil(Node root, int key) {
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
    public static int isPairPresent(Node root, int target) {
        Set<Integer> set = new HashSet<>();
        return util(root, target, set) ? 1 : 0;
    }

    private static boolean util(Node root, int sum, Set<Integer> set) {
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
