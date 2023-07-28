package com.practice;

public class pro1 {
    public static void main(String[] args) {
        System.out.println(countHillValley1(new int[]{2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5}));
    }
    public static int countHillValley(int[] nums) {
        int ans = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length-1; i++){
            if((nums[i] > nums[i+1] && nums[i] > prev || (nums[i] < nums[i+1] && nums[i] < prev)))
                ans++;
            if(nums[i] != nums[i+1]){
                prev = nums[i];
            }
        }
        return ans;
    }
    public static int countHillValley1(int[] nums) {
        int ans = 0;
        int left = nums[0];

        for (int i = 1; i + 1 < nums.length; ++i)
            if (left < nums[i] && nums[i] > nums[i + 1] || // Hill
                    left > nums[i] && nums[i] < nums[i + 1]) { // Valley
                ++ans;
                left = nums[i];
            }

        return ans;
    }
}
