import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _UsefulTips {
    public static void main(String[] args) {
        // hashMap functions:
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.get(1);
        map.containsKey(1);
        new ArrayList<>(map.entrySet());
        Map.Entry<Integer, Integer> mapEntry;

        List<Map.Entry<Integer, Integer>> groups = new ArrayList(mp.entrySet());
        map.entrySet();
        map.values();

        Arrays.fill(dp,1);


        //PriorityQueue

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) ->  Integer.compare(y, x));
        maxHeap.poll(); //return head and removes
        maxHeap.peek(); // retunr head

        //Stiings
        String.valueOf(new char[]{'a','b'}); //creates string from chars
        Character.isAlphabetic();
        Character.isDigit();
        Character.isUpperCase();
        (int) 'a'
    }
}
