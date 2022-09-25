package com.practice.array;

import java.util.*;
import java.util.stream.Collectors;

public class FindTripletsWithZeroSum {
    public static void main(String[] args) {
//        int[] arr = {0, -1, 2, -3, 1};
        int[] arr = {4, -16, 43, 4, 7, -36, 18};
//        int triplets = findTripletsUsingHashing(arr, arr.length);
//        System.out.println("res ->" + threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println("res ->" + threeSum(new int[]{0,0,0,0}));
        System.out.println("res ->" + threeSum(new int[]{3,0,-2,-1,1,2}));
//        System.out.println("triplets =" + triplets);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> threeSum = new HashSet<>();
        
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    threeSum.add(temp);
                    j++;
                    k--;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        
        return new ArrayList<>(threeSum);
    }

    //Time Complexity: O(n^2). Auxiliary Space: O(n).
    static int findTripletsUsingHashing(int[] arr, int n) {
        int tripletsCount = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                int x = -(arr[i] + arr[j]);
                if (set.contains(x)) {
                    tripletsCount++;
                } else {
                    set.add(arr[j]);
                }
            }
        }
        return tripletsCount;
    }

    static boolean findTriplets3(int[] arr, int n) {
        boolean found = false;
        // sort array elements
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(arr[l] + " ");
                    System.out.print(arr[r] + " ");

                    l++;
                    r--;
                    found = true;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero then
                    // decrement in right side
                else
                    r--;
            }
        }
        return found;
    }

    static int findTriplets(int[] arr, int n) {
        int tripletsCount = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        tripletsCount++;
                    }
                }
            }
        }
        return tripletsCount;
    }
}
