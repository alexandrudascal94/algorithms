package dynamic_programing;

public class MaxNonAdjacentSubsetSum {

    /**
     * There is unsorted integer array, return a maximum sum of non adjacent elements.
     *
     * example>
     * [5, 20, 15, -2, 18] => 20 + 18 = 38
     * [4, 1, 6, 3, 2] => 4 + 6 + 2 = 12
     *
     * Solution:
     * 1. If we create a array of the same length and store all previous maxSums
     * 2. The new sum on position i will be, newSum = Max(previous, prePrevious + currentNumber)
     * 3. here is teh formula sum[i] = max(sum[i - 1], sum[i - 2] + num[i]);
     * 4. If we observe we always use only last 2 numbers, maybe we can use them instead of an array.
     * 6. first = sum[i-1], second = sum[i - 2]
     *
     *
     * similar to https://leetcode.com/problems/house-robber/
     */

    // time - O(N)
    // space - O(N)
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];

        int[] maxSums = new int[array.length];

        maxSums[0] = array[0];
        maxSums[1] = Math.max(maxSums[0], array[1]);

        for(int i = 2; i < array.length; i++){
            maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]);
        }

        return maxSums[array.length - 1];
    }

    // time - O(N)
    // space - O(1)
    public static int maxSubsetSumNoAdjacent2(int[] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];

        int second = array[0];
        int first = Math.max(second, array[1]);

        for(int i = 2; i < array.length; i++){
            int newMax = Math.max(first, second + array[i]);
            second = first;
            first = newMax;
        }

        return first;
    }
}
