package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {

//https://www.hackerrank.com/challenges/find-the-running-median/problem
    public static List<Double> runningMedian(List<Integer> a) {
        ArrayList<Double> result = new ArrayList<>();
        // for second half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for first half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, b) -> {
            return Integer.compare(b, x);
        });


        // we should keep the heams the same size;
        // e.g.
        // 12, 4, 5, 3, 8
        // minHeap 3, 4,
        // maxheap 12, 5
        // both empty return 12
        // imbalanced balance
        // odd return max from minHeap
        // add 3, balance

        for(int num : a){
            // add the numebr in teh right heap;
            if(!maxHeap.isEmpty() && maxHeap.peek() > num){
                maxHeap.add(num);
            }
            else if(!minHeap.isEmpty() && minHeap.peek() <= num){
                minHeap.add(num);
            }
            else{
                maxHeap.add(num);
            }
            //normilize the heaps
            int difference = maxHeap.size() - minHeap.size();

            if(maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.poll());
            }
            else if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.add(minHeap.poll());
            }

            double median = 0.0;
            if(minHeap.size() > maxHeap.size()){
                median = minHeap.peek() + 0.0;
            }
            else if(minHeap.size() < maxHeap.size()){
                median = maxHeap.peek() + 0.0;
            }
            else{
                median = (minHeap.peek() + maxHeap.peek() + 0.0) / 2;
            }
            result.add(median);

        }

        return result;
    }

}
