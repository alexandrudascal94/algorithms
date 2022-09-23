import java.util.HashMap;
import java.util.PriorityQueue;

public class HashMap_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // use a hashMap first
        // 0 - number, 1 - frequancy
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else{
                int freq = map.get(num) + 1;
                map.put(num, freq);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) ->{
            return Integer.compare(map.get(b), map.get(a));
        });

        for(int entry: map.keySet()){
            minHeap.add(entry);
        }

        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = minHeap.poll();
        }
        return answer;
    }

}
