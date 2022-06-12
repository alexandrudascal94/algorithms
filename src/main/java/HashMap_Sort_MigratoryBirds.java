import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMap_Sort_MigratoryBirds {
    // https://www.hackerrank.com/challenges/migratory-birds/problem

    // [1,1,2,2,3] -> 1
// 1: 2
// 2: 2
// 3: 1
    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int element:  arr){
            if(mp.containsKey(element)){
                mp.put(element, mp.get(element) + 1);
            }else{
                mp.put(element, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> groups = new ArrayList(mp.entrySet());
        Collections.sort(groups, (a, b) ->{
            int result = Integer.compare(a.getValue(), b.getValue());
            if(result == 0){
                return Integer.compare(b.getKey(), a.getKey());
            }
            return result;
        });

        return groups.get(groups.size() - 1).getKey();
    }

}
