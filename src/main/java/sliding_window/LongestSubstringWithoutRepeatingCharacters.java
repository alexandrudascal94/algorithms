package sliding_window;

import java.util.HashSet;

/***
 *https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Solution:
 * 1. Use a sliding window (start, end) to check the size and store the max
 * 2. Use a set to know if the char is already part of the substring.
 * 3. When the char is already present shrink the window start++, do this till the char is not present
 * 4. If the char is not present, increase the window end++
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int end = 0;
        int start = 0;

        int max = 0;

        HashSet<Character> substring = new HashSet<Character>();
        while(end < s.length()){
            char currentChar = s.charAt(end);
            if(!substring.contains(currentChar)){
                substring.add(currentChar);
                end++;
                max = Math.max(substring.size(), max);
            }
            else{
                substring.remove(s.charAt(start));
                start++;
            }

        }
        return max;
    }
}
