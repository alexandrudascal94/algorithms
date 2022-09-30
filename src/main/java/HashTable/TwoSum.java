package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/***
 * //https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 */
public class TwoSum {

    // Complexity O(n)
    public int[] twoSum2(int[] nums, int target) {

        var set = new HashSet<Integer>();

        for(int num: nums){
            // 5 - 2 = 3
            var potentialMatch = target - num;
            if(set.contains(potentialMatch)){
                return new int[]{num, potentialMatch};
            }
            else{
                // add the number for forward checks
                set.add(num);
            }
        }
        return new int[0];
    }
}
