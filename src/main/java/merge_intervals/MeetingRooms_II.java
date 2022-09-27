package merge_intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/meeting-rooms-ii/
 * Given an array of meeting time intervals consisting of start and end
 * times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 * Input:
 * [[0, 30],[5, 10],[15, 20]]
 * Output:
 *  2
 *
 *  Solution:
 *  1. Use a maxHeap to know what is the meeting finishes later
 *  2. For each new meeting is the meeting start later than the end of the latest meeting increase the end maximum room
 *  3. if the new meeting overlap ad it to the roms maxHeap, because it needs a new meeting.
 *  at the end return the size of the meeting heap.
 */
public class MeetingRooms_II {
    public int minMeetingRooms(int[][] intervals){
        Arrays.sort(intervals, (a, b) ->{
            return  Integer.compare(a[0], b[0]);
        });

        var rooms = new PriorityQueue<int[]>( (a, b) ->  Integer.compare(a[1], b[1]));
        rooms.add(intervals[0]);

        for (int i = 1; i <  intervals.length; i++){
            var currentMeeting = intervals[i];
            var latestMeeting = rooms.peek();
            //
            if(currentMeeting[0] < latestMeeting[1]){
                rooms.add(currentMeeting);
            }else{
                latestMeeting[1] = currentMeeting[1];
                rooms.poll();
                rooms.add(latestMeeting);
            }
        }
        return rooms.size();
    }

}
