/*
https://www.hackerrank.com/challenges/anagram/problem
 */

import java.util.HashMap;

public class Anagram {

    // [a,c,c,s,c,a]
    // first word -> key: char; value: incrise the number
    // second word -> key: char; value: decrise
    //xaxbbbxx
    // x -> 0
    // a -> 1
    // b -> -1

    //TODO
    public static int anagram(String s) {
        if(s.length() % 2 != 0){
            return -1;
        }
        var chars = s.toCharArray();
        var charMap = new HashMap<Character, Integer>();

        for (int i = 0; i < chars.length/2; i++){
            if(charMap.containsKey(chars[i])){
                charMap.put(chars[i], charMap.get(chars[i]) + 1);
            }else {
                charMap.put(chars[i], 1);
            }
        }

        for (int i = chars.length/2; i < chars.length; i++){
            if(charMap.containsKey(chars[i])){
                charMap.put(chars[i], charMap.get(chars[i]) - 1);
            }
        }

        var charsToChange = 0;
        for (var value: charMap.values()){
                charsToChange+= value;
        }

        return charsToChange == 0 ? -1 : charsToChange;
    }
}
