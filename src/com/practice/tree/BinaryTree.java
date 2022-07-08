package com.practice.tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.topView(tree.root);
    }

    private void topView(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        if (root == null) {
            return;
        }
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (!map.containsKey(current.horizontalDistance)) {
                map.put(current.horizontalDistance, current.node);
            }

            if (current.node.left != null) {
                queue.add(new Pair(current.horizontalDistance - 1,
                        current.node.left));
            }
            if (current.node.right != null) {
                queue.add(new Pair(current.horizontalDistance + 1,
                        current.node.right));
            }
        }

        for (Map.Entry<Integer, Node> entry :
                map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    /*
    This method will print vertical Order traversal Of Binary Tree using level order traversal
     */
    public static List<Integer> verticalOrderOfBinaryTree(Node root) {
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            map.computeIfAbsent(curr.horizontalDistance, K -> new ArrayList<>()).add(curr.node.data);

            if (curr.node.left != null) {
                queue.add(new Pair(curr.horizontalDistance - 1, curr.node.left));
            }

            if (curr.node.right != null) {
                queue.add(new Pair(curr.horizontalDistance + 1, curr.node.right));
            }
        }
        List<Integer> ans = new ArrayList<>();
        map.forEach((key, value) -> ans.addAll(value));
        return ans;
    }
}

class Pair {
    int horizontalDistance;
    Node node;

    public Pair(int horizontalDistance, Node node) {
        this.horizontalDistance = horizontalDistance;
        this.node = node;
    }
}
