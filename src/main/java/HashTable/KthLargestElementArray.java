package HashTable;

import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 *
 */
public class KthLargestElementArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int n : nums) {

            // will put all elements in a maxHeap
            maxHeap.add(n);

            // if we need the Kth element, we always remove the elements that are K+
            // this will make it easier to return the Kth at the end
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }

    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> y - x);

        for (int n : nums) {

            // will put all elements in a maxHeap
            minHeap.add(n);

            // if we need the Kth element, we always remove the elements that are K+
            // this will make it easier to return the Kth at the end
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}
