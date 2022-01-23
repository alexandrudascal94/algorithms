import java.util.Arrays;

public class MergeIntervals_MeetingRooms {

    // Given and array of meeting time intervals [start, end], determine if a person can attend the meeting
    //
    public boolean canAttendMeetings(int[][] intervals){
        Arrays.sort(intervals, (a,b) ->{
         return  Integer.compare(a[0], b[0]);
        });

        for(int i = 0; i < intervals.length - 1; i++) {
            var cur = intervals[i];
            var next = intervals[i + 1];
            if (cur[1] > next[0]) {
                return false;
            }
        }
        return true;
    }
}
