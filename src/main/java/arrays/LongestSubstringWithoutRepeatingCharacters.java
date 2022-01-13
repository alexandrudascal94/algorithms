package arrays;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    // buuild a substring by adding chars
    // abcabcbb
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0;
        int j = 0;

        HashSet<Character> set = new HashSet<Character>();
        while(i < s.length()){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                i++;
                max = Math.max(set.size(), max);
            }
            else{
                set.remove(s.charAt(j));
                j++;
            }

        }
        return max;
    }
}
