package com.practice.tree;

import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        ArrayDeque<TreeNode> dq = new ArrayDeque<>();

        if (root != null)
            dq.addLast(root);

        while (!dq.isEmpty()) {

            int level = dq.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode n = dq.removeFirst();
                curr.add(n.data);

                if (n.left != null) {
                    dq.addLast(n.left);
                }
                if (n.right != null) {
                    dq.addLast(n.right);
                }
            }

            res.add(curr);
        }


        return res;


    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            map.computeIfAbsent(pair.horizontalDistance, k -> new ArrayList<>()).add(pair.node.data);
            if (pair.node.left != null) {
                queue.add(new Pair(pair.horizontalDistance + 1, pair.node.left));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.horizontalDistance + 1, pair.node.right));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrder(root);
        res.forEach(integers -> {
            integers.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });
    }
}


