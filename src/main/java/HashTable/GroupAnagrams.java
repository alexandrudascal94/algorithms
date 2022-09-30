package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Solution:
 *
 * 1. Find what is unique in each word, if two anagrams sorted they will be the same words
 * 2. Use a HashMap with sorted word as key.
 *  sortedWord : [ word1, word2 ]
 *
 */
public class GroupAnagrams {

    // time O(N * KlongK) k -the word length
    // space O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if(map.containsKey(key)){
                List<String> list = map.get(key);
                list.add(word);
                map.put(key, list);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(word);
                map.put(key, list);
            }
        }
        return new ArrayList(map.values());
    }

    public List<List<String>> groupAnagramsOption2(String[] strs) {
        // 1. each word can have max 26 chars
        // 2. if we create a string counting how many of each chars teh word has and   use as a key
        // 3. Build the key for each word and add it in the hash

        HashMap<String, ArrayList<String>> anagramsMap = new HashMap<>();

        for(String str: strs){
            int[] keyChars = new int[26];
            Arrays.fill(keyChars, '0');

            // chars 65 - 90
            int firstChar = 65;
            char[] strChars = str.toCharArray();
            for(char c: strChars){
                int charIdx = (int)Character.toUpperCase(c) - firstChar;
                keyChars[charIdx] = keyChars[charIdx] + 1;
            }

            String key = Arrays.toString(keyChars);
            ArrayList<String> anagrams = anagramsMap.getOrDefault(key, new ArrayList<String>());
            anagrams.add(str);
            anagramsMap.put(key, anagrams);
        }
        return new ArrayList(anagramsMap.values());

    }
}
