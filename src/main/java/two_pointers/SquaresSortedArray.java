package two_pointers;

/**
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 */

public class SquaresSortedArray {

    public int[] sortedSquares(int[] numbers) {
        int[] result = new int[numbers.length];
        int start = 0;
        int end = numbers.length - 1;
        int insertP = end;

        while (start < end){
            int startSquare = numbers[start] * numbers[start];
            int endSquare = numbers[end] * numbers[end];

            if(startSquare > endSquare){
                result[insertP] = startSquare;
                start++;
            }
            else{
                result[insertP] = endSquare;
                end--;
            }
            insertP--;
        }
        return result;
    }

}
