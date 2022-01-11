
/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Input: s = "the sky is blue"
Output: "blue is sky the"

 */
public class ReverseWordsInStringII {

    // 1. split the string
    // 2. I reverse the array, or can create directly the String/StringBuilder

    public String reverseWords(String s) {
        var words = s.split("\\s+");
        var result = new StringBuilder();
        for(int i = words.length - 1;  i >= 0 ; i--){
            if(i == 0) {
                result.append(words[i].trim());
            }
            else {
                result.append(words[i].trim() + " ");
            }

        }
        return result.toString();
    }
}
