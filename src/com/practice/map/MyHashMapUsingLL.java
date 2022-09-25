package com.practice.map;

public class MyHashMapUsingLL {

    // Here we are using separate chaining method using LinkedList

    // create a Node class for LinkedList
    static class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // create an array of LL nodes which will contain head of LL
    int buckets;
    Node[] storage;

    public MyHashMapUsingLL() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    // hash function for finding bucket (index) in primary array
    private int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }

    // find method to traverse a LL in selected bucket
    private Node find(Node dummy, int key) {
        Node prev = dummy;
        Node cur = dummy.next;

        while (prev.next != null && prev.next.key != key) {
            prev = cur;
            cur = cur.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);

        // if bucket is empty then create a new node(head) of LL at that index in primary array
        if (storage[bucket] == null) {
            // initiate a LL with a dummy node
            // we will pass this node in find method
            storage[bucket] = new Node(-1, -1);
        }

        // find the respective node with key
        Node prev = find(storage[bucket], key);

        // if key not found then insert at end else update the existing value
        if (prev.next == null)
            prev.next = new Node(key, value);
        else
            prev.next.value = value;
    }

    public int get(int key) {
        int bucket = getBucket(key);

        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }

        Node prev = find(storage[bucket], key);

        // if key not found return -1 as asked
        if (prev.next == null)
            return -1;

        return prev.next.value;
    }

    public void remove(int key) {
        int bucket = getBucket(key);

        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }

        Node prev = find(storage[bucket], key);

        // if not found return
        if (prev.next == null)
            return;

        // if found remove the key by changing next pointer of prev node
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }

    public static void main(String[] args) {
        MyHashMapUsingLL map = new MyHashMapUsingLL();
        map.put(1, 10);
        map.put(2, 20);

        System.out.println("value for key 1 -> " + map.get(1));
        System.out.println("value for key 2 -> " + map.get(2));
        map.remove(2);
        System.out.println("value for key 2 -> " + map.get(2));
    }
}
