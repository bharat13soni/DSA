package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    public static boolean hasPathSumIterative(Node root, int targetSum) {
        if (root == null) return false;

        Queue<GenericPair<Node, Integer>> q = new LinkedList<>();
        q.offer(new GenericPair<>(root, targetSum - root.data));

        while (!q.isEmpty()) {
            GenericPair<Node, Integer> curr = q.poll();
            Node node = curr.getLeft();
            Integer sum = curr.getRight();
            if (sum == 0 && node.left == null && node.right == null)
                return true;

            if (node.left != null)
                q.offer(new GenericPair<>(node.left, sum - node.left.data));

            if (node.right != null)
                q.offer(new GenericPair<>(node.right, sum - node.right.data));
        }
        return false;
    }

    public static boolean hasPathSum(Node root, int targetSum) {
        if (root == null)
            return false;

        if (targetSum - root.data == 0 && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, targetSum - root.data)
                || hasPathSum(root.right, targetSum - root.data);
    }

    public static void main(String[] args) {
        int sum = 21;
 
        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        if (hasPathSum(root, sum))
            System.out.println(
                    "There is a root to leaf path with sum "
                            + sum);
        else
            System.out.println(
                    "There is no root to leaf path with sum "
                            + sum);
    }
}
