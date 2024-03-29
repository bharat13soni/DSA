package com.practice.map;

public class MyHashMap {

    // Here we are using double hashing technique

    // I created this class to store value of the key and we can create 2D array of this class
    static class HashValue {
        int val;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    // created an array to store key value
    HashValue[][] storage;
    int bucketSize;
    int bucketItemsSize;

    public MyHashMap() {
        // we will provide primary and secondary array size and initialize a primary array with it's given size
        bucketSize = 1000;
        bucketItemsSize = 1000;
        storage = new HashValue[bucketSize][];
    }

    // hash function to get index in primary array
    public int getBucket(int key) {
        return key % bucketSize;
    }

    // hash function to get index in secondary array which is in one the index pos of primary array
    public int getBucketItem(int key) {
        return key / bucketItemsSize;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        // if index in primary array does not contain sec array then initialize it with sec array of given size
        if (storage[bucket] == null) {
            // condition to address edge case
            if (bucket == 0)
                storage[bucket] = new HashValue[bucketItemsSize + 1];
            else
                storage[bucket] = new HashValue[bucketItemsSize];
        }
        HashValue hv = new HashValue();
        hv.setVal(value);

        // inserting hash value at desired position
        storage[bucket][bucketItem] = hv;
    }

    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        // if value not found then return -1
        if (storage[bucket] == null || storage[bucket][bucketItem] == null)
            return -1;

        // return found value
        HashValue hv = storage[bucket][bucketItem];
        return hv.getVal();
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        // if value not found then return
        if (storage[bucket] == null || storage[bucket][bucketItem] == null)
            return;

        // if key found then assign it to null (remove)
        storage[bucket][bucketItem] = null;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);

        System.out.println("value for key 1 -> " + map.get(1));
        System.out.println("value for key 2 -> " + map.get(2));
        map.remove(2);
        System.out.println("value for key 2 -> " + map.get(2));
    }
}
