package com.practice.tree;

public class BinaryTree1
{
    TreeNode root;
    // head --> Pointer to head node of created doubly linked list
    TreeNode head;
    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static TreeNode prev = null;

    public static void main(String[] args)
    {
        // Let us create the tree as shown in above diagram
        BinaryTree1 tree = new BinaryTree1();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(25);
        tree.root.left.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(36);

        // convert to DLL
        tree.binaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);

    }

    // A simple recursive function to convert a given Binary tree
    // to Doubly Linked List
    // root --> Root of Binary Tree
    public void binaryTree2DoubleLinkedList(TreeNode root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        binaryTree2DoubleLinkedList(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        binaryTree2DoubleLinkedList(root.right);
    }

    /* Function to print nodes in a given doubly linked list */
    void printList(TreeNode node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }


}
