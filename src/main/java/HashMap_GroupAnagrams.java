import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashMap_GroupAnagrams {
    // use hashMap, key -> sorted word
    //
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
        //return map.values().stream().collect(Collectors.toList());
    }
}
