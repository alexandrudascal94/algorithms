package arrays;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementArray {

    public int findKthLargest(int[] nums, int k) {
        // max heap
        // https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
        // Time Complexity O(LogN)
        // Space Complexity O(n)
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int n: nums){

            // will put all elements in a maxHeap
            q.add(n);

            // if we need the Kth element, we always remove the elements that are K+
            // this will make it easier to return the Kth at the end
            if(q.size() > k){
                q.poll();
            }
        }

        return q.poll();
    }

    public int findKthSmallest(int[] nums, int k) {
        // max heap
        // https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> y - x);

        for(int n: nums){

            // will put all elements in a maxHeap
            q.add(n);

            // if we need the Kth element, we always remove the elements that are K+
            // this will make it easier to return the Kth at the end
            if(q.size() > k){
                q.poll();
            }
        }

        return q.poll();
    }
}
