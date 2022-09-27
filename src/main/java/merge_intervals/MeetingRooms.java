package merge_intervals;

import java.util.Arrays;

/***
 * Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person could attend all meetings.
 *
 * For example,
 * Given [ [0, 30], [5, 10], [15, 20] ],
 * return false.
 *
 * Solution:
 * 1. Sort the meeting by the meeting start
 * 3. if there are any overlapping between the current end and next start return false
 */
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            var currentEnd = intervals[i][1];
            var nextStart = intervals[i + 1][0];
            if (currentEnd > nextStart) {
                return false;
            }
        }
        return true;
    }
}
