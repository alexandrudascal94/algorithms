package trees;

import java.sql.SQLOutput;

public class ToPointers_MinSwapToMakePalindrome {
    /*
    https://www.geeksforgeeks.org/count-minimum-swap-to-make-string-palindrome/
        Input: aabcb
        Output: 3
        Explanation:
        After 1st swap: abacb
        After 2nd swap: abcab
        After 3rd swap: abcba
     */

    public static void main(String[] args) {
        System.out.println(mingSwapToPalindrome("aabcb"));
    }

    private static int mingSwapToPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        char[] chars = input.toCharArray();
        int swaps = 0;

        // keep two pointers right and left, side,
        // to make the string palindrome the chars on this position must be the same
        while (left < right) {

            // keep the left pointer, and look for the same char starting form right side, use a pointer r
            // swap with the right pointer when is found
            int r = right;
            char leftChar = chars[left];
            while (leftChar != chars[r]) {

                while (left < r) {
                    char swapCandidate = chars[r];
                    if (leftChar == swapCandidate) {
                        chars[r] = chars[right];
                        chars[right] = swapCandidate;
                        swaps++;
                        break;
                    }
                    r--;
                }
                if (left == r) {
                    char toSwap = chars[r + 1];
                    chars[r + 1] = chars[r];
                    chars[r] = toSwap;
                    swaps++;
                }
            }
            left++;
            right--;
        }
        return swaps;
    }
}
