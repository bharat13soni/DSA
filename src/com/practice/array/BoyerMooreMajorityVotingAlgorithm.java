package com.practice.array;

/*
When the elements are the same as the candidate element -> votes are incremented
when some other element is found not equal to the candidate element -> We decreased the count.
This actually means that we are decreasing the priority of winning ability of the selected candidate,
since we know that if the candidate is a majority it occurs more than N/2 times and the remaining elements are less than N/2.
We keep decreasing the votes since we found some different element than the candidate element.
When votes become 0, this actually means that there are the same number of different elements,
which should not be the case for the element to be the majority element.
So the candidate element cannot be the majority, so we choose the present element as the candidate
and continue the same till all the elements get finished.
The final candidate would be our majority element. We check using the 2nd traversal to see whether its count is greater than N/2.
If it is true, we consider it as the majority element.
*/
public class BoyerMooreMajorityVotingAlgorithm {

    /*
    Input :{1,1,1,1,2,3,5}
    Output : 1
    Explanation : 1 occurs more than 3 times.
    Input : {1,2,3}
    Output : -1
    */
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 3, 4};
        int majority = findMajority(arr);
        System.out.println(" The majority element is : "
                + majority);
    }

    // Function to find majority element
    public static int findMajority(int[] nums) {
        int count = 1;
        int ansIndex = 0;

        // Finding majority candidate
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[ansIndex])
                count++;
            else
                count--;

            if (count == 0) {
                ansIndex = i;
                count = 1;
            }
        }

        // Checking if majority ansIndex occurs more than
        // n/2 times
        count = 0;
        for (int num : nums) {
            if (num == nums[ansIndex])
                count++;
        }
        if (count > (nums.length / 2))
            return nums[ansIndex];
        return -1;
    }
}
