import java.util.ArrayList;
import java.util.List;

public class MergeIntervals_IntervalListIntersection {
    //https://leetcode.com/problems/interval-list-intersections/

    // compare 2 elemnts be start
    //
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0){
            return new int[0][];
        }

        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while(i < firstList.length && j < secondList.length){
            int min = Math.min(firstList[i][1], secondList[j][1]);
            int max = Math.max(firstList[i][0], secondList[j][0]);

            if(max <= min){
                result.add(new int[]{max, min});
            }

            if(firstList[i][1] < secondList[j][1]){
                i++;
            }
            else{
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
