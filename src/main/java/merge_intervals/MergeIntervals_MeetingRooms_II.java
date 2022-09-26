package merge_intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeIntervals_MeetingRooms_II {
    // Given an array of meetings time intervals,  find the minimum number of rooms required
    // [[0,30][5,10],[15,20]]
    // result 2
    //_______________
    // Solution: 1. sort,
    //  [[0,30], [5,10],[15,20] [29, 35] ]
    // [[5,10],[15,20] [0,30]] 3 room
    public int minMeetingRooms(int[][] intervals){
        Arrays.sort(intervals, (a, b) ->{
            return  Integer.compare(a[0], b[0]);
        });

        var rooms = new PriorityQueue<int[]>( (a, b) ->  Integer.compare(a[1], b[1]));
        rooms.add(intervals[0]);

        for (int i = 1; i <  intervals.length; i++){
            var curr = intervals[i];
            var prev = rooms.poll();
            if(intervals[i][0] < rooms.poll()[1]){
                rooms.add(prev);
                rooms.add(curr);
            }else{
                prev[1] = curr[1];
                rooms.add(prev);
            }
        }
        return rooms.size();
    }

}
