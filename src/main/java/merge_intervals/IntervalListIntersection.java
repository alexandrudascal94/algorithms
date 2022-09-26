package merge_intervals;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/interval-list-intersections/
 *
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
 * and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 *
 */
public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][];
        }

        List<int[]> result = new ArrayList<>();
        int firstIdx = 0;
        int secondIdx = 0;

        while (firstIdx < firstList.length &&
                secondIdx < secondList.length) {
            // min of the end of intervals
            int min = Math.min(firstList[firstIdx][1], secondList[secondIdx][1]);
            // max of the start of intervals
            int max = Math.max(firstList[firstIdx][0], secondList[secondIdx][0]);

            // if is a valid interval add it
            if (max <= min) {
                result.add(new int[]{max, min});
            }
            // because one interval can intersect will multiple
            // we move to the next where teh ned is smallest
            if (firstList[firstIdx][1] < secondList[secondIdx][1]) {
                firstIdx++;
            } else {
                secondIdx++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
