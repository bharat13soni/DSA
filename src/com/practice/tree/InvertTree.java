package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public Node invertTree(Node root) {
        if (root == null) {
            return root;
        }
        /* do the subtrees */
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        /* swap the left and right pointers */
        root.left = right;
        root.right = left;

        return root;
    }

    public static void mirror(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Do BFS. While doing BFS, keep swapping
        // left and right children
        while (q.size() > 0) {
            // pop top node from queue
            Node curr = q.peek();
            q.remove();

            // swap left child with right child
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // push left and right children
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }
}
