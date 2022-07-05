package com.practice.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        System.out.println(binarySearchIterative(arr, 110));
        System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 110));

        int[] rotatedArr = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int key = 3;
        System.out.println("searchInSortedRotatedArray -> " + searchInSortedRotatedArray(rotatedArr,key));
    }

    public static int binarySearchIterative(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {        // key is on the right side
                low = mid + 1;
            } else {                            // key is on the left side
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int key) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid]) {
                return mid;
            }
            if (key > arr[mid]) {        // key is on the right side
                return binarySearchRecursive(arr, mid + 1, high, key);
            }
            return binarySearchRecursive(arr, low, mid - 1, key);
        }
        return -1;
    }

    /*
    Find an element in sorted infinite array
     */
    public static int searchInfinite(int[] arr, int key) {
        int low = 0;
        int high = 1;
        while (arr[high] < key) {
            low = high;
            //check that 2*h doesn't exceed array
            //length to prevent ArrayOutOfBoundException
            if (2 * high < arr.length - 1)
                high = 2 * high;
            else
                high = arr.length - 1;
        }
        return binarySearchRecursive(arr, low, high, key);
    }

    /*
    Search an element in a sorted and rotated array
    1) Find middle point mid = (low + high)/2
    2) If key is present at middle point, return mid.
    3) Else If arr[low..mid] is sorted
        a) If key to be searched lies in range from arr[low]
           to arr[mid], recur for arr[low..mid].
        b) Else recur for arr[mid+1..high]
    4) Else (arr[mid+1..high] must be sorted)
        a) If key to be searched lies in range from arr[mid+1]
           to arr[high], recur for arr[mid+1..high].
        b) Else recur for arr[low..mid]
     */
    public static int searchInSortedRotatedArray(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == key)
            return mid;

        /* If arr[low...mid] first subarray is sorted */
        if (arr[low] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[low] && key <= arr[mid])
                return searchInSortedRotatedArray(arr, low, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return searchInSortedRotatedArray(arr, mid + 1, high, key);
        }

        /* If arr[low..mid] first subarray is not sorted,
           then arr[mid... high] must be sorted subarray*/
        if (key >= arr[mid] && key <= arr[high])
            return searchInSortedRotatedArray(arr, mid + 1, high, key);

        return searchInSortedRotatedArray(arr, low, mid - 1, key);
    }

    public static int searchInSortedRotatedArray(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            //left part is sorted
            if (arr[low] < arr[mid]) {
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {                     //right part is sorted
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
