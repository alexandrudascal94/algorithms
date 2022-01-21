import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {

    // Sort the array
    // compare the next_begining, current_end -> merge or not
    public int[][] merge(int[][] intervals) {

        // compare the beginings
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        //iterate and merge
        // [1,3], [2,6] [5, 8]
        for(int i = 1; i < intervals.length; i++){
            int[] currentInterval = result.getLast();
            int[] nextInterval = intervals[i];

            if(nextInterval[0] <= currentInterval[1]){
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            }
            else{
                result.add(nextInterval);
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
