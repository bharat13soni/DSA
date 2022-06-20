package com.practice.sorting;

public class ArraySorting {
    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Array before bubbleSort..");
        printArray(arr);
        bubbleSort(arr);
        System.out.println("Array after bubbleSort..");
        printArray(arr);

        arr = new int[]{12, 11, 13, 5, 6};
        System.out.println("Array before insertionSort..");
        printArray(arr);
        insertionSort(arr);
        System.out.println("Array after insertionSort..");
        printArray(arr);

        arr = new int[]{12, 11, 13, 5, 6};
        System.out.println("Array before selectionSort..");
        printArray(arr);
        selectionSort(arr);
        System.out.println("Array after selectionSort..");
        printArray(arr);

        arr = new int[]{12, 11, 13, 5, 6};
        System.out.println("Array before quickSort..");
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Array after quickSort..");
        printArray(arr);

        arr = new int[]{12, 11, 13, 5, 6};
        System.out.println("Array before mergeSort..");
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Array after mergeSort..");
        printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < arr.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //If swapping is required then swap
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }

    /* This function takes first element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, j, low);
        return j;
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[pi]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    // Merges two sub-arrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] left = new int[n1];
        int[] right = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second sub-arrays
        int i = 0;
        int j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        /* Copy remaining elements of left[] if any */
        while (i < n1) {
            arr[k++] = left[i++];
        }

        /* Copy remaining elements of right[] if any */
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    // Main function that sorts arr[l..r] using merge
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr) {
        for (int j : arr)
            System.out.print(j + " ");

        System.out.println();
    }
}
