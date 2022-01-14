package arrays;

import java.util.PriorityQueue;

public class KClosestPointsOrigin_usingHeap {
    // https://leetcode.com/problems/k-closest-points-to-origin/

    // we will use a maxHeap to store the first K elements
    // th maxHeap will use the formula for comparing;
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<int[]>((a, b) ->  distanceFromOrigin(b) - distanceFromOrigin(a));

        for(int i = 0; i < points.length; i++){
            maxHeap.add(points[i]);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        // Return all points stored in the max PQ
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i] = maxHeap.poll();
        }
        return answer;
    }

    public Integer distanceFromOrigin(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
