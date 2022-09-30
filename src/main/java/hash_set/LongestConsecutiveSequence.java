package hash_set;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    /**
     * https://leetcode.com/problems/longest-consecutive-sequence/
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     *
     * You must write an algorithm that runs in O(n) time.
     * Example 1:
     *
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * Solution:
     * 1. A sequence is a list of consecutive numbers
     * 2. In order to know if a sequence starts, we need to know if there is a previous element.
     *
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> numbersSet = new HashSet<>();
        for (int number: nums){
            numbersSet.add(number);
        }

        int maxSeq = 1;
        for(int num: nums){
            int currSeq = 1;
            // is a new sequence
            if(!numbersSet.contains(num - 1)){
                int potentialNextNumber = num + 1;

                while(numbersSet.contains(potentialNextNumber)){
                    currSeq++;
                   // numbersSet.remove(potentialNextNumber);
                    potentialNextNumber++;
                }
            }
            maxSeq = Math.max(maxSeq, currSeq);
        }
        return maxSeq;
    }
}
