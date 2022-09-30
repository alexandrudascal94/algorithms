package HashTable;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * 1. Use a HaspMap to find the frequency
 * 2. After that put all keys in maxHeap by comparing the frequency from HashMap
 * 3. return the k elements from the minHeap
 *
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) ->Integer.compare(frequencyMap.get(b), frequencyMap.get(a)));

        for(int num: nums){
            int frequency = frequencyMap.getOrDefault(num, 0);
            frequency++;
            frequencyMap.put(num, frequency);
        }

        for(int num : frequencyMap.keySet()){
            maxHeap.add(num);
        }

        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = maxHeap.poll();
        }
        return answer;
    }

}
