package dynamic_programing;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

    A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
    the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].=
    https://leetcode.com/problems/longest-increasing-subsequence/
     */

    //[0,3,1,6,2,2,7]
    //[1,2,2,   ]
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }

        int[] dp = new int[nums.length];
        int max = 1;
        // each element is an 1 length sunsequance
        Arrays.fill(dp,1);


        for(int i = 1; i < nums.length; i++){
            // for each element we will check previus subsequance
            for(int j = 0; j < i; j++){
                //build the subsequzance from j = 0, j - current element
                // if the subs increses we calcualte the length
                if(nums[i] > nums[j]){

                    // DINAMIC PROGRAMING, we take the biggest previous subsequance or incrising the current one
                    dp[i] = Math.max(dp[j] + 1 , dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
