package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
//Use map to count the frequancy o(n)
    //Use PriorityQueue for

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(String w: words){
            if(map.containsKey(w)){
                map.put(w, map.get(w) + 1);
            }else{
                map.put(w, 1);
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<String>((a,b) ->{
            int frequancyA = map.get(a);
            int frequancyB = map.get(b);

            if(frequancyA == frequancyB){
                return b.compareTo(a);
            }
            else{
                return frequancyA - frequancyB;
            }
        });

        for(String w : map.keySet()){
            minHeap.add(w);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<String> answer = new ArrayList<String>();
        for(int i = 0; i < k; i++){
            answer.add(minHeap.poll());
        }
        Collections.reverse(answer);

        return answer;
    }
}
