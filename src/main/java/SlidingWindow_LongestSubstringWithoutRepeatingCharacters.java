import java.util.HashSet;

public class SlidingWindow_LongestSubstringWithoutRepeatingCharacters {
    // 1. take element by element
    // build the substring in a Set
    // if the element we process exists we remove the first element
    // if by removing the substring is valid we continue
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

    public static void main(String[] args) {
        System.out.println( "sdfs".substring(0,2));
    }
}
