package com.practice.array;

public class NoOfPairsDivByK {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 7, 5, 3};
        int n = 6;
        int k = 4;
        long countKdivPairs = countKdivPairs(arr, n, k);
        System.out.println("countKdivPairs ->" + countKdivPairs);
    }

    public static long countKdivPairs(int arr[], int n, int k) {
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by k
        int freq[] = new int[k];

        // Count occurrences of all remainders
        for (int i = 0; i < n; i++)
            ++freq[arr[i] % k];

        //case:1 If both pairs are divisible by 'k' there reminder is 0 => sum=N(N-1)/2 here N=freq(0)
        int sum = freq[0] * (freq[0] - 1) / 2;

        //case:2 count for all i and (k-i) starting from i=1
        // freq pairs where R1 != R2 here R1 = i and R2 = k-i
        for (int i = 1; i <= k / 2 && i != (k - i); i++)
            sum += freq[i] * freq[k - i];

        //case:3 If k is even then N=freq[k/2]
        if (k % 2 == 0)
            sum += (freq[k / 2] * (freq[k / 2] - 1) / 2);
        return sum;
    }

    /* bruete force approach Complexity O(n2) */
    public static long countKdivPairs1(int arr[], int n, int k) {
        long count = 0;
        int j = 0;
        while (j < n) {
            for (int i = j + 1; i < n; i++) {
                if ((arr[j] + arr[i]) % k == 0) {
                    count++;
                }
            }
            j++;
        }
        return count;
    }
}
