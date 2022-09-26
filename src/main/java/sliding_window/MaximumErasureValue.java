package sliding_window;

import java.util.HashSet;

// https://leetcode.com/problems/maximum-erasure-value/

/***
 * Problem:
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements.
 * The score you get by erasing the subarray is equal to the sum of its elements.
 *
 * Return the maximum score you can get by erasing exactly one subarray.
 *
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a,
 * that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 *
 * a subsequence made up of consecutive elements
 *
 * Example 1:
 *
 Example 2:
 Input: nums = [5,2,1,2,5,2,1,2,5]
 Output: 8
 Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 *
 * Solution:
 * 1. Use a Set to store the current subarray HashSet
 * 2. Use a sliding window do find the elements.
 * 3. When the number[end] is the Set, shrink the window start++
 * 4. When the number is in the Set, expend the window end++
 * 5. Whenever the new number repeat, the window will shrink till the element is not part of the Set.
 *
 * e.g. sub = [5, 2, 1 ]
 * add 5, add 2, add 1, try add 2 -> remove
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        HashSet<Integer> subArray = new HashSet<Integer>();

        int maxScore = 0;
        int currentScore = 0;

        while(end < nums.length){
            int newNumber = nums[end];
            if(subArray.contains(newNumber)){
                // remove the first number and shrink the window
                // this will shrink till the new element will not repeat
                subArray.remove(nums[start]);
                currentScore-=nums[start];
                start++;
            }else{
                // extend the window with new element
                currentScore+=nums[end];
                subArray.add(nums[end]);
                end++;
            }
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
}
